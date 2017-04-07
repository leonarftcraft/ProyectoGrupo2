package Controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.CargaHoraria;
import Modelo.JornadaLaboral;
import Modelo.Justificaciones;
import Modelo.ListadosAsistencia;
import Modelo.Personal;
import Vista.PanelListarAsistencia;
import Vista.VistaJustificaciones;
import Vista.VistaPortada;
import Vista.VistaRegistrarCalendarioAcademico;

public class ControladorVistaJustificacion implements MouseListener, KeyListener{
	private PanelListarAsistencia panLisAsis;
	private VistaJustificaciones visJus;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private String est;
	public ControladorVistaJustificacion(VistaRegistrarCalendarioAcademico regCaleAca, PanelListarAsistencia panLisAsis, VistaJustificaciones visJus, String est) {
		this.regCaleAca = regCaleAca;
		this.panLisAsis = panLisAsis;
		this.visJus = visJus;
		this.est = est;
	}
	
	public void mouseEntered(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visJus.btmAtras.getWidth(), visJus.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visJus.btmGuardar.getWidth(), visJus.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmGuardar.setIcon(icono111);
			
		}
	}
	public void mouseExited(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visJus.btmAtras.getWidth(), visJus.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visJus.btmGuardar.getWidth(), visJus.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmGuardar.setIcon(icono111);
			
		}
		
	}
	public void mousePressed(MouseEvent e) {
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visJus.btmAtras.getWidth(), visJus.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visJus.btmGuardar.getWidth(), visJus.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmGuardar.setIcon(icono111);
			
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		
		if(est.equals("btmAtras")){
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(visJus.btmAtras.getWidth(), visJus.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmAtras.setIcon(icono11);
			
		}
		if(est.equals("btmGuardar")){
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(visJus.btmGuardar.getWidth(), visJus.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visJus.btmGuardar.setIcon(icono111);
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		if(est.equals("btmAtras")){
			visJus.textHoraJust.setText("");
			visJus.textOpserva.setText("");
			visJus.textInas.setText("");
			visJus.dispose();
			
		}
		if(est.equals("btmGuardar")){
			
			if(!visJus.textHoraJust.getText().equals("")&&!visJus.textOpserva.getText().equals("")){
				
				if(Integer.parseInt(visJus.textHoraJust.getText())<=Integer.parseInt(visJus.textInas.getText())
						&&Integer.parseInt(visJus.textHoraJust.getText())>0){
			
			DefaultTableModel horario=(DefaultTableModel) panLisAsis.table.getModel();
			String ident = (String)horario.getValueAt(panLisAsis.table.getSelectedRow(), 0);
			String fech = panLisAsis.textFech.getJFormattedTextField().getText();
			System.out.println(ident);
			Justificaciones ju = new Justificaciones(visJus.textOpserva.getText(), visJus.textHoraJust.getText(), ident, fech);
			ju.RegistrarJustificacion();
			
			ListadosAsistencia liA = new ListadosAsistencia(regCaleAca, null);
			DefaultTableModel modelo=(DefaultTableModel) panLisAsis.table.getModel();
			int filasTabla = panLisAsis.table.getRowCount();
			String feBus=null;
			if(!panLisAsis.textFech.getJFormattedTextField().getText().equals("")){
				feBus=panLisAsis.textFech.getJFormattedTextField().getText();
			}else{
				feBus=liA.getFechaActual();
			}
			String conSql="where pers.fk_tipoPers='"+(panLisAsis.comboTipoPers.getSelectedIndex()+1)+"' and asispers.fech='"+feBus+"'";
			liA.ListarAsistencia(modelo, filasTabla, conSql, feBus);
			visJus.textHoraJust.setText("");
			visJus.textOpserva.setText("");
			visJus.textInas.setText("");
			visJus.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,	"Las horas justificadas no pueden ser mayor que las inasistencias o igual a (0)",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

				}
			}else{
				JOptionPane.showMessageDialog(null,	"Debe introducir cantida de horas y opservación ",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

			}
			}
		}
		
	
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if(est.equals("textHoraJust")){
			String tex = visJus.textHoraJust.getText();
			
			if(tex.length()<=1){
				
				if((key < '0' || key > '9')){
				
					e.consume();					
				}
								
			}else{
				e.consume();
			}
		}
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
}
