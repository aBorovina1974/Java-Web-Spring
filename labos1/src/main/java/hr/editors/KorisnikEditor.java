package hr.editors;

import java.beans.PropertyEditorSupport;
import hr.biljeznica.Korisnik;
import hr.jdbc.repositories.KorisnikRepository;

public class KorisnikEditor extends PropertyEditorSupport {
	
	private KorisnikRepository korisnikRepository;
	
	public KorisnikEditor(KorisnikRepository korisnikRepository) {
		this.korisnikRepository = korisnikRepository;
	}

	public void setAsText(String text)
	{
		Korisnik k = null;
		for(Korisnik korisnik : korisnikRepository.findAll())
		{
			if(korisnik.getKorisnikId().equals(Integer.parseInt(text)))
			{
				k = korisnik;
				break;
			}
		}
		
		this.setValue(k);
	}
	
	public String getAsText()
	{
		Korisnik k = (Korisnik)this.getValue();
		return(k != null ? k.getKorisnikId().toString() : " ");
	}
}
