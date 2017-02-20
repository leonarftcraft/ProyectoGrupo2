package Controlador;

import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelRegistrarPersonal;

public class ControladorPrincipal {

	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	public ControladorPrincipal(VistaPortada visPor, VistaGestionPersonal visGesPer, panelRegistrarPersonal panRegPers) {

		this.visPor = visPor;
		this.visGesPer = visGesPer;
		this.panRegPers = panRegPers;

		addEventVistaPortada();
		
		addEventVistaGestionPersonal();
		addPanelesVistaGestionPersonal();
	}

	private void addPanelesVistaGestionPersonal() {
		panRegPers.setBounds(0, 45, 928, 473);
		visGesPer.contentPanel.add(panRegPers);
		
	}

	private void addEventVistaPortada() {
		
		visPor.menGestiPers.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "menGestiPers"));
		visPor.menGestAsis.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "menGestAsis"));
		visPor.menRegiAsis.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "menRegiAsis"));
		visPor.menOpcioSiste.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "menOpcioSiste"));
		visPor.itenAdminUsuar.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "itenAdminUsuar"));
		visPor.itenAdminMysql.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "itenAdminMysql"));
		visPor.itenSalir.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "itenSalir"));
		visPor.panel.addMouseListener(new ControladorVistaPortada(visPor, visGesPer, "panel"));
	}
	
	private void addEventVistaGestionPersonal(){
		visGesPer.menListar.addMouseListener(new ControladorVistaGestionPersonal(visPor, visGesPer, "menListar"));
		visGesPer.menRegistrar.addMouseListener(new ControladorVistaGestionPersonal(visPor, visGesPer, "menRegistrar"));
	}
	
	
	
}
