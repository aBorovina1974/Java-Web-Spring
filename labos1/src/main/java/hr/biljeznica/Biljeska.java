package hr.biljeznica;

public class Biljeska {

	private Integer biljeskaId;
	private String naslov;
	private String text;
	private Korisnik korisnik;
	private Biljeznica biljeznica;
	
	
	
	public Biljeska(Integer biljeskaId, String naslov, String text, 
			        Korisnik korisnik, Biljeznica biljeznica) 
	{
		this.biljeskaId = biljeskaId;
		this.naslov = naslov;
		this.text = text;
		this.korisnik = korisnik;
		this.biljeznica = biljeznica;
	}
	public Integer getBiljeskaId() {
		return biljeskaId;
	}
	public void setBiljeskaId(Integer biljeskaId) {
		this.biljeskaId = biljeskaId;
	}
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
