package classLibreria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class Calendario {
	
	public JDatePanelImpl datePanel;
	public SqlDateModel model;
	public JDatePickerImpl datePicker;
	
	public JDatePanelImpl GetCalendario(){
		
		    model = new SqlDateModel();
			model.setDate(1980, 01, 15);
			model.setSelected(false);

			Properties p = new Properties();
			p.put("text.today", "Hoy");
			
		    datePanel = new JDatePanelImpl(model, p);
		   
		    
			return datePanel;
	}
	public JDatePanelImpl GetCalendario1(){
		
	    model = new SqlDateModel();
		model.setDate(2016, 8, 24);
		model.setSelected(false);

		Properties p = new Properties();
		p.put("text.today", "Hoy");
		
	    datePanel = new JDatePanelImpl(model, p);
	   
	    
		return datePanel;
}
}
