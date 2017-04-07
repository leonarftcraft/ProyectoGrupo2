package Controlador;

import Vista.PanelListarAsistencia;
import Vista.VistaCargaHorario;
import Vista.VistaGestionAsistencia;
import Vista.VistaGestionPersonal;
import Vista.VistaJustificaciones;
import Vista.VistaLogin;
import Vista.VistaPortada;
import Vista.VistaRegistrarAsistencia;
import Vista.VistaRegistrarCalendarioAcademico;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;
import Controlador.ControladorPanelRegistrarPersonal;

public class ControladorPrincipal {

	private VistaPortada visPor;
	private VistaGestionPersonal visGesPer;
	private panelRegistrarPersonal panRegPers;
	private panelListarPersonal panLisPers;
	private VistaCargaHorario visCarHor;
	private VistaRegistrarAsistencia visRegAsis;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private VistaGestionAsistencia visGesAsis;
	private PanelListarAsistencia panLisAsis;
	private VistaJustificaciones visJus;
	private VistaLogin visLog;
	public ControladorPrincipal(VistaLogin visLog, VistaJustificaciones visJus, PanelListarAsistencia panLisAsis, VistaGestionAsistencia visGesAsis, VistaRegistrarAsistencia visRegAsis, VistaRegistrarCalendarioAcademico regCaleAca, VistaCargaHorario visCarHor, VistaPortada visPor, VistaGestionPersonal visGesPer, panelRegistrarPersonal panRegPers, 
			panelListarPersonal panLisPers) {

		this.visCarHor = visCarHor;
		this.panLisPers = panLisPers;
		this.visPor = visPor;
		this.visGesPer = visGesPer;
		this.panRegPers = panRegPers;
		this.regCaleAca = regCaleAca;
		this.visRegAsis = visRegAsis;
		this.visGesAsis = visGesAsis;
		this.panLisAsis = panLisAsis;
		this.visLog = visLog;
		this.visJus = visJus;

		addEventVistaPortada();
		
		addEventVistaGestionPersonal();
		
		addPanelesVistaGestionPersonal();
		addEvenPanelRegistraPersonal();
		addEventPanalListarPersonal();
		
		addEventVistaCargaHorario();
		
		addEventVisRegiCaleAcade();
		addEventVistaRegiAsistencia();
		
		addEventVistaGestionASistencia();
		addPanelVistaGestionAsistenci();
		addEventPanelListarASistencia();
		
		addEventVistaJustifi();
		
		addEventLogi();
	}

	private void addEventLogi() {
		visLog.btnIniciar.addActionListener(new ControladorVistaLogin(visLog, visPor, "btnIniciar"));
		visLog.texPass.addKeyListener(new ControladorVistaLogin(visLog, visPor, "texPass"));
		visLog.textUser.addKeyListener(new ControladorVistaLogin(visLog, visPor, "textUser"));
	}

	private void addEventVistaJustifi() {
		visJus.btmAtras.addMouseListener(new ControladorVistaJustificacion(regCaleAca, panLisAsis, visJus, "btmAtras"));
		visJus.btmGuardar.addMouseListener(new ControladorVistaJustificacion(regCaleAca, panLisAsis, visJus, "btmGuardar"));
		visJus.textHoraJust.addKeyListener(new ControladorVistaJustificacion(regCaleAca, panLisAsis, visJus, "textHoraJust"));

	}

	private void addEventPanelListarASistencia() {
		panLisAsis.btmExportar.addMouseListener(new ControladorPanelListarAsistencia(panLisPers, visJus, regCaleAca, visGesAsis, panLisAsis, "btmExportar"));
		panLisAsis.comboTipoPers.addActionListener(new ControladorPanelListarAsistencia(panLisPers, visJus, regCaleAca, visGesAsis, panLisAsis, "comboTipoPers"));
		panLisAsis.textFech.getJDateInstantPanel().addActionListener(new ControladorPanelListarAsistencia(panLisPers, visJus, regCaleAca, visGesAsis, panLisAsis, "textFech"));
		panLisAsis.btnJustInas.addActionListener(new ControladorPanelListarAsistencia(panLisPers, visJus, regCaleAca, visGesAsis, panLisAsis, "btnJustInas"));
		panLisAsis.btnVerJustificacin.addActionListener(new ControladorPanelListarAsistencia(panLisPers, visJus, regCaleAca, visGesAsis, panLisAsis, "btnVerJustificacin"));
	}

	private void addPanelVistaGestionAsistenci() {
		panLisAsis.setBounds(0, 46, 905, 469);
		panLisAsis.setVisible(true);
		visGesAsis.contentPanel.add(panLisAsis);
	}

