package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesion {

	public boolean validaUsuario(String pass, String user){
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		String sql ="select id from logi where pass='"+pass+"' and user='"+user+"'";
		ResultSet fd = co.GetDatos(sql);
		boolean va = false;
		try {
			while(fd.next()){
				
				va=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		co.SetCloseConexion();
		return va;
	}
	
}
