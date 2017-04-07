package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Justificaciones {
	private String cedula;
	private String fec;
	private String hora;
	private String opser;
	
	public Justificaciones(String opser, String hora, String cedula, String fec) {
		this.cedula = cedula;
		this.fec = fec;
		this.hora=hora;
		this.opser=opser;
	}
	public Justificaciones(String cedula, String fec) {
		this.cedula = cedula;
		this.fec = fec;
	}
	public String getJustificacion(){
		ClaseConection co = new ClaseConection();
		String jus=null;
		co.GetConexion("1323027");
		String ops = "select just as a from horaJust "
				+ "INNER JOIN asispers ON asispers.fk_horaJust=horaJust.id "
				+ "INNER JOIN pers ON asispers.fk_pers=pers.id where pers.cedu='"+cedula+"' and asispers.fech='"+fec+"'";
		ResultSet fe = co.GetDatos(ops);
		try {
			while(fe.next()){
				jus=fe.getString("a");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		co.SetCloseConexion();
		return jus;
	}
	public void RegistrarJustificacion(){
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		String sql="select id from pers where cedu='"+cedula+"'";
		System.out.println(sql);
		ResultSet df = co.GetDatos(sql);
		String idPer=null;
		try {
			while(df.next()){
				
				idPer=df.getString("id");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ins = "insert into horaJust (cantHora, just) values ('"+hora+"', '"+opser+"')";
		co.SetDatos(ins);
		String idJus="select count(*) as a from horaJust";
		ResultSet ge = co.GetDatos(idJus);
		String idJ=null;
		try {
			while(ge.next()){
				idJ=ge.getString("a");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String pp ="update asispers set "
				+ "fk_horaJust='"+idJ+"' "
				+ "where fech='"+fec+"' and fk_pers='"+idPer+"'";
		System.out.println(pp);

		co.SetDatos(pp);
		
		
		
		co.SetCloseConexion();
	}
}
