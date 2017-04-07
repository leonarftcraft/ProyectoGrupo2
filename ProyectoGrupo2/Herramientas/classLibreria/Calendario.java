package classLibreria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class Calendario {
	
	public JDatePanelImpl datePanel;
	public SqlDateModel model;
	public JDatePickerImpl datePicker;
	
	public JDatePanelImpl GetCalendario(){
		String fe[]=getFechaActual().split("-");
		    model = new SqlDateModel();
			model.setDate(Integer.parseInt(fe[0]), Integer.parseInt(fe[1])-1, Integer.parseInt(fe[2]));
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
	public String getFechaActual(){
		Calendar fechaAc = new GregorianCalendar();
		int anio = fechaAc.get(Calendar.YEAR);
        int mes = fechaAc.get(Calendar.MONTH);
        int dia = fechaAc.get(Calendar.DAY_OF_MONTH);
		
        String m =null, d=null;
        
        if((mes+1)>9){
        	m=String.valueOf(mes+1);
        }else{
        	m="0"+String.valueOf(mes+1);
        }
        if((dia)>9){
        	d=String.valueOf(dia);
        }else{
        	d="0"+String.valueOf(dia);
        }
		String fechAct = anio+"-"+m+"-"+d;
	return fechAct;
	}
}
