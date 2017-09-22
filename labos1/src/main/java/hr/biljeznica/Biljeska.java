package hr.biljeznica;

public class Biljeska {

	private String naslov;
	private String text;
	private Korisnik korisnik;
	private Biljeznica biljeznica;
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Biljeznica getBiljeznica() {
		return biljeznica;
	}
	public void setBiljeznica(Biljeznica biljeznica) {
		this.biljeznica = biljeznica;
	}
	
	
}
