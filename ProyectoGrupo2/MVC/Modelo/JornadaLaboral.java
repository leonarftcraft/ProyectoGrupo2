package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import Vista.panelRegistrarPersonal;

public class JornadaLaboral extends Personal{
	
	private JComboBox InterHora;

	public JornadaLaboral(panelRegistrarPersonal panRegPers) {
		super(panRegPers);
		
		InterHora =panRegPers.comJornaLabo;
	}
	
	public void Registrar(){
		ClaseConection co = new ClaseConection();
	
		co.GetConexion("1323027");
		String sql = "select id from pers where cedu ='"+Cedula.getText()+"'";
		ResultSet idPers = co.GetDatos(sql);
		
		String id = null;
		try {
			while (idPers.next()) {								
				id=idPers.getString("id");			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String insJor = "insert into jornLabo (fk_pers, fk_inteHora) values ('"+id+"', '"+InterHora.getSelectedIndex()+"')";
		System.out.println(insJor);
		co.SetDatos(insJor);
		
		co.SetCloseConexion();
		
	}
	public void Mostrar(){
		
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		
		String codigo=null;
		
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
		
		String joSql = "select fk_inteHora as a from jornLabo where id ='"+codigo+"'";
		ResultSet jS = co.GetDatos(joSql);
		try {
			while(jS.next()){
				InterHora.setSelectedIndex(jS.getInt("a"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		co.SetCloseConexion();
	}
	public void Modificar(String Ceid){
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		String joSql = "select id as a from pers where cedu ='"+Ceid+"'";
		ResultSet jS = co.GetDatos(joSql);
		
		String ce =null;
		try {
			while(jS.next()){
				ce = jS.getString("a");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String sql = "update jornLabo set fk_inteHora = '"+InterHora.getSelectedIndex()+"' where fk_pers='"+ce+"'";
		co.SetDatos(sql);
		
		co.SetCloseConexion();
	}
	public void limpiar(){
		InterHora.setSelectedIndex(0);	
	}
}
