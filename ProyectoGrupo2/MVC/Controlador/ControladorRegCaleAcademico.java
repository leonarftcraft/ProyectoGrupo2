package Controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.CalendarioAcademico;
import Vista.VistaPortada;
import Vista.VistaRegistrarAsistencia;
import Vista.VistaRegistrarCalendarioAcademico;

public class ControladorRegCaleAcademico implements MouseListener{
	private VistaRegistrarAsistencia visRegAsis;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private String est;
	
	public ControladorRegCaleAcademico(VistaRegistrarAsistencia visRegAsis,
			VistaRegistrarCalendarioAcademico regCaleAca, String est) {

		this.visRegAsis = visRegAsis;
		this.regCaleAca = regCaleAca;
		this.est = est;
	}

	public void mouseEntered(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(regCaleAca.btmAtras.getWidth(), regCaleAca.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(regCaleAca.btmGuardar.getWidth(), regCaleAca.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmGuardar.setIcon(icono1);
		}
		if(est.equals("btmActulizar")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(regCaleAca.btmActulizar.getWidth(), regCaleAca.btmActulizar.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmActulizar.setIcon(icono11);
		}
	}


	public void mouseExited(MouseEvent e) {
		if(est.equals("btmActulizar")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(regCaleAca.btmActulizar.getWidth(), regCaleAca.btmActulizar.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmActulizar.setIcon(icono11);
		}
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(regCaleAca.btmAtras.getWidth(), regCaleAca.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(regCaleAca.btmGuardar.getWidth(), regCaleAca.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			regCaleAca.btmGuardar.setIcon(icono1);
		}
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
		if(est.equals("btmActulizar")){
			CalendarioAcademico cal = new CalendarioAcademico(regCaleAca);
			if(!regCaleAca.textFechInci.getJFormattedTextField().getText().equals("")&&!regCaleAca.textFechFin.getJFormattedTextField().getText().equals("")){
				
				cal.Modificar();
				JOptionPane.showMessageDialog(null,	"Datos Actualizados",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);				
				cal.setVacios();
				regCaleAca.dispose();
				visRegAsis.dispose();
				
			}else{
				JOptionPane.showMessageDialog(null,	"Debe seleccionar ambas fechas",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);				
			}
		}
		
		if(est.equals("btmAtras")){
			CalendarioAcademico cal = new CalendarioAcademico(regCaleAca);
			cal.setVacios();
			regCaleAca.setVisible(false);
			
		}
		if(est.equals("btmGuardar")){
			CalendarioAcademico cal = new CalendarioAcademico(regCaleAca);
			if(!regCaleAca.textFechInci.getJFormattedTextField().getText().equals("")&&!regCaleAca.textFechFin.getJFormattedTextField().getText().equals("")){
				
				cal.Registrar();
				JOptionPane.showMessageDialog(null,	"Datos Registrados",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);				
				cal.setVacios();
				regCaleAca.dispose();
				
			}else{
				JOptionPane.showMessageDialog(null,	"Debe seleccionar ambas fechas",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);				
			}
			
		}
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
