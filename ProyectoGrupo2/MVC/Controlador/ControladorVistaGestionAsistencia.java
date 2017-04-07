package Controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Vista.VistaGestionAsistencia;
import Vista.VistaPortada;

public class ControladorVistaGestionAsistencia implements MouseListener{
	private VistaGestionAsistencia visGesAsis;
	private String est;
	
	public ControladorVistaGestionAsistencia(VistaGestionAsistencia visGesAsis, String est) {
	
		this.visGesAsis = visGesAsis;
		this.est = est;
	}

	public void mouseEntered(MouseEvent e) {
		if(est.equals("menLisAsis")){
			ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/iteLisAsis-2.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(visGesAsis.menLisAsis.getWidth(), visGesAsis.menLisAsis.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisAsis.setIcon(icono1);
			
		}
		if(est.equals("menLisSanc")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisSancio-2.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visGesAsis.menLisSanc.getWidth(), visGesAsis.menLisSanc.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisSanc.setIcon(icono111);
		}
		if(est.equals("menListarAsisIndib")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisAsisIndi-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visGesAsis.menListarAsisIndib.getWidth(), visGesAsis.menListarAsisIndib.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menListarAsisIndib.setIcon(icono11);
		}
	}


	public void mouseExited(MouseEvent e) {
		if(est.equals("menLisAsis")){
			/*ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/iteLisAsis-1png.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(visGesAsis.menLisAsis.getWidth(), visGesAsis.menLisAsis.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisAsis.setIcon(icono1);*/
			
		}
		if(est.equals("menLisSanc")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisSancio-1.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visGesAsis.menLisSanc.getWidth(), visGesAsis.menLisSanc.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisSanc.setIcon(icono111);
		}
		if(est.equals("menListarAsisIndib")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisAsisIndi-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visGesAsis.menListarAsisIndib.getWidth(), visGesAsis.menListarAsisIndib.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menListarAsisIndib.setIcon(icono11);
		}
		
	}


	public void mousePressed(MouseEvent e) {
		if(est.equals("menLisAsis")){
			ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/iteLisAsis-1png.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(visGesAsis.menLisAsis.getWidth(), visGesAsis.menLisAsis.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisAsis.setIcon(icono1);
			
		}
		if(est.equals("menLisSanc")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisSancio-1.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visGesAsis.menLisSanc.getWidth(), visGesAsis.menLisSanc.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisSanc.setIcon(icono111);
		}
		if(est.equals("menListarAsisIndib")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisAsisIndi-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visGesAsis.menListarAsisIndib.getWidth(), visGesAsis.menListarAsisIndib.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menListarAsisIndib.setIcon(icono11);
		}
	}

	
	public void mouseReleased(MouseEvent e) {
		if(est.equals("menLisAsis")){
			ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/iteLisAsis-2.png"));
			Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(visGesAsis.menLisAsis.getWidth(), visGesAsis.menLisAsis.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisAsis.setIcon(icono1);
			
		}
		if(est.equals("menLisSanc")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisSancio-2.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visGesAsis.menLisSanc.getWidth(), visGesAsis.menLisSanc.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menLisSanc.setIcon(icono111);
		}
		if(est.equals("menListarAsisIndib")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisAsisIndi-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visGesAsis.menListarAsisIndib.getWidth(), visGesAsis.menListarAsisIndib.getHeight(), Image.SCALE_DEFAULT));
			visGesAsis.menListarAsisIndib.setIcon(icono11);
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(est.equals("menLisAsis")){
			
			
		}
		if(est.equals("menLisSanc")){
		
		}
		if(est.equals("menListarAsisIndib")){
			
		}
	}

	

	
	
	
}
