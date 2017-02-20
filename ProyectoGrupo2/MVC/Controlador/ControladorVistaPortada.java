package Controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animacion.Animacion;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;

public class ControladorVistaPortada implements MouseListener{
	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private String est;

	public ControladorVistaPortada(VistaPortada visPor, VistaGestionPersonal visGesPer, String est) {
		this.est = est;
		this.visPor = visPor;
		this.visGesPer = visGesPer;
	}

	public void mouseEntered(MouseEvent e) {
	
		int posicion = visPor.menDes.getY();
		
		if (est.equals("menGestiPers")) {
			
			ImageIcon fot2 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGesPersonal-2.png"));		
			Icon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(visPor.menGestiPers.getWidth(), visPor.menGestiPers.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menGestiPers.setIcon(icono2);
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}


		}
		if (est.equals("menGestAsis")) {
			ImageIcon fot3 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGestAsistencia-2.png"));		
			Icon icono3 = new ImageIcon(fot3.getImage().getScaledInstance(visPor.menGestAsis.getWidth(), visPor.menGestAsis.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menGestAsis.setIcon(icono3);
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}


		}
		if (est.equals("menRegiAsis")) {
			ImageIcon fot4 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuRegisAsitencia-2.png"));		
			Icon icono4 = new ImageIcon(fot4.getImage().getScaledInstance(visPor.menRegiAsis.getWidth(), visPor.menRegiAsis.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menRegiAsis.setIcon(icono4);
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}

		}
		if (est.equals("menOpcioSiste")) {
			ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-2.png"));		
			Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menOpcioSiste.setIcon(icono5);
		}

		if (est.equals("itenAdminUsuar")) {
			ImageIcon fot6 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminUsuario-2.png"));		
			Icon icono6 = new ImageIcon(fot6.getImage().getScaledInstance(visPor.itenAdminUsuar.getWidth(), visPor.itenAdminUsuar.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenAdminUsuar.setIcon(icono6);
		}
		if (est.equals("itenAdminMysql")) {
			ImageIcon fot7 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminMysql-2.png"));		
			Icon icono7 = new ImageIcon(fot7.getImage().getScaledInstance(visPor.itenAdminMysql.getWidth(), visPor.itenAdminMysql.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenAdminMysql.setIcon(icono7);
		}
		if (est.equals("itenSalir")) {
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennSalir-2.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visPor.itenSalir.getWidth(), visPor.itenSalir.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenSalir.setIcon(icono8);
		}
	}

	public void mouseExited(MouseEvent e) {
		
		
		if (est.equals("menGestiPers")) {
			ImageIcon fot2 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGesPersonal-1.png"));		
			Icon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(visPor.menGestiPers.getWidth(), visPor.menGestiPers.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menGestiPers.setIcon(icono2);
			
		}
		if (est.equals("menGestAsis")) {
			ImageIcon fot3 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGestAsistencia-1.png"));		
			Icon icono3 = new ImageIcon(fot3.getImage().getScaledInstance(visPor.menGestAsis.getWidth(), visPor.menGestAsis.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menGestAsis.setIcon(icono3);
		
		}
		if (est.equals("menRegiAsis")) {
			ImageIcon fot4 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuRegisAsitencia-1.png"));		
			Icon icono4 = new ImageIcon(fot4.getImage().getScaledInstance(visPor.menRegiAsis.getWidth(), visPor.menRegiAsis.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menRegiAsis.setIcon(icono4);
			
		}
		
		if (est.equals("menOpcioSiste")) {
			if(visPor.opciSiste==false){
			ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
			Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
			visPor.menOpcioSiste.setIcon(icono5);
			}
		}
		
		if (est.equals("itenAdminUsuar")) {
			ImageIcon fot6 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminUsuario-1.png"));		
			Icon icono6 = new ImageIcon(fot6.getImage().getScaledInstance(visPor.itenAdminUsuar.getWidth(), visPor.itenAdminUsuar.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenAdminUsuar.setIcon(icono6);
		}
		if (est.equals("itenAdminMysql")) {
			ImageIcon fot7 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminMysql-1.png"));		
			Icon icono7 = new ImageIcon(fot7.getImage().getScaledInstance(visPor.itenAdminMysql.getWidth(), visPor.itenAdminMysql.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenAdminMysql.setIcon(icono7);
		}
		if (est.equals("itenSalir")) {
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennSalir-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visPor.itenSalir.getWidth(), visPor.itenSalir.getHeight(), Image.SCALE_DEFAULT));		
			visPor.itenSalir.setIcon(icono8);
		}

	}
	
	public void mousePressed(MouseEvent e) {
		int posicion = visPor.menDes.getY();
		
		if (est.equals("panel")) {
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}
			
		}
		if (est.equals("menOpcioSiste")) {
						
				if(posicion > 0){
					visPor.opciSiste = false;
					Animacion.subir(214, -158, 0, visPor.menDes);	
				
				}else{
					visPor.opciSiste = true;
					Animacion.bajar(-158, 214, 0, visPor.menDes);
					
				}
		}
		
		if (est.equals("itenAdminUsuar")) {
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}
		}
		if (est.equals("itenAdminMysql")) {
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}
		}
		if (est.equals("itenSalir")) {
			if(posicion > 0){
				visPor.opciSiste = false;
				Animacion.subir(214, -158, 0, visPor.menDes);	
				ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
				Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(visPor.menOpcioSiste.getWidth(), visPor.menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
				visPor.menOpcioSiste.setIcon(icono5);
			
			}
		}
		
		if(est.equals("menGestiPers")){
			
			visGesPer.setVisible(true);
			
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	
}
