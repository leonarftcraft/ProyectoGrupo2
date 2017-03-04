package Controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import Modelo.CargaHoraria;
import Modelo.Personal;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;

public class ControladorPanelRegistrarPersonal implements MouseListener, KeyListener{
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	private panelListarPersonal panLisPers;
	private String ets;
	
	public ControladorPanelRegistrarPersonal(VistaGestionPersonal visGesPer, panelRegistrarPersonal panRegPers, 
			panelListarPersonal panLisPers, String ets) {
	
		this.ets = ets;
		this.panLisPers=panLisPers;
		this.visGesPer = visGesPer;
		this.panRegPers = panRegPers;
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
		
		if(ets.equals("btmGuardar")){
			DefaultTableModel horario=(DefaultTableModel) panRegPers.table.getModel();
	
			if(panRegPers.table.getSelectedRow()!=-1 ){
				
				if(panRegPers.table.getSelectedColumn()!=0){
				panRegPers.table.clearSelection();				
				panRegPers.table.getCellEditor().stopCellEditing();
				
				}
				
			}
	
			
			int cont=0;
			if(!panRegPers.textApellido.equals("")&&!panRegPers.textNombre.equals("")&&!panRegPers.textCedula.equals("")
					&&!panRegPers.textTelef.equals("")&&panRegPers.comCargo.getSelectedIndex()!=0){
				
				
				for (int a = 0; a <= 10; a++) {

					for (int b = 1; b <= 5; b++) {
						

						if ((Boolean)horario.getValueAt(a, b)) {
							cont++;

						}

					}

				}
				
				if(cont>=5){
					CargaHoraria carRe = new CargaHoraria(panRegPers);
					Personal pers = new Personal(panRegPers);
					
					pers.Registrar();
					carRe.Registrar(horario);
					
					JOptionPane.showMessageDialog(null,	"Datos almacenados exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
					pers.Limpiar();
					carRe.Limpiar(horario);
					
				
				
				}else{
					JOptionPane.showMessageDialog(null, "Debe introducir por lo minimo 5 horas en la carga horaria", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 

				}
			}else{
				JOptionPane.showMessageDialog(null, "Los campos que tienen asterisco rojo son obligatorios", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 
			}
			
			
			
		}
		
		if(ets.equals("btmAtras")){
			
			visGesPer.dispose();
						
		}
		
		if(ets.equals("btmActualizar")){
			DefaultTableModel horario=(DefaultTableModel) panRegPers.table.getModel();

			if(panRegPers.table.getSelectedRow()!=-1 ){
				
				if(panRegPers.table.getSelectedColumn()!=0){
				panRegPers.table.clearSelection();				
				panRegPers.table.getCellEditor().stopCellEditing();
				
				}
				
			}
			int cont=0;
			if(!panRegPers.textApellido.equals("")&&!panRegPers.textNombre.equals("")&&!panRegPers.textCedula.equals("")
					&&!panRegPers.textTelef.equals("")&&panRegPers.comCargo.getSelectedIndex()!=0){
				
				
				for (int a = 0; a <= 10; a++) {

					for (int b = 1; b <= 5; b++) {
						

						if ((Boolean)horario.getValueAt(a, b)) {
							cont++;

						}

					}

				}
				
				if(cont>=5){
					CargaHoraria carRe = new CargaHoraria(panRegPers);
					Personal pers = new Personal(panRegPers);
					
					DefaultTableModel list=(DefaultTableModel) panLisPers.table.getModel();
					String ident = (String)list.getValueAt(panLisPers.table.getSelectedRow(), 1);
					
					
					pers.Modificar(ident);;
					carRe.Modificar(horario);
					
					int filasTabla = panLisPers.table.getRowCount();

					String Sql = "select pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, carg.descr as e from pers "
							+ "inner join carg on  pers.fk_carg=carg.id";
					System.out.println("dkfjsd");
					pers.Listar(list, Sql, filasTabla);
					JOptionPane.showMessageDialog(null,	"Datos almacenados exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
					panLisPers.comCarg.setSelectedIndex(0);
					panLisPers.comStatu.setSelectedIndex(0);
					panLisPers.textBusca.setText("");
					panLisPers.setVisible(true);
					panRegPers.setVisible(false);
				//	JOptionPane.showMessageDialog(null,	"Datos almacenados exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
				
				}else{
					JOptionPane.showMessageDialog(null, "Debe introducir por lo minimo 5 horas en la carga horaria", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE); 

				}
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
		

	@Override
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
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

	
	
	
	
}
