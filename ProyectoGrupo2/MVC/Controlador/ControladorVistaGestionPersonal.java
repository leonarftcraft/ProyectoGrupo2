package Controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Vista.VistaGestionPersonal;
import Vista.VistaPortada;

public class ControladorVistaGestionPersonal implements MouseListener{
	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private String est;
	
	public ControladorVistaGestionPersonal(VistaPortada visPor, VistaGestionPersonal visGesPer, String est) {
	
		this.est = est;
		this.visPor = visPor;
		this.visGesPer = visGesPer;
	}

	public void mouseEntered(MouseEvent e) {
	if(est.equals("menListar")){
		ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-2.png"));		
		Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
		visGesPer.menListar.setIcon(icono8);
	}
	if(est.equals("menRegistrar")){
		ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-2.png"));		
		Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
		visGesPer.menRegistrar.setIcon(icono8);
	}
	
	}


	public void mouseExited(MouseEvent e) {
		if(est.equals("menListar")){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menListar.setIcon(icono8);
		}
		if(est.equals("menRegistrar")){
			
			
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menRegistrar.setIcon(icono8);
		}
	}

	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
