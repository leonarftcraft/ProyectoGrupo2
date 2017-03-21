package Modelo;

import java.awt.Dialog.ModalExclusionType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.ClaseConection;
import Vista.panelRegistrarPersonal;
import classLibreria.JDatePickerImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Personal {
private JTextField Nombre;
private JTextField Apellido;
public JTextField Cedula;
private JTextField Telefono;
private JComboBox Cargo;
private JComboBox Sexo;
private JComboBox Status;
private JDatePickerImpl FechaNacimiento;
private ClaseConection co = new ClaseConection();
public String Ident;

public Personal(panelRegistrarPersonal panRegPers){
	
	this.Nombre = panRegPers.textNombre;
	this.Apellido = panRegPers.textApellido;
	this.Cedula = panRegPers.textCedula;
	this.Telefono = panRegPers.textTelef;
	this.Cargo = panRegPers.comCargo;
	this.FechaNacimiento = panRegPers.textFecNaci;
	this.Status = panRegPers.comStatus;
	this.Sexo = panRegPers.comSexo;
}
public Personal(){
	
}

public void generarListado(JRTableModelDataSource jrtmd, String carg){
	
	try {
		JasperReport nuestroreporte = null; 
		Map parametro = new HashMap(); 
		parametro.put("carg", carg);
		nuestroreporte = (JasperReport) JRLoader.loadObject(Personal.class.getResource( "/Plantillas/Blank_Letter.jasper"));
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


public void Registrar(){
	String FilNaci;
	

	co.GetConexion("1323027");
	
	if(FechaNacimiento.getJFormattedTextField().getText().equals("")){
		FilNaci = "0001-01-01";
	}else{
		FilNaci = FechaNacimiento.getJFormattedTextField().getText();
	}
	
	String RegPer = "insert into pers (nomb, sexo, apel, cedu, tele, fechNaci, stat, fk_tipoPers) values ("
			+ "'"+Nombre.getText()+"', '"+Sexo.getSelectedItem().toString()+"', '"+Apellido.getText()+"', '"+Cedula.getText()+"', '"+Telefono.getText()+"', "
					+ "'"+FilNaci+"', 'Activo', '"+Cargo.getSelectedIndex()+"'"
			+ ")";

	
	co.SetDatos(RegPer);
	co.SetCloseConexion();
		
}

public void Mostrar(String Ident){
	this.Ident = Ident;
	
	
	co.GetConexion("1323027");
	
	String MosPer = "select nomb, sexo, apel, cedu, tele, fechNaci, stat, fk_tipoPers from pers where cedu = '"+Ident+"'";

	ResultSet op = co.GetDatos(MosPer);
	
	try {
		while(op.next()){
		
			Nombre.setText(op.getString("nomb"));
			Apellido.setText(op.getString("apel"));
			Cedula.setText(op.getString("cedu"));
			Telefono.setText(op.getString("tele"));
			
			for(int a = 0; a<=3; a++){
				Status.setSelectedIndex(a);
				if(Status.getSelectedItem().equals(op.getString("stat"))){
					break;
				}
				
			}
			for(int a = 0; a<=3; a++){
				Sexo.setSelectedIndex(a);
				if(Sexo.getSelectedItem().equals(op.getString("sexo"))){
					break;
				}
				
			}
			Cargo.setSelectedIndex(op.getInt("fk_tipoPers"));
		
			if(!op.getString("fechNaci").equals("0001-01-01")){
				FechaNacimiento.getJFormattedTextField().setText(op.getString("fechNaci"));
			}else{
				FechaNacimiento.getJFormattedTextField().setText("");
			}
			
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	co.SetCloseConexion();

}
public void Modificar(String idPers){
	co.GetConexion("1323027");
	String fec = null;
	if(FechaNacimiento.getJFormattedTextField().getText().equals("")){
		fec="0001-01-01";
	}else{
		fec=FechaNacimiento.getJFormattedTextField().getText();
	}
	
	
	String SqUda = "update pers set "
			+ "nomb='"+Nombre.getText()+"', "
			+ "sexo='"+Sexo.getSelectedItem().toString()+"', "
			+ "apel='"+Apellido.getText()+"', "
			+ "tele='"+Telefono.getText()+"', "
			+ "cedu='"+Cedula.getText()+"', "
			+ "stat='"+Status.getSelectedItem().toString()+"', "
			+ "fechNaci='"+fec+"', "
			+ "fk_tipoPers='"+Cargo.getSelectedIndex()+"' "
			+ "where cedu = '"+idPers+"'";

	co.SetDatos(SqUda);
	
	co.SetCloseConexion();
	
}
public void Listar(DefaultTableModel modelo, String Sql, int filasTabla){
	//se instancia la claseconetion
	ClaseConection Co = new ClaseConection();
	
	//borra todas las filas de la tabla, 
	try {

		for (int i = 0; filasTabla > i; i++) {
			modelo.removeRow(0);
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	}
	
	//se genera la conexion con mysql pasandole la contraseña del mismo
	Co.GetConexion("1323027");
	// se crea un objeto tipo resultset y se le pasa lo que se obtiene del metodo getdatos
	//nota: el metodo getdatos necesita una sentencia sql ella debe benir cuando se instancie el metodo llenartabla
	ResultSet f = Co.GetDatos(Sql);	
	
	
	
	//se invoca el metodo next de la clase resultset para poder recorrer todo los datos obtenidos de mysql
		int contador=0;
	try {
		while (f.next()) {
						
			//se crea un objeto con espacion mayor a la cantida de columnas que tenga nuestra tabla
			Object[] colum = new Object[9];
			
		String nomb[] = f.getString("b").split(" ");
		String apel[] = f.getString("c").split(" ");
		String tem= null;
		
		/*if(!HL.equals("0")){
			tem=HL;
		}else{
			tem=
		}*/
			contador++;
			//se aguarda cada dato obtenido de mysql en columnas
			colum[0] = contador;
			colum[1] = f.getString("a");
			colum[2] = nomb[0];
			colum[3] = apel[0];
			colum[4] = f.getString("d");
			colum[5] = f.getString("e");
		
			//se le pasa los datos guardados al modelo de la tabla
			modelo.addRow(colum);	
				
			
				
			//nota: este procedimiento se repite segun el numero de filas que esten guardadas en la BD
		}

	} catch (SQLException ex) {
		
		JOptionPane.showMessageDialog(null, "Error al buscar datos");
	}
	//se cierra la conexion mysql
	
	Co.SetCloseConexion();
}

public void Limpiar(){
	Nombre.setText("");
	Apellido.setText("");
	Telefono.setText("");
	Cedula.setText("");
	FechaNacimiento.getJFormattedTextField().setText("");
	Cargo.setSelectedIndex(0);
	Status.setSelectedIndex(0);
	Sexo.setSelectedIndex(0);
	
}

}
