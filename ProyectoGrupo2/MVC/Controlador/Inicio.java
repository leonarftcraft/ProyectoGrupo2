package Controlador;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import Modelo.Personal;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
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
					
					try {
						
						JRTableModelDataSource jrtmd = new JRTableModelDataSource( panLisPers.table.getModel() );
						JasperReport nuestroreporte = null; 
						Map parametro = new HashMap(); 
						parametro.put("carg", "");
						nuestroreporte = (JasperReport) JRLoader.loadObject(Personal.class.getResource( "/Plantillas/Blank_Letter.jasper"));
						JasperPrint jasperPrint = JasperFillManager.fillReport(nuestroreporte, parametro, jrtmd); 

						
						
					
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					} 
					
					
					VistaGestionPersonal visGesPer = new VistaGestionPersonal();
					VistaPortada visPor = new VistaPortada();
					panelRegistrarPersonal panRegPers = new panelRegistrarPersonal();
					
					visPor.setVisible(true);
					
					new ControladorPrincipal(visPor, visGesPer, panRegPers, panLisPers);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
