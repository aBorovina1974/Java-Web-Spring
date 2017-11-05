package hr.editors;

import java.beans.PropertyEditorSupport;

import hr.biljeznica.EntitetiHelper;
import hr.biljeznica.Korisnik;

public class KorisnikEditor extends PropertyEditorSupport {

	public void setAsText(String text)
	{
		Korisnik k = null;
		for(Korisnik korisnik : EntitetiHelper.getKorisnikList())
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
