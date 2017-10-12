package hr.biljeznica;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"novaBiljeskaForm", "brojac"})
public class BiljeskaController {
	
  @GetMapping(value="/novaBiljeska")
  public String showNovaBiljeskaForm(Model model)
  {
	model.addAttribute("korisnici", EntitetiHelper.getKorisnikList());
	model.addAttribute("biljeznice", EntitetiHelper.getBiljeznicaList());
	return "novaBiljeska";
  }
  
  @PostMapping(value="/potvrdaSpremanja")
  public String potvrdiSpremanje(Model model, @ModelAttribute("novaBiljeskaForm")NovaBiljeskaForm novaBiljeskaForm)
  {
	  
	  for(Korisnik korisnik : EntitetiHelper.getKorisnikList())
	  {
		  if(korisnik.getKorisnikId().equals(Integer.parseInt(novaBiljeskaForm.getKorisnikId())))
		  {
			 String punoIme = korisnik.getPunoIme();
			 model.addAttribute("punoIme", punoIme);
		  }
	  }
	  return "potvrdaSpremanja";
  }
  
  
  @PostMapping(value="/spremiBiljesku")
  public String spremiBiljesku(Model model, @ModelAttribute("novaBiljeskaForm") NovaBiljeskaForm novaBiljeskaForm,
		                       @ModelAttribute("brojac") HashMap<String, Integer> brojac)
  {
 	 Korisnik biljeskaKorisnik = null;
 	 for(Korisnik korisnik : EntitetiHelper.getKorisnikList())
 	 {
 		 if(korisnik.getKorisnikId().equals(Integer.parseInt(novaBiljeskaForm.getKorisnikId())))
 		 {
 			 biljeskaKorisnik = korisnik;
 			 break;
 		 }
 	 }
 	 
 	 Biljeznica biljeskaBiljeznica = null;
 	 for(Biljeznica biljeznica : EntitetiHelper.getBiljeznicaList())
 	 {
 		 if(biljeznica.getNaziv().equals(novaBiljeskaForm.getNazivBiljeznice()))
 		 {
 			 biljeskaBiljeznica = biljeznica;
 			 break;
 		 }
 	 }
 	 
 	 Biljeska biljeska = new Biljeska();
 	 biljeska.setNaslov(novaBiljeskaForm.getNaslovBiljeske());
 	 biljeska.setText(novaBiljeskaForm.getText());
 	 biljeska.setKorisnik(biljeskaKorisnik);
 	 biljeska.setBiljeznica(biljeskaBiljeznica);
 	 
 	 model.addAttribute("biljeska", biljeska);
 	 
 	 for(String nazivBiljeznice : brojac.keySet())
 	 {
 		 if(nazivBiljeznice.equals(biljeskaBiljeznica.getNaziv()))
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
}
