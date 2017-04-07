package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Justificaciones;
import Modelo.ListadosAsistencia;
import Vista.PanelListarAsistencia;
import Vista.VistaGestionAsistencia;
import Vista.VistaJustificaciones;
import Vista.VistaPortada;
import Vista.VistaRegistrarCalendarioAcademico;
import Vista.VistaVerJustificacion;
import Vista.panelListarPersonal;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class ControladorPanelListarAsistencia implements MouseListener, ActionListener{
	private VistaGestionAsistencia visGesAsis;
	private PanelListarAsistencia panLisAsis;
	private VistaRegistrarCalendarioAcademico regCaleAca;
	private panelListarPersonal panLisPers;
	private VistaJustificaciones visJus;
	private String est;
	
	public ControladorPanelListarAsistencia(panelListarPersonal panLisPers, VistaJustificaciones visJus, VistaRegistrarCalendarioAcademico regCaleAca, VistaGestionAsistencia visGesAsis, PanelListarAsistencia panLisAsis,
			String est) {
	
		this.visJus=visJus;
		this.visGesAsis = visGesAsis;
		this.panLisAsis = panLisAsis;
		this.regCaleAca=regCaleAca;
		this.panLisPers=panLisPers;
		this.est = est;
	}

	public void mouseEntered(MouseEvent e) {
		if(est.equals("btmExportar")){
			ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-2.png"));
			Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(panLisAsis.btmExportar.getWidth(), panLisAsis.btmExportar.getHeight(), Image.SCALE_DEFAULT));
			panLisAsis.btmExportar.setIcon(icono1111);
		}
		
		
	}

	public void mouseExited(MouseEvent e) {
		if(est.equals("btmExportar")){
			ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
			Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(panLisAsis.btmExportar.getWidth(), panLisAsis.btmExportar.getHeight(), Image.SCALE_DEFAULT));
			panLisAsis.btmExportar.setIcon(icono1111);
		}
		
	}
	public void mousePressed(MouseEvent e) {
		
		if(est.equals("btmExportar")){
			ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
			Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(panLisAsis.btmExportar.getWidth(), panLisAsis.btmExportar.getHeight(), Image.SCALE_DEFAULT));
			panLisAsis.btmExportar.setIcon(icono1111);
		}
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
		if(est.equals("btmExportar")){
			ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-2.png"));
			Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(panLisAsis.btmExportar.getWidth(), panLisAsis.btmExportar.getHeight(), Image.SCALE_DEFAULT));
			panLisAsis.btmExportar.setIcon(icono1111);
		}
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(est.equals("btmExportar")){
			JRTableModelDataSource jrtmd = new JRTableModelDataSource(panLisAsis.table.getModel());
			ListadosAsistencia lis = new ListadosAsistencia(regCaleAca, null);
			
			lis.ExportarListarAsistencia(jrtmd, panLisAsis.comboTipoPers.getSelectedItem().toString(), panLisAsis.textFech.getJFormattedTextField().getText());
		}
		
		
	}


	public void actionPerformed(ActionEvent e) {
		if(est.equals("comboTipoPers")){
			
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
			
		}
		if(est.equals("textFech")){
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
		}
		
		if(est.equals("btnJustInas")){
			
			if(panLisAsis.table.getSelectedRow()!=-1 ){
				DefaultTableModel horario=(DefaultTableModel) panLisAsis.table.getModel();
				String ident = (String)horario.getValueAt(panLisAsis.table.getSelectedRow(), 6);
				visJus.textInas.setText(ident);
				visJus.setVisible(true);
			
			}else{
				JOptionPane.showMessageDialog(null,	"Seleccione una fila en la tabla",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

			}
			
			
		}
		if(est.equals("btnVerJustificacin")){
			
					if(panLisAsis.table.getSelectedRow()!=-1 ){
						DefaultTableModel horario=(DefaultTableModel) panLisAsis.table.getModel();
						String ident = (String)horario.getValueAt(panLisAsis.table.getSelectedRow(), 0);
						String fech = panLisAsis.textFech.getJFormattedTextField().getText();
						Justificaciones jus = new Justificaciones(ident, fech);
						VistaVerJustificacion v = new VistaVerJustificacion();
						
						v.textVerOpser.setText(jus.getJustificacion());
						v.setVisible(true);
									
					}else{
						JOptionPane.showMessageDialog(null,	"Seleccione una fila en la tabla",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

					}
					
			
		}
		
	}

	

	
	
	
}
