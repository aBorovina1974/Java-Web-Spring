package hr.biljeznica;

public class NovaBiljeskaForm {
	
	private String korisnikId;
	private String nazivBiljeznice;
	private String naslovBiljeske;
	private String text;
	
	public NovaBiljeskaForm()
	{
		
	}
	
	public String getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(String korisnikId) {
		this.korisnikId = korisnikId;
	}
	public String getNazivBiljeznice() {
		return nazivBiljeznice;
	}
	public void setNazivBiljeznice(String nazivBiljeznice) {
		this.nazivBiljeznice = nazivBiljeznice;
	}
	public String getNaslovBiljeske() {
		return naslovBiljeske;
	}
	public void setNaslovBiljeske(String naslovBiljeske) {
		this.naslovBiljeske = naslovBiljeske;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
