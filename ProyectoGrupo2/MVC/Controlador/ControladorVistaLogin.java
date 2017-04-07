package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.InicioSesion;
import Vista.VistaLogin;
import Vista.VistaPortada;

public class ControladorVistaLogin implements ActionListener, KeyListener{
	private VistaLogin visLog;
	private VistaPortada visPor;
	private String est;
	
	public ControladorVistaLogin(VistaLogin visLog, VistaPortada visPor, String est) {
		this.visLog = visLog;
		this.visPor = visPor;
		this.est = est;
	}

	
	public void actionPerformed(ActionEvent arg0) {
		if(est.equals("btnIniciar")){
			
			if(!visLog.texPass.getText().equals("")&&!visLog.textUser.getText().equals("")){
			InicioSesion in = new InicioSesion();
			if(in.validaUsuario(visLog.texPass.getText(), visLog.textUser.getText())==true){
				visLog.dispose();
				visPor.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null,	"Usuario o contraseña incorrectas",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

			}
			}else{
				JOptionPane.showMessageDialog(null,	"Debe rellenar los campos",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if(est.equals("texPass")){
			
			String tex = visLog.texPass.getText();
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			if(tex.length()<=20){
				
				if((key < 'A' || key > 'Z')&&(key < '0' || key > '9')&&!(key=='Ñ')&&!(key==' ')){
					
					e.consume();
					
				}
				
				
			}else{
				e.consume();
			}
		
		}
		if(est.equals("textUser")){
			
			String tex = visLog.textUser.getText();
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			if(tex.length()<=20){
				
				if((key < 'A' || key > 'Z')&&(key < '0' || key > '9')&&!(key=='Ñ')&&!(key==' ')){
					
					e.consume();
					
				}
				
				
			}else{
				e.consume();
			}
		
		}
		
	}
	
	
	
}
