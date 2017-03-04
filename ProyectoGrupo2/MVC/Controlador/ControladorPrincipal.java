package Controlador;

import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;
import Controlador.ControladorPanelRegistrarPersonal;

public class ControladorPrincipal {

	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	private panelListarPersonal panLisPers;
	
	public ControladorPrincipal(VistaPortada visPor, VistaGestionPersonal visGesPer, panelRegistrarPersonal panRegPers, 
			panelListarPersonal panLisPers) {

		this.panLisPers = panLisPers;
		this.visPor = visPor;
		this.visGesPer = visGesPer;
		this.panRegPers = panRegPers;

		addEventVistaPortada();
		
		addEventVistaGestionPersonal();
		
		addPanelesVistaGestionPersonal();
		addEvenPanelRegistraPersonal();
		addEventPanalListarPersonal();
	}

	private void addEventPanalListarPersonal() {
		
		panLisPers.textBusca.addKeyListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "textBusca"));
		panLisPers.comCarg.addActionListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "comCarg"));
		panLisPers.btmAtras.addMouseListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "btmAtras"));
		panLisPers.btmConsultar.addMouseListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "btmConsultar"));
		panLisPers.comStatu.addActionListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "comStatu"));
		panLisPers.btmExportaList.addMouseListener(new ControladorPanelListarPersonal(visGesPer, panLisPers, panRegPers, "btmExportaList"));
	}

	private void addEvenPanelRegistraPersonal() {
		
		panRegPers.btmGuardar.addMouseListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "btmGuardar"));
		panRegPers.btmAtras.addMouseListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "btmAtras"));
		panRegPers.textNombre.addKeyListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "textNombre"));
		panRegPers.textApellido.addKeyListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "textApellido"));
		panRegPers.textCedula.addKeyListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "textCedula"));
		panRegPers.textTelef.addKeyListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "textTelef"));
		panRegPers.btmActualizar.addMouseListener(new ControladorPanelRegistrarPersonal(visGesPer, panRegPers, panLisPers, "btmActualizar"));

		
	}

	private void addPanelesVistaGestionPersonal() {
		panRegPers.setBounds(0, 45, 928, 473);
		panRegPers.setVisible(false);
		visGesPer.contentPanel.add(panRegPers);
		
		panLisPers.setBounds(0, 45, 928, 473);
		panLisPers.setVisible(true);
		visGesPer.contentPanel.add(panLisPers);
		
		
		
		
	}

	private void addEventVistaPortada() {
		
		visPor.menGestiPers.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "menGestiPers"));
		visPor.menGestAsis.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "menGestAsis"));
		visPor.menRegiAsis.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "menRegiAsis"));
		visPor.menOpcioSiste.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "menOpcioSiste"));
		visPor.itenAdminUsuar.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "itenAdminUsuar"));
		visPor.itenAdminMysql.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "itenAdminMysql"));
		visPor.itenSalir.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "itenSalir"));
		visPor.panel.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, panLisPers, panRegPers, "panel"));
	}
	
	private void addEventVistaGestionPersonal(){
		visGesPer.menListar.addMouseListener(new ControladorVistaGestionPersonal(visPor, visGesPer, panLisPers, panRegPers, "menListar"));
		visGesPer.menRegistrar.addMouseListener(new ControladorVistaGestionPersonal(visPor, visGesPer, panLisPers, panRegPers, "menRegistrar"));
	}
	
	
	
}
