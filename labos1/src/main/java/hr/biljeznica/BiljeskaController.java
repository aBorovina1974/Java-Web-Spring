package hr.biljeznica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BiljeskaController {
	
  @GetMapping(value="/novaBiljeska")
  public String showNovaBiljeskaForm(Model model)
  {
	model.addAttribute("korisnici", EntitetiHelper.getKorisnikList());
	model.addAttribute("biljeznice", EntitetiHelper.getBiljeznicaList());
	model.addAttribute("novaBiljeskaForm", new NovaBiljeskaForm());
	return "novaBiljeska";
  }
  
  @PostMapping(value="/novaBiljeska")
  public String processNovaBiljeskaForm(@ModelAttribute NovaBiljeskaForm novaBiljeskaForm, 
		                                @ModelAttribute Biljeska biljeska)
  {
 	 Korisnik biljeskaKorisnik = null;
 	 for(Korisnik korisnik : EntitetiHelper.getKorisnikList())
 	 {
 		 if(korisnik.getKorisnikId().equals(Integer.parseInt(novaBiljeskaForm.getKorisnikId())))
 		 {
 			 biljeskaKorisnik = korisnik;
 			 System.out.println(biljeskaKorisnik);
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
 	 biljeska.setNaslov(novaBiljeskaForm.getNaslovBiljeske());
 	 biljeska.setText(novaBiljeskaForm.getText());
 	 biljeska.setKorisnik(biljeskaKorisnik);
 	 biljeska.setBiljeznica(biljeskaBiljeznica);
 	 
 	 return "biljeska";
  }
}