	private void addEventVistaGestionASistencia() {
		visGesAsis.menLisAsis.addMouseListener(new ControladorVistaGestionAsistencia(visGesAsis, "menLisAsis"));
		visGesAsis.menLisSanc.addMouseListener(new ControladorVistaGestionAsistencia(visGesAsis, "menLisSanc") );
		visGesAsis.menListarAsisIndib.addMouseListener(new ControladorVistaGestionAsistencia(visGesAsis, "menListarAsisIndib"));
	}

	private void addEventVistaRegiAsistencia() {
		
		visRegAsis.btnModifiCale.addActionListener(new ControladorVistaRegisAsistencia(visRegAsis, regCaleAca, "btnModifiCale"));
		visRegAsis.btmGuardar.addMouseListener(new ControladorVistaRegisAsistencia(visRegAsis, regCaleAca, "btmGuardar"));
		visRegAsis.btmAtras.addMouseListener(new ControladorVistaRegisAsistencia(visRegAsis, regCaleAca, "btmAtras"));
		visRegAsis.texCedu.addKeyListener(new ControladorVistaRegisAsistencia(visRegAsis, regCaleAca, "texCedu"));
	}

	private void addEventVisRegiCaleAcade() {
		regCaleAca.btmGuardar.addMouseListener(new ControladorRegCaleAcademico(visRegAsis, regCaleAca, "btmGuardar"));
		regCaleAca.btmAtras.addMouseListener(new ControladorRegCaleAcademico(visRegAsis, regCaleAca, "btmAtras"));
		regCaleAca.btmActulizar.addMouseListener(new ControladorRegCaleAcademico(visRegAsis, regCaleAca, "btmActulizar"));
	}

	private void addEventVistaCargaHorario() {
		visCarHor.btmGuardar.addMouseListener(new ControladorVistaCargaHorario(panRegPers, visCarHor, "btmGuardar"));
		visCarHor.btmAtras.addMouseListener(new ControladorVistaCargaHorario(panRegPers, visCarHor, "btmAtras"));
		visCarHor.btnLimpiar.addActionListener(new ControladorVistaCargaHorario(panRegPers, visCarHor, "btnLimpiar"));
	}

	private void addEventPanalListarPersonal() {
		
		panLisPers.textBusca.addKeyListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "textBusca"));
		panLisPers.comCarg.addActionListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "comCarg"));
		panLisPers.btmAtras.addMouseListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "btmAtras"));
		panLisPers.btmConsultar.addMouseListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "btmConsultar"));
		panLisPers.comStatu.addActionListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "comStatu"));
		panLisPers.btmExportaList.addMouseListener(new ControladorPanelListarPersonal(visCarHor, visGesPer, panLisPers, panRegPers, "btmExportaList"));
	}

	private void addEvenPanelRegistraPersonal() {
		
		panRegPers.btmGuardar.addMouseListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "btmGuardar"));
		panRegPers.btmAtras.addMouseListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "btmAtras"));
		panRegPers.textNombre.addKeyListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "textNombre"));
		panRegPers.textApellido.addKeyListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "textApellido"));
		panRegPers.textCedula.addKeyListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "textCedula"));
		panRegPers.textCedula.addFocusListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "textCedula"));
		panRegPers.textTelef.addKeyListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "textTelef"));
		panRegPers.btmActualizar.addMouseListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "btmActualizar"));
		panRegPers.btnCargaHoraria.addActionListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "btnCargaHoraria"));
		panRegPers.comCargo.addActionListener(new ControladorPanelRegistrarPersonal(regCaleAca, visCarHor, visGesPer, panRegPers, panLisPers, "comCargo"));
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
		
		visPor.menGestiPers.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "menGestiPers"));
		visPor.menGestAsis.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "menGestAsis"));
		visPor.menRegiAsis.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "menRegiAsis"));
		visPor.menOpcioSiste.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "menOpcioSiste"));
		visPor.itenAdminUsuar.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "itenAdminUsuar"));
		visPor.itenAdminMysql.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "itenAdminMysql"));
		visPor.itenSalir.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "itenSalir"));
		visPor.panel.addMouseListener(new ControladorVistaPortada(panLisAsis, visGesAsis, visRegAsis, regCaleAca, visPor, visGesPer, panLisPers, panRegPers, "panel"));
	}
	
	private void addEventVistaGestionPersonal(){
		visGesPer.menListar.addMouseListener(new ControladorVistaGestionPersonal(visCarHor, visPor, visGesPer, panLisPers, panRegPers, "menListar"));
		visGesPer.menRegistrar.addMouseListener(new ControladorVistaGestionPersonal(visCarHor, visPor, visGesPer, panLisPers, panRegPers, "menRegistrar"));
	}
	
	
	
}
