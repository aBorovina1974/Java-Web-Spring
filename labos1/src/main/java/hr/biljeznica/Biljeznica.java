package hr.biljeznica;

public class Biljeznica {
	
	private String naziv;
	private String opisSadrzaja;
	
	public Biljeznica(String naziv, String opisSadrzaja)
	{
		this.opisSadrzaja = opisSadrzaja;
		this.naziv = naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpisSadrzaja() {
		return opisSadrzaja;
	}
	public void setOpisSadrzaja(String opisSadrzaja) {
		this.opisSadrzaja = opisSadrzaja;
	}
	
	public String toString()
	{
		return this.getNaziv();
	}
}
