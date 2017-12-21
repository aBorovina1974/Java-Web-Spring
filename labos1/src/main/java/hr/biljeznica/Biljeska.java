package hr.biljeznica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="biljeska")
public class Biljeska implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue
	@Column(name="id")
	private Integer biljeskaId;
	
	@Column(name="naslov")
	private String naslov;
	
	@Column(name="tekst")
	private String text;
	 
	@OneToOne
	@JoinColumn(name="biljeznica")
	private Biljeznica biljeznica;
	
	@OneToOne
	@JoinColumn(name="korisnik")
	private Korisnik korisnik;
	

	public Biljeska()
	{
		
	}
	
	public Biljeska(String naslov, String text, 
			        Korisnik korisnik, Biljeznica biljeznica) 
	{
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
