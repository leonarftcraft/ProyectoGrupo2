package Controlador;

import java.awt.EventQueue;

import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelRegistrarPersonal;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGestionPersonal visGesPer = new VistaGestionPersonal();
					VistaPortada visPor = new VistaPortada();
					panelRegistrarPersonal panRegPers = new panelRegistrarPersonal();
					visPor.setVisible(true);
					
					new ControladorPrincipal(visPor, visGesPer, panRegPers);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
