package Controlador;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import Modelo.Asistencia;
import Modelo.Personal;
import Vista.VistaCargaHorario;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.VistaRegistrarAsistencia;
import Vista.VistaRegistrarCalendarioAcademico;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					panelListarPersonal panLisPers = new panelListarPersonal();
					VistaGestionPersonal visGesPer = new VistaGestionPersonal();
					VistaPortada visPor = new VistaPortada();
					panelRegistrarPersonal panRegPers = new panelRegistrarPersonal();
				    VistaCargaHorario visCarHor = new VistaCargaHorario();
				    VistaRegistrarCalendarioAcademico regCaleAca = new VistaRegistrarCalendarioAcademico();
				    VistaRegistrarAsistencia visRegAsis = new VistaRegistrarAsistencia();
				    Asistencia asi = new Asistencia(regCaleAca, null);
				    
				    asi.setRegistrosAutomaticos();
				    visPor.setVisible(true);
					
					new ControladorPrincipal(visRegAsis, regCaleAca, visCarHor, visPor, visGesPer, panRegPers, panLisPers);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
