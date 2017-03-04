package Controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Modelo.CargaHoraria;
import Modelo.Personal;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;

public class ControladorVistaGestionPersonal implements MouseListener{
	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	private panelListarPersonal panLisPers;
	private String est;
	
	public ControladorVistaGestionPersonal(VistaPortada visPor, VistaGestionPersonal visGesPer, 
			panelListarPersonal panLisPers, panelRegistrarPersonal panRegPers, String est) {
	
		this.panLisPers = panLisPers;
		this.est = est;
		this.panRegPers=panRegPers;
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
			if(panLisPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menListar.setIcon(icono8);
			}
		}
		if(est.equals("menRegistrar")){
			
			if(panRegPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menRegistrar.setIcon(icono8);
			}
		}
	}

	
	public void mousePressed(MouseEvent e) {
		
		if(est.equals("menRegistrar")){
			
			if(panRegPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menRegistrar.setIcon(icono8);
			}
		}
		if(est.equals("menListar")){
			if(panLisPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-1.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menListar.setIcon(icono8);
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	
		if(est.equals("menRegistrar")){
			
			if(panRegPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-2.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menRegistrar.setIcon(icono8);
			}
		}
		if(est.equals("menListar")){
			if(panLisPers.isVisible()==false){
			ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-2.png"));		
			Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
			visGesPer.menListar.setIcon(icono8);
			}
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
		if(est.equals("menRegistrar")){
			DefaultTableModel horario=(DefaultTableModel) panRegPers.table.getModel();

			if(panRegPers.isVisible()==false || panRegPers.btmActualizar.isVisible()==true){
				panRegPers.btmGuardar.setVisible(true);
				panRegPers.btmActualizar.setVisible(false);
				panRegPers.setVisible(true);
				panLisPers.setVisible(false);
				panRegPers.lblStatus.setVisible(false);
				panRegPers.comStatus.setVisible(false);
				
				ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/panelRegistrarPersonal/tiuloRegPersonal.png"));
				Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(panRegPers.tituRegsiPers.getWidth(), panRegPers.tituRegsiPers.getHeight(), Image.SCALE_DEFAULT));
				panRegPers.tituRegsiPers.setIcon(icono11);
				
				Personal pers = new Personal(panRegPers);
				CargaHoraria car = new CargaHoraria(panRegPers);
				
				pers.Limpiar();
				car.Limpiar(horario);
				
				ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-1.png"));		
				Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menListar.getWidth(), visGesPer.menListar.getHeight(), Image.SCALE_DEFAULT));		
				visGesPer.menListar.setIcon(icono8);
			}
			
		}
		if(est.equals("menListar")){
	
			if(panLisPers.isVisible()==false){
				Personal pers = new Personal(panRegPers);
				panLisPers.setVisible(true);
				panRegPers.setVisible(false);
				panLisPers.comCarg.setSelectedIndex(0);
				panLisPers.comStatu.setSelectedIndex(0);
				panLisPers.textBusca.setText("");
				DefaultTableModel modelo=(DefaultTableModel) panLisPers.table.getModel();
				int filasTabla = panLisPers.table.getRowCount();

				String Sql = "select pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, carg.descr as e from pers "
						+ "inner join carg on  pers.fk_carg=carg.id where stat = 'Activo'";
				
				pers.Listar(modelo, Sql, filasTabla);
				ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-1.png"));		
				Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(visGesPer.menRegistrar.getWidth(), visGesPer.menRegistrar.getHeight(), Image.SCALE_DEFAULT));		
				visGesPer.menRegistrar.setIcon(icono8);
			}
			
		}
	}

	
	

	
	
	
}
