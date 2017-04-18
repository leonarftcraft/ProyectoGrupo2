package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import Animacion.Animacion;
import Modelo.ClaseConection;
import Vista.VistaMenuPrincipal;
import classLibreria.PreviewPane;

import classLibreria.CustomFileFilter;


public class ControladorVistaMenuPrincipal implements MouseListener, ActionListener{
	
	private VistaMenuPrincipal visMen;
	private String es;
	
	public ControladorVistaMenuPrincipal(VistaMenuPrincipal visMen, String es) {
	
		this.visMen = visMen;
		this.es = es;
	}
	
	
	public void mouseClicked(MouseEvent arg0) {
		
		
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		int posicion = visMen.panelConfig.getY();
		if(es.equals("butConfCarru")){
			if(posicion==278){
			Animacion.bajar(377, 535, 0, visMen.butConfCarru);
			Animacion.bajar(278, 560, 0, visMen.panelConfig);
			}else{
				Animacion.subir(535, 255, 0, visMen.butConfCarru);
				Animacion.subir(560, 278, 0, visMen.panelConfig);
			}
		}
		
		if(es.equals("btntImag1")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) { }
			final JFrame frame = new JFrame();
			JFileChooser chooser = new JFileChooser();
			PreviewPane previewPane = new PreviewPane();
			chooser.setAccessory(previewPane);
			chooser.addPropertyChangeListener(previewPane);
			
			CustomFileFilter filtro = new CustomFileFilter("Solo imagenes jpg", new String[] {"jpg"});
			chooser.setFileFilter(filtro);	
			chooser.setAcceptAllFileFilterUsed(false);
			int opc = chooser.showDialog(frame, "OK");
			if(opc==JFileChooser.APPROVE_OPTION){
				 
			String rut = chooser.getSelectedFile().getPath();
				 	ImageIcon fot = new ImageIcon(rut);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(visMen.lblImag1.getWidth(), visMen.lblImag1.getHeight(), Image.SCALE_DEFAULT));
					visMen.lblImag1.setIcon(icono);
					
					ClaseConection co = new ClaseConection();
					
					Connection com = co.GetConexion("1323027");
					String sql = "update carru set imag=? where id = '1'";
					PreparedStatement ps = null;
					FileInputStream fi = null;
					
					
					try {
						
						File fay = new File(rut);
						fi = new FileInputStream(fay);				
					
						ps = com.prepareStatement(sql);
						ps.setBinaryStream(1, fi,(int)fay.length());
						
					
						ps.executeUpdate();
						
						com.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
							
			}
			
			
		}
		if(es.equals("btntImag2")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) { }
			final JFrame frame = new JFrame();
			JFileChooser chooser = new JFileChooser();
			PreviewPane previewPane = new PreviewPane();
			chooser.setAccessory(previewPane);
			chooser.addPropertyChangeListener(previewPane);
			
			CustomFileFilter filtro = new CustomFileFilter("Solo imagenes jpg", new String[] {"jpg"});
			chooser.setFileFilter(filtro);	
			chooser.setAcceptAllFileFilterUsed(false);
			int opc = chooser.showDialog(frame, "OK");
			if(opc==JFileChooser.APPROVE_OPTION){
				 
			String rut = chooser.getSelectedFile().getPath();
				 	ImageIcon fot = new ImageIcon(rut);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(visMen.lablblImag2.getWidth(), visMen.lablblImag2.getHeight(), Image.SCALE_DEFAULT));
					visMen.lablblImag2.setIcon(icono);
					
					ClaseConection co = new ClaseConection();
					
