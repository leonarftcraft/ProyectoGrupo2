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

import Modelo.CargaHoraria;
import Vista.VistaCargaHorario;
import Vista.VistaPortada;
import Vista.panelRegistrarPersonal;

public class ControladorVistaCargaHorario implements MouseListener, ActionListener{
	private VistaCargaHorario visCarHor;
	private panelRegistrarPersonal panRegPers;
	private String est;
	
	public ControladorVistaCargaHorario(panelRegistrarPersonal panRegPers, VistaCargaHorario visCarHor, String est) {
		this.visCarHor = visCarHor;
		this.panRegPers=panRegPers;
		this.est = est;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(est.equals("btmGuardar")){
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();
			
			if(visCarHor.table.getSelectedRow()!=-1 ){
				
				if(visCarHor.table.getSelectedColumn()!=0){
					visCarHor.table.clearSelection();				
					visCarHor.table.getCellEditor().stopCellEditing();
				
				}
																				
			}
			
			int con=0;
			for(int a=0; a<=12; a++){
				
				
				for(int b=1; b<=5; b++){
					
					
					if((Boolean)horario.getValueAt(a, b)){
						
						con++;								
					}
					
					
				}
				
			}
			
			if(con>=6){
				visCarHor.dispose();
			}else{
				JOptionPane.showMessageDialog(null,	"Debe introducir 6 horas minimo",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

			}
			
			
		}
		if(est.equals("btmAtras")){
			if(JOptionPane.showConfirmDialog(null, "Perdera los datos Seleccionados \n ¿Desea continuar con la opción seleccionada?", 
					"Confirmar", JOptionPane.YES_NO_OPTION
					, JOptionPane.QUESTION_MESSAGE)==0){
				CargaHoraria carRe = new CargaHoraria(panRegPers);
			
			if(visCarHor.table.getSelectedRow()!=-1 ){
				
				if(visCarHor.table.getSelectedColumn()!=0){
					visCarHor.table.clearSelection();				
					visCarHor.table.getCellEditor().stopCellEditing();
				
				}
																
			}
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();
			carRe.Limpiar(horario);
			visCarHor.dispose();
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(est.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(visCarHor.btmGuardar.getWidth(), visCarHor.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmGuardar.setIcon(btmGu);
		}
		if(est.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(visCarHor.btmAtras.getWidth(), visCarHor.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmAtras.setIcon(mAt);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(est.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(visCarHor.btmGuardar.getWidth(), visCarHor.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmGuardar.setIcon(btmGu);
		}
		if(est.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(visCarHor.btmAtras.getWidth(), visCarHor.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmAtras.setIcon(mAt);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(est.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(visCarHor.btmGuardar.getWidth(), visCarHor.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmGuardar.setIcon(btmGu);
		}
		if(est.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(visCarHor.btmAtras.getWidth(), visCarHor.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmAtras.setIcon(mAt);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(est.equals("btmGuardar")){
			ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-2.png"));
			Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(visCarHor.btmGuardar.getWidth(), visCarHor.btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmGuardar.setIcon(btmGu);
		
		}
		if(est.equals("btmAtras")){
			ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
			Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(visCarHor.btmAtras.getWidth(), visCarHor.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			visCarHor.btmAtras.setIcon(mAt);
		}
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(est.equals("btnLimpiar")){
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();
			CargaHoraria car = new CargaHoraria(panRegPers);
			if(visCarHor.table.getSelectedRow()!=-1 ){
				
				if(visCarHor.table.getSelectedColumn()!=0){
					visCarHor.table.clearSelection();				
					visCarHor.table.getCellEditor().stopCellEditing();
				
				}
																
			}
			car.Limpiar(horario);
			
			
		}
		
	}
	
	
	
}
