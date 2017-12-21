package hr.biljeznica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Korisnik implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column(name="id")
	private Integer korisnikId;
	
	@Column(name="username")
	private String korisnickoIme;
	
	@Column(name="ime")
	private String imeKorisnika;
	
	@Column(name="prezime")
	private String prezimeKorisnika;
	
	public Korisnik()
	{
		
	}

	public Korisnik(Integer korisnikId, String korisnickoIme, String imeKorisnika, String prezimeKorisnika) {
		this.korisnikId = korisnikId;
		this.korisnickoIme = korisnickoIme;
		this.imeKorisnika = imeKorisnika;
		this.prezimeKorisnika = prezimeKorisnika;
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
	
}
