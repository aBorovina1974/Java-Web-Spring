package hr.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import hr.biljeznica.*;
import hr.editors.BiljeznicaEditor;
import hr.editors.KorisnikEditor;
import hr.hibernate.repositories.BiljeznicaRepository;
import hr.hibernate.repositories.KorisnikRepository;
import hr.hibernate.repositories.AuthoritiesRepository;
import hr.hibernate.repositories.BiljeskaRepository;



@Controller
@SessionAttributes({"novaBiljeskaForm", "brojac", "loggedUser"})
public class BiljeskaController {
	
  @Autowired	
  private BiljeznicaRepository biljeznicaRepository;
  
  @Autowired
  private KorisnikRepository korisnikRepository; 
  
  @Autowired
  private BiljeskaRepository biljeskaRepository;
  
  @Autowired
  private AuthoritiesRepository authoritiesRepository;

  @GetMapping(value="/novaBiljeska")
  public String showNovaBiljeskaForm(Model model, Principal principal,
  @ModelAttribute("novaBiljeskaForm") NovaBiljeskaForm novaBiljeskaForm)
  {   
	  if(novaBiljeskaForm.getKorisnik() == null && 
	     !authoritiesRepository.hasAdminRole(principal.getName()))
	  {
		  for (Korisnik korisnik : korisnikRepository.findAll()) 
		  {
			  if(korisnik.getKorisnickoIme().equals(principal.getName()))
			  {
			  novaBiljeskaForm.setKorisnik(korisnik);
			  break;
			  }
			  
	      }
		  
      }
	  model.addAttribute("loggedUser", principal.getName());
	  model.addAttribute("korisnici", korisnikRepository.findAll());
	  model.addAttribute("biljeznice", biljeznicaRepository.findAll());
	  return "novaBiljeska";
  }
  
  @PostMapping(value="/potvrdaSpremanja")
  public String potvrdiSpremanje(Model model,
  @ModelAttribute("novaBiljeskaForm")NovaBiljeskaForm novaBiljeskaForm)
  {
	  return "potvrdaSpremanja";
  }
  
  
  @PostMapping(value="/spremiBiljesku")
  public String spremiBiljesku(Model model,
  @ModelAttribute("brojac") HashMap<String, Integer> brojac,
  @ModelAttribute("novaBiljeskaForm") NovaBiljeskaForm novaBiljeskaForm)
  {
 	 String naslov = novaBiljeskaForm.getNaslovBiljeske();
 	 String text = novaBiljeskaForm.getText();
 	 Korisnik korisnik = novaBiljeskaForm.getKorisnik();
 	 Biljeznica biljeznica = novaBiljeskaForm.getBiljeznica();
 	 
 	 Biljeska biljeska1 = new Biljeska(naslov, text, korisnik, biljeznica);
 	 biljeska1.setBiljeznica(biljeznica);
 	 Biljeska biljeska2 = biljeskaRepository.save(biljeska1);
 	 model.addAttribute("biljeska", biljeska2);
 	 
 	 for(String nazivBiljeznice : brojac.keySet())
 	 {
 		 if(nazivBiljeznice.equals(novaBiljeskaForm.getBiljeznica().getNaziv()))
 		 {
 			 brojac.put(nazivBiljeznice, brojac.get(nazivBiljeznice) + 1);
 		 }
 	 }
 	 
 	 return "biljeska";
  }
  
  
  @GetMapping(value="/napraviNovuBiljesku")
  public String napraviNovuBiljesku(Model model)
  {
	  model.addAttribute("novaBiljeskaForm", new NovaBiljeskaForm());
	  return "redirect:/novaBiljeska";
  }
  
  @GetMapping(value="/obrisiStatistiku")
  public String obrisiStatistiku(SessionStatus status)
  {
	  status.setComplete();
	  return "redirect:/novaBiljeska";
  }
  
  @GetMapping(value="/pregledBiljeski")
  public String pregledajBiljeske(Model model, Principal principal)
  {
	  List<Biljeska> biljeske = null;
	  if(authoritiesRepository.hasAdminRole(principal.getName()))
	  {
	  biljeske = biljeskaRepository.findAll();
	  }
	  else
	  {
	  biljeske = biljeskaRepository.findAllByKorisnickoIme(principal.getName());
	  }
	  model.addAttribute("biljeske", biljeske);
	  return "pregledBiljeski";
  }
  
  @ModelAttribute("novaBiljeskaForm") 
  public NovaBiljeskaForm getNovaBiljeskaForm()
  {
	  return new NovaBiljeskaForm();
  }
  
  @ModelAttribute("brojac")
  public Map<String, Integer> getBrojac()
  {
	  Map<String, Integer> brojac = new HashMap<>();
	  for(Biljeznica biljeznica : biljeznicaRepository.findAll())
	  {
		  brojac.put(biljeznica.getNaziv(), 0);
	  }
	  return brojac;
  }
  
  @InitBinder
  public void dataBinding(WebDataBinder binder)
  {
	  binder.registerCustomEditor(Korisnik.class, new KorisnikEditor(korisnikRepository));
	  binder.registerCustomEditor(Biljeznica.class, new BiljeznicaEditor(biljeznicaRepository));
  }
}
