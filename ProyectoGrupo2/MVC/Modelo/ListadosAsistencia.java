package Modelo;

import java.awt.Dialog.ModalExclusionType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vista.VistaRegistrarCalendarioAcademico;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ListadosAsistencia extends Asistencia{
	ClaseConection co = new ClaseConection();
	
	public ListadosAsistencia(VistaRegistrarCalendarioAcademico regCaleAca, String cedu) {
		super(regCaleAca, cedu);
	}

	public void ListarAsistencia(DefaultTableModel modelo, int filasTabla, String comSql, String fec){
		String sql="select pers.cedu as a, pers.nomb as b, pers.apel as c, asispers.horaEntr as d, "
				+ "asispers.horaSali as e, asispers.horaPerd as f, horaJust.cantHora as g from asispers "
				+ "INNER JOIN pers ON asispers.fk_pers=pers.id "
				+ "INNER JOIN horaJust ON asispers.fk_horaJust=horaJust.id "
				+ ""+comSql+"";	

		//borra todas las filas de la tabla, 
		try {

			for (int i = 0; filasTabla > i; i++) {
				modelo.removeRow(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		}
		
		//se genera la conexion con mysql pasandole la contraseña del mismo
		co.GetConexion("1323027");
		// se crea un objeto tipo resultset y se le pasa lo que se obtiene del metodo getdatos
		//nota: el metodo getdatos necesita una sentencia sql ella debe benir cuando se instancie el metodo llenartabla
		ResultSet f = co.GetDatos(sql);	
		
		
		try {
			while (f.next()) {
							
		//se crea un objeto con espacion mayor a la cantida de columnas que tenga nuestra tabla
				Object[] colum = new Object[11];
			int inTo= f.getInt("f")-f.getInt("g");
			
				//se aguarda cada dato obtenido de mysql en columnas
				colum[0]=f.getString("a");
				colum[1]=f.getString("b");
				colum[2]=f.getString("c");
				colum[3]=f.getString("d");
				colum[4]=f.getString("e");
				colum[5]=String.valueOf(getHoraLaborales(f.getString("a"), fec));
				
				colum[6]=f.getString("f");
				colum[7]=f.getString("g");
				colum[8]=String.valueOf(inTo);
				
			
				//se le pasa los datos guardados al modelo de la tabla
				modelo.addRow(colum);	
							
				
				//nota: este procedimiento se repite segun el numero de filas que esten guardadas en la BD
			}

		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(null, "Error al buscar datos");
		}
		//se cierra la conexion mysql
		
		co.SetCloseConexion();
		
	}
	public void ExportarListarAsistencia(JRTableModelDataSource jrtmd, String carg, String fech){
		try {
			JasperReport nuestroreporte = null; 
			Map parametro = new HashMap(); 
			parametro.put("carg", carg);
			parametro.put("fecha", fech);
			nuestroreporte = (JasperReport) JRLoader.loadObject(ListadosAsistencia.class.getResource("/Plantillas/ListadoAsistencia.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(nuestroreporte, parametro, jrtmd); 

			JasperViewer vi = new JasperViewer(jasperPrint, false);
			vi.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			vi.setVisible(true);
			vi.setTitle("LISTADO DEl PERSONAL");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} 
		
		
	}
	
	
	public void ListarSancionados(){
		
	}
	
	public void ListarAsistenciaIndividual(){
		
	}
	
	
	public void ExportarListarSancionados(){
		
	}
	
	public void ExportarListarAsistenciaIndividual(){
		
	}
	
}
