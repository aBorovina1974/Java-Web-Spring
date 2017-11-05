package hr.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
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

@Controller
@SessionAttributes({"novaBiljeskaForm", "brojac", "loggedUser"})
public class BiljeskaController {

  @GetMapping(value="/novaBiljeska")
  public String showNovaBiljeskaForm(Model model, Principal principal,
  @ModelAttribute("novaBiljeskaForm") NovaBiljeskaForm novaBiljeskaForm)
  { 
	  if(novaBiljeskaForm.getKorisnik() == null)
	  {
		  for (Korisnik korisnik : EntitetiHelper.getKorisnikList()) 
		  {
			  if(korisnik.getKorisnickoIme().equals(principal.getName()))
			  {
			  novaBiljeskaForm.setKorisnik(korisnik);
			  break;
			  }
			  
	      }
		  
      }
	  
	  model.addAttribute("loggedUser", principal.getName());
	  model.addAttribute("korisnici", EntitetiHelper.getKorisnikList());
	  model.addAttribute("biljeznice", EntitetiHelper.getBiljeznicaList());
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
 	 Biljeska biljeska = new Biljeska();
 	 biljeska.setNaslov(novaBiljeskaForm.getNaslovBiljeske());
 	 biljeska.setText(novaBiljeskaForm.getText());
 	 biljeska.setKorisnik(novaBiljeskaForm.getKorisnik());
 	 biljeska.setBiljeznica(novaBiljeskaForm.getBiljeznica());
 	 
 	 model.addAttribute("biljeska", biljeska);
 	 
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
  
  @ModelAttribute("novaBiljeskaForm") 
  public NovaBiljeskaForm getNovaBiljeskaForm()
  {
	  return new NovaBiljeskaForm();
  }
  
  @ModelAttribute("brojac")
  public Map<String, Integer> getBrojac()
  {
	  Map<String, Integer> brojac = new HashMap<>();
	  for(Biljeznica biljeznica : EntitetiHelper.getBiljeznicaList())
	  {
		  brojac.put(biljeznica.getNaziv(), 0);
	  }
	  return brojac;
  }
  
  @InitBinder
  public void dataBinding(WebDataBinder binder)
  {
	  binder.registerCustomEditor(Korisnik.class, new KorisnikEditor());
	  binder.registerCustomEditor(Biljeznica.class, new BiljeznicaEditor());
  }
}
