package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import Modelo.Asistencia;
import Modelo.CargaHoraria;
import Modelo.ClaseConection;
import Modelo.JornadaLaboral;
import Modelo.Personal;
import Vista.VistaCargaHorario;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.VistaRegistrarCalendarioAcademico;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;

public class ControladorPanelRegistrarPersonal implements MouseListener, KeyListener, ActionListener, FocusListener{
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	private panelListarPersonal panLisPers;
	private VistaCargaHorario visCarHor;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private String ets;
	
	
	public ControladorPanelRegistrarPersonal(VistaRegistrarCalendarioAcademico regCaleAca, VistaCargaHorario visCarHor, VistaGestionPersonal visGesPer, panelRegistrarPersonal panRegPers, 
			panelListarPersonal panLisPers, String ets) {
	
		this.ets = ets;
		this.visCarHor=visCarHor;
		this.panLisPers=panLisPers;
		this.visGesPer = visGesPer;
		this.panRegPers = panRegPers;
		this.regCaleAca=regCaleAca;
	}
	
	public void mouseEntered(MouseEvent e) {
		if(ets.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(panRegPers.btmGuardar.getWidth(), panRegPers.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmGuardar.setIcon(btmGu);
		}
		if(ets.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(panRegPers.btmAtras.getWidth(), panRegPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmAtras.setIcon(mAt);
		}
		if(ets.equals("btmActualizar")){
		ImageIcon mGu = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-2.png"));
		Icon btmG = new ImageIcon(mGu.getImage().getScaledInstance(panRegPers.btmActualizar.getWidth(), panRegPers.btmActualizar.getHeight(), Image.SCALE_DEFAULT));
		panRegPers.btmActualizar.setIcon(btmG);
		}
	}


	public void mouseExited(MouseEvent e) {
		if(ets.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(panRegPers.btmGuardar.getWidth(), panRegPers.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmGuardar.setIcon(btmGu);
		}
		if(ets.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(panRegPers.btmAtras.getWidth(), panRegPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmAtras.setIcon(mAt);
		}
		if(ets.equals("btmActualizar")){
			ImageIcon mGu = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-1.png"));
			Icon btmG = new ImageIcon(mGu.getImage().getScaledInstance(panRegPers.btmActualizar.getWidth(), panRegPers.btmActualizar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmActualizar.setIcon(btmG);
			}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if (ets.equals("btmGuardar")) {

			if (!panRegPers.textApellido.equals("") && !panRegPers.textNombre.equals("")
					&& !panRegPers.textCedula.equals("") && !panRegPers.textTelef.equals("")
					&& panRegPers.comCargo.getSelectedIndex() != 0 && panRegPers.comSexo.getSelectedIndex() != 0) {

				DefaultTableModel horario = (DefaultTableModel) visCarHor.table.getModel();

				CargaHoraria carRe = new CargaHoraria(panRegPers);
				Personal pers = new Personal(panRegPers);
				JornadaLaboral jona = new JornadaLaboral(panRegPers);
				Asistencia asi = new Asistencia(regCaleAca, null);

				int con = 0;
				for (int a = 0; a <= 12; a++) {

					for (int b = 1; b <= 5; b++) {

						if ((Boolean) horario.getValueAt(a, b)) {

							con++;
						}

					}

				}

				if (panRegPers.comCargo.getSelectedIndex() == 1) {
					if (con >= 6) {

						pers.Registrar();
						carRe.Registrar(horario);
						asi.setRegistroIndivi(panRegPers.textCedula.getText());
						carRe.Limpiar(horario);
						pers.Limpiar();
						JOptionPane.showMessageDialog(null, "Datos almacenados exitosamente", "Mensaje Informativo",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Introduzca carga horaria", "Mensaje Informativo",
								JOptionPane.INFORMATION_MESSAGE);

					}

				} else {

					if (panRegPers.comJornaLabo.getSelectedIndex() != 0) {
						pers.Registrar();
						jona.Registrar();
						asi.setRegistroIndivi(panRegPers.textCedula.getText());
						jona.Limpiar();
						pers.Limpiar();
						JOptionPane.showMessageDialog(null, "Datos almacenados exitosamente", "Mensaje Informativo",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Seleccione jornada laboral", "Mensaje Informativo",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Los campos que tienen asterisco rojo son obligatorios",
						"Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
			}

		}
		
		if(ets.equals("btmAtras")){
			
			visGesPer.dispose();
						
		}
		
		if(ets.equals("btmActualizar")){
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();

			if(visCarHor.table.getSelectedRow()!=-1 ){
				
				if(visCarHor.table.getSelectedColumn()!=0){
					visCarHor.table.clearSelection();				
					visCarHor.table.getCellEditor().stopCellEditing();
				
				}
				
			}
			
			if(!panRegPers.textApellido.equals("")&&!panRegPers.textNombre.equals("")&&!panRegPers.textCedula.equals("")
					&&!panRegPers.textTelef.equals("")&&panRegPers.comCargo.getSelectedIndex()!=0){
				
				
			
				
		
					CargaHoraria carRe = new CargaHoraria(panRegPers);
					Personal pers = new Personal(panRegPers);
					JornadaLaboral jorN = new JornadaLaboral(panRegPers);
					
					DefaultTableModel list=(DefaultTableModel) panLisPers.table.getModel();
					String ident = (String)list.getValueAt(panLisPers.table.getSelectedRow(), 1);
					
					
					pers.Modificar(ident);
					
					if(panRegPers.comCargo.getSelectedIndex()==1){
						if(	panRegPers.btCar==true){
							carRe.Modificar(horario);
						}
						
					}else{
						jorN.Modificar(ident);		
					}
					
					
					int filasTabla = panLisPers.table.getRowCount();

					String Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
							+ "count(cargHora.fk_pers) as e "
							+ "from cargHora INNER JOIN pers ON cargHora.fk_pers=pers.id"
							+ " where pers.stat = 'Activo' and pers.fk_tipoPers='1' group by fk_pers";
				
					pers.Listar(list, Sql, filasTabla);
					JOptionPane.showMessageDialog(null,	"Datos almacenados exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
					panLisPers.comCarg.setSelectedIndex(0);
					panLisPers.comStatu.setSelectedIndex(0);
					panLisPers.textBusca.setText("");
					panLisPers.setVisible(true);
					panRegPers.setVisible(false);
					
				
			}else{
				JOptionPane.showMessageDialog(null, "Los campos que tienen asterisco rojo son obligatorios", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
	
			}
			
		}	
	
	}
		
	public void mouseReleased(MouseEvent e) {
		
		if(ets.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(panRegPers.btmGuardar.getWidth(), panRegPers.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmGuardar.setIcon(btmGu);
		
		}
		if(ets.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(panRegPers.btmAtras.getWidth(), panRegPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmAtras.setIcon(mAt);
		}
		if(ets.equals("btmActualizar")){
			ImageIcon mGu = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-2.png"));
			Icon btmG = new ImageIcon(mGu.getImage().getScaledInstance(panRegPers.btmActualizar.getWidth(), panRegPers.btmActualizar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmActualizar.setIcon(btmG);
			}
	}
		
	public void mousePressed(MouseEvent e) {
		if(ets.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(panRegPers.btmGuardar.getWidth(), panRegPers.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmGuardar.setIcon(btmGu);
		}
		if(ets.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(panRegPers.btmAtras.getWidth(), panRegPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmAtras.setIcon(mAt);
		}
		if(ets.equals("btmActualizar")){
			ImageIcon mGu = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-1.png"));
			Icon btmG = new ImageIcon(mGu.getImage().getScaledInstance(panRegPers.btmActualizar.getWidth(), panRegPers.btmActualizar.getHeight(), Image.SCALE_DEFAULT));
			panRegPers.btmActualizar.setIcon(btmG);
			}
	}

	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(ets.equals("textNombre")){
			
			String tex = panRegPers.textNombre.getText();
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			if(tex.length()<=35){
				
				if((key < 'A' || key > 'Z')&&!(key=='Ñ')&&!(key==' ')){
					
					e.consume();
					
				}
				
				
			}else{
				e.consume();
			}
		
		}
		if(ets.equals("textApellido")){
			
			String tex = panRegPers.textApellido.getText();
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			if(tex.length()<=35){
				
				if((key < 'A' || key > 'Z')&&!(key=='Ñ')&&!(key==' ')){
					
					e.consume();					
				}
								
			}else{
				e.consume();
			}
		
		}
		if(ets.equals("textTelef")){
			
			String tex = panRegPers.textTelef.getText();
			
			if(tex.length()<=11){
				
				if((key < '0' || key > '9')){
					
					e.consume();
					
				}else{
					if((panRegPers.textTelef.getSelectionStart()==3)&&(tex.length()<=3)){
						panRegPers.textTelef.setText(tex+key+"-");
						e.consume();
					}else{
						
						
					}
				}
				
				
			}else{
				e.consume();
			}
			
			
		}
	
		if(ets.equals("textCedula")){		
	
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			String text = panRegPers.textCedula.getText();
			char[] cadena;
			
			if(text.equals("")){
				 cadena = " ".toCharArray();
			}else{
			cadena = text.toCharArray();
			}
			
		
			if(cadena[0] < 'E' || cadena[0] > 'V'){			
			
				if((key !='V')&&(key !='E')){
														
					e.consume();
				
					if(!(key < '0' || key > '9')){
					
					 JOptionPane.showMessageDialog(null, "Primero debe especificar nacionalidad, ejemplo='V-12345678'");
					}
				
				}else{
					
					if(text.equals("")){
						panRegPers.textCedula.setText(key+"-");;
						e.consume();
					}else{
					
							if(key=='V'){
									if(panRegPers.textCedula.getText().length()>9){
						
										String	te2 = key+text.substring(0,9);; 	
												
										panRegPers.textCedula.setText(te2);
							
										e.consume();
								
									}
						
							}
					
				}
			}
		
		}else{
			
			if(!(key < '0' || key > '9')){
												
				if(cadena[0]=='V'){
					
					if(!(text.length()<=9)){
						e.consume();
						
					}
				}
				else{
					if(!(text.length()<=14)){
						e.consume();
						
					}
					
				}			
									
			}else{
				e.consume();
			}
		}
		
	}
	}
	
	public void actionPerformed(ActionEvent e) {

		if(ets.equals("btnCargaHoraria")){	
			if(panLisPers.table.getSelectedRow()!=-1 ){
			DefaultTableModel list=(DefaultTableModel) panLisPers.table.getModel();
			CargaHoraria carHo = new CargaHoraria(panRegPers);
			String ident = (String)list.getValueAt(panLisPers.table.getSelectedRow(), 1);
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();
			carHo.Limpiar(horario);
			carHo.Mostrar(horario, ident);
			}
			
			
			panRegPers.btCar=true;
			visCarHor.setVisible(true);
			
			
			
		}
		
		if(ets.equals("comCargo")){
			
			if(panRegPers.comCargo.getSelectedIndex()==0){
				panRegPers.btnCargaHoraria.setVisible(false);
				panRegPers.lblJornadaLaboral.setVisible(false);
				panRegPers.comJornaLabo.setVisible(false);
			}else{
				if(panRegPers.comCargo.getSelectedIndex()==1){
					panRegPers.lblJornadaLaboral.setVisible(false);
					panRegPers.comJornaLabo.setVisible(false);
					panRegPers.btnCargaHoraria.setVisible(true);
				}else{
					panRegPers.btnCargaHoraria.setVisible(false);
					panRegPers.lblJornadaLaboral.setVisible(true);
					panRegPers.comJornaLabo.setVisible(true);
				}
			}
			
			
			
		}
		
		
		
	}

	public void focusLost(FocusEvent arg0) {
		if(ets.equals("textCedula")){
			ClaseConection co = new ClaseConection();
			co.GetConexion("1323027");
			String sqlCe = "select cedu from pers";
			ResultSet geCe = co.GetDatos(sqlCe);
			
			try {
				while(geCe.next()){
					if(geCe.getString("cedu").equals(panRegPers.textCedula.getText())){
					 JOptionPane.showMessageDialog(null, "La cedula "+panRegPers.textCedula.getText()+" ya esta registrada");
     				 panRegPers.textCedula.setText("");
					}
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			co.SetCloseConexion();
		}
		
	}

	



public void focusGained(FocusEvent arg0) {
	
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	

	

	

	
	
	
	
}
