package hr.editors;

import java.beans.PropertyEditorSupport;
import hr.biljeznica.Biljeznica;
import hr.jdbc.repositories.BiljeznicaRepository;

public class BiljeznicaEditor extends PropertyEditorSupport {
	
	private BiljeznicaRepository biljeznicaRepository;
	
	public BiljeznicaEditor(BiljeznicaRepository biljeznicaRepository) {
		this.biljeznicaRepository = biljeznicaRepository;
	}
	
	public void setAsText(String text)
	{
		Biljeznica b = null;
		for(Biljeznica biljeznica : biljeznicaRepository.findAll())
		{
			if(biljeznica.getNaziv().equals(text))
			{
				b = biljeznica;
				break;
			}
		}
		
		this.setValue(b);
	}
	
	public String getAsText()
	{
		Biljeznica b = (Biljeznica)this.getValue();
		return (b != null ? b.getNaziv() : " ");
	}
}
