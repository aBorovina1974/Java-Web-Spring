package hr.biljeznica;

import java.util.ArrayList;
import java.util.List;

public class EntitetiHelper {
	public static List<Korisnik> getKorisnikList()
	{
		List<Korisnik> korisnikList = new ArrayList<>();
		korisnikList.add(new Korisnik(1, "pperic", "Pero", "Peri�"));
		korisnikList.add(new Korisnik(2, "iivic", "Ivo", "Ivi�"));
		korisnikList.add(new Korisnik(3, "mmarkic", "Marko", "Marki�"));
		return korisnikList;
	}
	
	public static List<Biljeznica> getBiljeznicaList()
	{
		List<Biljeznica> biljeznicaList = new ArrayList<>();
		biljeznicaList.add(new Biljeznica("Web aplikacije u Javi", "Biljeske vezane uz Spring framework"));
		biljeznicaList.add(new Biljeznica("Razvoj aplikacija na Android platformi", "Biljeske vezane uz Android platformu"));
		biljeznicaList.add(new Biljeznica("Napredne teme ra�unalnih mre�a", "Bilje�ke vezane uz ra�unalne mre�e"));
		return biljeznicaList;
	}
}
