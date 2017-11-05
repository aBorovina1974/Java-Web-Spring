package hr.editors;

import java.beans.PropertyEditorSupport;

import hr.biljeznica.Biljeznica;
import hr.biljeznica.EntitetiHelper;

public class BiljeznicaEditor extends PropertyEditorSupport {
	
	public void setAsText(String text)
	{
		Biljeznica b = null;
		for(Biljeznica biljeznica : EntitetiHelper.getBiljeznicaList())
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