					Connection com = co.GetConexion("1323027");
					String sql = "update carru set imag=? where id = '2'";
					PreparedStatement ps = null;
					FileInputStream fi = null;
					
					
					try {
						
						File fay = new File(rut);
						fi = new FileInputStream(fay);				
					
						ps = com.prepareStatement(sql);
						ps.setBinaryStream(1, fi,(int)fay.length());
						
					
						ps.executeUpdate();
						
						com.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
							
			}
		}
		if(es.equals("btntImag3")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) { }
			final JFrame frame = new JFrame();
			JFileChooser chooser = new JFileChooser();
			PreviewPane previewPane = new PreviewPane();
			chooser.setAccessory(previewPane);
			chooser.addPropertyChangeListener(previewPane);
			
			CustomFileFilter filtro = new CustomFileFilter("Solo imagenes jpg", new String[] {"jpg"});
			chooser.setFileFilter(filtro);	
			chooser.setAcceptAllFileFilterUsed(false);
			int opc = chooser.showDialog(frame, "OK");
			if(opc==JFileChooser.APPROVE_OPTION){
				 
			String rut = chooser.getSelectedFile().getPath();
				 	ImageIcon fot = new ImageIcon(rut);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(visMen.lablblImag3.getWidth(), visMen.lablblImag3.getHeight(), Image.SCALE_DEFAULT));
					visMen.lablblImag3.setIcon(icono);
					
					ClaseConection co = new ClaseConection();
					
					Connection com = co.GetConexion("1323027");
					String sql = "update carru set imag=? where id = '3'";
					PreparedStatement ps = null;
					FileInputStream fi = null;
					
					
					try {
						
						File fay = new File(rut);
						fi = new FileInputStream(fay);				
					
						ps = com.prepareStatement(sql);
						ps.setBinaryStream(1, fi,(int)fay.length());
						
					
						ps.executeUpdate();
						
						com.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
							
			}
		}
		if(es.equals("btntImag4")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) { }
			final JFrame frame = new JFrame();
			JFileChooser chooser = new JFileChooser();
			PreviewPane previewPane = new PreviewPane();
			chooser.setAccessory(previewPane);
			chooser.addPropertyChangeListener(previewPane);
			
			CustomFileFilter filtro = new CustomFileFilter("Solo imagenes jpg", new String[] {"jpg"});
			chooser.setFileFilter(filtro);	
			chooser.setAcceptAllFileFilterUsed(false);
			int opc = chooser.showDialog(frame, "OK");
			if(opc==JFileChooser.APPROVE_OPTION){
				 
			String rut = chooser.getSelectedFile().getPath();
				 	ImageIcon fot = new ImageIcon(rut);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(visMen.lablblImag4.getWidth(), visMen.lablblImag4.getHeight(), Image.SCALE_DEFAULT));
					visMen.lablblImag4.setIcon(icono);
					
					ClaseConection co = new ClaseConection();
					
					Connection com = co.GetConexion("1323027");
					String sql = "update carru set imag=? where id = '4'";
					PreparedStatement ps = null;
					FileInputStream fi = null;
					
					
					try {
						
						File fay = new File(rut);
						fi = new FileInputStream(fay);				
					
						ps = com.prepareStatement(sql);
						ps.setBinaryStream(1, fi,(int)fay.length());
						
					
						ps.executeUpdate();
						
						com.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
							
			}
		}
		if(es.equals("btntImag5")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e) { }
			final JFrame frame = new JFrame();
			JFileChooser chooser = new JFileChooser();
			PreviewPane previewPane = new PreviewPane();
			chooser.setAccessory(previewPane);
			chooser.addPropertyChangeListener(previewPane);
			
			CustomFileFilter filtro = new CustomFileFilter("Solo imagenes jpg", new String[] {"jpg"});
			chooser.setFileFilter(filtro);	
			chooser.setAcceptAllFileFilterUsed(false);
			int opc = chooser.showDialog(frame, "OK");
			if(opc==JFileChooser.APPROVE_OPTION){
				 
			String rut = chooser.getSelectedFile().getPath();
				 	ImageIcon fot = new ImageIcon(rut);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(visMen.lablblImag5.getWidth(), visMen.lablblImag5.getHeight(), Image.SCALE_DEFAULT));
					visMen.lablblImag5.setIcon(icono);
					
					ClaseConection co = new ClaseConection();
					
					Connection com = co.GetConexion("1323027");
					String sql = "update carru set imag=? where id = '5'";
					PreparedStatement ps = null;
					FileInputStream fi = null;
					
					
					try {
						
						File fay = new File(rut);
						fi = new FileInputStream(fay);				
					
						ps = com.prepareStatement(sql);
						ps.setBinaryStream(1, fi,(int)fay.length());
						
					
						ps.executeUpdate();
						
						com.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
							
			}
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
