package hr.biljeznica;

public class Korisnik {
	
	private Integer korisnikId;
	private String korisnickoIme;
	private String imeKorisnika;
	private String prezimeKorisnika;
	private String punoIme;

	public Korisnik(Integer korisnikId, String korisnickoIme, String imeKorisnika, String prezimeKorisnika) {
		super();
		this.korisnikId = korisnikId;
		this.korisnickoIme = korisnickoIme;
		this.imeKorisnika = imeKorisnika;
		this.prezimeKorisnika = prezimeKorisnika;
		this.punoIme = imeKorisnika + " " + prezimeKorisnika;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Integer korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public String getPrezimeKorisnika() {
		return prezimeKorisnika;
	}

	public void setPrezimeKorisnika(String prezimeKorisnika) {
		this.prezimeKorisnika = prezimeKorisnika;
	}
	
	public String getPunoIme() {
		return punoIme;
	}

	public void setPunoIme(String punoIme) {
		this.punoIme = punoIme;
	}
}
