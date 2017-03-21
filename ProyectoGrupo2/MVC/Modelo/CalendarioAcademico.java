package Modelo;

import static javax.swing.JOptionPane.showInputDialog;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTextField;

import Vista.VistaRegistrarCalendarioAcademico;
import classLibreria.JDatePickerImpl;

public class CalendarioAcademico {
	
	private JDatePickerImpl fechaIncio;
	private JDatePickerImpl fechaFin;
	private ClaseConection co = new ClaseConection();
	public CalendarioAcademico(VistaRegistrarCalendarioAcademico regCaleAca) {
		
		this.fechaIncio = regCaleAca.textFechInci;
		this.fechaFin = regCaleAca.textFechFin;
	}

	public boolean getValido(){
		boolean VA = false;
		
		co.GetConexion("1323027");
		
		String sqlCale1 = "select FechInic as a, FechFin as b from caleAcad";
		ResultSet Ca1 = co.GetDatos(sqlCale1);
		String fechIni[], fechFin[];
		
		try {
			while(Ca1.next()){
				fechIni = Ca1.getString("a").split("-");
				fechFin = Ca1.getString("b").split("-");
				String an[], an1[];
				
				an = fechIni[0].split("0");
				an1 = fechFin[0].split("0");
			
				
				try {
					DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
					Date reFechIni, reFechFin, fechActual;
					reFechIni = (f.parse(fechIni[2]+"/"+fechIni[1]+"/"+an[1]));
					reFechFin = (f.parse(fechFin[2]+"/"+fechFin[1]+"/"+an1[1]));
					
				
					
					Calendar cal1 = new GregorianCalendar();
					cal1.setTime(reFechIni);
					Calendar cal2 = new GregorianCalendar();
					cal2.setTime(reFechFin);
					
					
					Calendar fechaAc = new GregorianCalendar();
					int anio = fechaAc.get(Calendar.YEAR);
			        int mes = fechaAc.get(Calendar.MONTH);
			        int dia = fechaAc.get(Calendar.DAY_OF_MONTH);
					
			        String m =null, d = null;
			        
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
				
			        fechActual = f.parse(d+"/"+m+"/"+(anio-2000));
					Calendar cal3 = new GregorianCalendar();
					cal3.setTime(fechActual);
					
					if (cal3.after(cal1) && cal3.before(cal2)){
						VA=true;
					}else{
						if(Ca1.getString("b").equals(anio+"-"+m+"-"+dia)){
							VA=true;
						}
						if(Ca1.getString("a").equals(anio+"-"+m+"-"+dia)){
							VA=true;
						}
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		co.SetCloseConexion();	
		return VA;
		
	}

	public void setVacios(){
		fechaIncio.getJFormattedTextField().setText("");
		fechaFin.getJFormattedTextField().setText("");
	}
	public void Registrar(){
		co.GetConexion("1323027");
		
		String sqlSet = "insert into caleAcad (fechInic, fechFin) values ('"+fechaIncio.getJFormattedTextField().getText()+"', '"+fechaFin.getJFormattedTextField().getText()+"')";
		co.SetDatos(sqlSet);
		
		co.SetCloseConexion();
	}
	public void Modificar(){
		co.GetConexion("1323027");
		String sql = "select count(*) as a from caleAcad";
		ResultSet i = co.GetDatos(sql);
		String sqlUpd=null;
		try {
			while(i.next()){
				sqlUpd = "update caleAcad set fechInic='"+fechaIncio.getJFormattedTextField().getText()+"', fechFin='"+fechaFin.getJFormattedTextField().getText()+"' where id ='"+i.getString("a")+"'";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		co.SetDatos(sqlUpd);
			
		co.SetCloseConexion();
	}
	
	public int getIdCalenAcademico(){
		
		co.GetConexion("1323027");
		String sql = "select count(*) as a from caleAcad";
		ResultSet i = co.GetDatos(sql);
		int sqlUpd=0;
		try {
			while(i.next()){
				sqlUpd =i.getInt("a");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		co.SetCloseConexion();
		return sqlUpd;
	}
	public String[] Mostrar(){
		
		co.GetConexion("1323027");
		String fech[] = new String[3];
		
		String sql = "select fechInic as a, fechFin as b from caleAcad";
		ResultSet geSql= co.GetDatos(sql);	
		try {
			while(geSql.next()){
				
				fech[0]=geSql.getString("a");
				fech[1]=geSql.getString("b");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		co.SetCloseConexion();
		return fech;
	}
	
}
