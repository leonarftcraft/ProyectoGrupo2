package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.Asistencia;
import Modelo.CalendarioAcademico;
import Vista.VistaPortada;
import Vista.VistaRegistrarAsistencia;
import Vista.VistaRegistrarCalendarioAcademico;

public class ControladorVistaRegisAsistencia implements ActionListener, MouseListener, KeyListener{
	
	private VistaRegistrarAsistencia visRegAsis;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private String est;
	
	public ControladorVistaRegisAsistencia(VistaRegistrarAsistencia visRegAsis,
			VistaRegistrarCalendarioAcademico regCaleAca, String est) {
	
		this.visRegAsis = visRegAsis;
		this.regCaleAca = regCaleAca;
		this.est = est;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(est.equals("btnModifiCale")){
			CalendarioAcademico cal = new CalendarioAcademico(regCaleAca);
			regCaleAca.btmGuardar.setVisible(false);
			regCaleAca.btmActulizar.setVisible(true);
			String fech[] = cal.Mostrar();
			
			regCaleAca.textFechInci.getJFormattedTextField().setText(fech[0]);
			regCaleAca.textFechFin.getJFormattedTextField().setText(fech[1]);
			regCaleAca.setVisible(true);
			
			
		}
		
	}


	public void mouseEntered(MouseEvent e) {
		
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmAtras.getWidth(),visRegAsis.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmAtras.setIcon(icono11);
		}
		if(est.equals("btmGuardar")){
			
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmGuardar.getWidth(), visRegAsis.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmGuardar.setIcon(icono11);
			
		}
		
	}

	
	public void mouseExited(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmAtras.getWidth(),visRegAsis.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmAtras.setIcon(icono11);
		}
		if(est.equals("btmGuardar")){
		
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmGuardar.getWidth(), visRegAsis.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmGuardar.setIcon(icono11);
			
		}
		
	}

	public void mousePressed(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmAtras.getWidth(),visRegAsis.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmAtras.setIcon(icono11);
		}
		if(est.equals("btmGuardar")){
			
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmGuardar.getWidth(), visRegAsis.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmGuardar.setIcon(icono11);
			
		}
		
	}


	public void mouseReleased(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmAtras.getWidth(),visRegAsis.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmAtras.setIcon(icono11);
		}
		if(est.equals("btmGuardar")){
		
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visRegAsis.btmGuardar.getWidth(), visRegAsis.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visRegAsis.btmGuardar.setIcon(icono11);
			
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if(est.equals("btmAtras")){
			
			visRegAsis.dispose();
		}
		if(est.equals("btmGuardar")){
		
			if(!visRegAsis.texCedu.getText().equals("")&&visRegAsis.comNaciona.getSelectedIndex()!=0){
			Asistencia asi = new Asistencia(regCaleAca, visRegAsis.comNaciona.getSelectedItem().toString()+visRegAsis.texCedu.getText());
			if(asi.getValidarPersonal()==true){
				if(asi.getTipoAsistencia().equals("Entrada")){
					asi.RegistrarEntrada();
					JOptionPane.showMessageDialog(null,	"Asistencia de entrada registrada exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
					visRegAsis.texCedu.setText("");
					visRegAsis.comNaciona.setSelectedIndex(0);
				}else{
					if(asi.getTipoAsistencia().equals("Salida")){
						asi.RegistrarSalida();
						
						System.out.println(asi.getHorasPerdidasSalida());
						JOptionPane.showMessageDialog(null,	"Asistencia de salida registrada exitosamente",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
						if(asi.getHorasPerdidasSalida()!=0){
							JOptionPane.showMessageDialog(null,	"Hora laborales perdidas="+asi.getHorasPerdidasSalida(),  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

						}
						
						visRegAsis.texCedu.setText("");
						visRegAsis.comNaciona.setSelectedIndex(0);
					
					}else{
						
						JOptionPane.showMessageDialog(null,	"La hora de entrada y salidad ya fueron registradas",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

						visRegAsis.texCedu.setText("");
						visRegAsis.comNaciona.setSelectedIndex(0);
					}
					
					
				}
				
			
			
			}else{
				JOptionPane.showMessageDialog(null,	"La cedula que introdujo no esta registrada",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
				visRegAsis.comNaciona.setSelectedIndex(0);
				visRegAsis.texCedu.setText("");
			}
			
			
			
			}else{
				JOptionPane.showMessageDialog(null,	"Introduzca una cedula con su nacionalidad",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

			}
			
			
			
			
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(est.equals("texCedu")){
			
			String tex = visRegAsis.texCedu.getText();
		
			if(tex.length()<=15){
				
				if((key < '0' || key > '9')){
					
					e.consume();
					
				}
				
				
			}else{
				e.consume();
			}
		
		}
		
	}

	

	


	
	
	
}
