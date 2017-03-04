package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Vista.panelRegistrarPersonal;

public class CargaHoraria extends Personal{
	
	private String codigo = null;
	private DefaultTableModel horario;
	
	public CargaHoraria(panelRegistrarPersonal panRegPers) {
		super(panRegPers);
	}
	
	public void Modificar(DefaultTableModel horario){
	
		this.horario= horario;
		
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		
		
		
		String idPers = "select id from pers where cedu = '"+Cedula.getText()+"'";
		
		ResultSet opId = co.GetDatos(idPers);
		
		try {
			while(opId.next()){
				codigo = opId.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Dele = "DELETE FROM cargHora WHERE fk_pers = '"+codigo+"'";
		co.SetDatos(Dele);
		
		for(int a=0; a<=10; a++){
			
			
			for(int b=1; b<=5; b++){
				
				
				if((Boolean)this.horario.getValueAt(a, b)){
					
					String sqHor = "insert into cargHora (fk_diasLabo, fk_horaLabo, fk_pers) values ('"+b+"', '"+(a+1)+"', '"+codigo+"')";
					co.SetDatos(sqHor);
				}
				
				
			}
			
		}
		co.SetCloseConexion();
		
	}
	
	public void Registrar(DefaultTableModel horario){
		
		this.horario= horario;
		
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		
		
		
		String idPers = "select id from pers where cedu = '"+Cedula.getText()+"'";
		
		ResultSet opId = co.GetDatos(idPers);
		
		try {
			while(opId.next()){
				codigo = opId.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int a=0; a<=10; a++){
			
			
			for(int b=1; b<=5; b++){
				
				
				if((Boolean)this.horario.getValueAt(a, b)){
					
					String sqHor = "insert into cargHora (fk_diasLabo, fk_horaLabo, fk_pers) values ('"+b+"', '"+(a+1)+"', '"+codigo+"')";
					co.SetDatos(sqHor);
				}
				
				
			}
			
		}
		co.SetCloseConexion();
	}
	public void Mostrar(DefaultTableModel horario, String Ident){
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		String SqlidPers = "select id from pers where cedu = '"+Ident+"'";
	
		ResultSet idp = co.GetDatos(SqlidPers);
		
		String id = null;
		
		try {
			while(idp.next()){
				id=idp.getString("id");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String SqlCarH = "select fk_diasLabo as a, fk_horaLabo as b from cargHora where fk_pers = '"+id+"'";
		
		ResultSet carHor = co.GetDatos(SqlCarH);
		
		try {
			while(carHor.next()){
				
				horario.setValueAt(true, (carHor.getInt("b")-1), carHor.getInt("a"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		co.SetCloseConexion();
	}
	
	public void Limpiar(DefaultTableModel horario){
		
	for(int a=0; a<=10; a++){
			
	
		
		
			for(int b=1; b<=5; b++){
								
				if((Boolean)horario.getValueAt(a, b)){
					
					horario.setValueAt(false, a, b);
					
				}
								
			}
		}
		
		
	}
	
}
