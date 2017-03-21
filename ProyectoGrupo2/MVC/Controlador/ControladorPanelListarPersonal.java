package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Modelo.Personal;
import Vista.VistaCargaHorario;
import Vista.VistaGestionPersonal;
import Vista.VistaPortada;
import Vista.panelListarPersonal;
import Vista.panelRegistrarPersonal;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;


public class ControladorPanelListarPersonal implements MouseListener, KeyListener, ActionListener{
	private VistaGestionPersonal visGesPer;
	private panelListarPersonal panLisPers;
	private panelRegistrarPersonal panRegPers;
	private VistaCargaHorario visCarHor;
	private String ets;
	
	public ControladorPanelListarPersonal(VistaCargaHorario visCarHor, VistaGestionPersonal visGesPer, panelListarPersonal panLisPers, 
			panelRegistrarPersonal panRegPers, String ets) {
	
		this.ets =ets;
		this.visCarHor = visCarHor;
		this.panRegPers = panRegPers;
		this.visGesPer = visGesPer;
		this.panLisPers = panLisPers;
	}

	
	public void actionPerformed(ActionEvent e) {
	if(ets.equals("comCarg")){
		String Sql;
		
		if(panLisPers.comCarg.getSelectedIndex()!=0){
			 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
						+ "intehora.decr as e "
						+ "from inteHora INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id "
						+ "INNER JOIN pers ON jornLabo.fk_pers=pers.id "
						+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' and pers.fk_tipoPers='"+(panLisPers.comCarg.getSelectedIndex()+1)+"'";
		}else{
			 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
					+ "count(cargHora.fk_pers) as e "
					+ "from cargHora INNER JOIN pers ON cargHora.fk_pers=pers.id"
					+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' and pers.fk_tipoPers='1' group by cargHora.fk_pers";
		}
		System.out.println(Sql);
		Personal pers = new Personal();
		DefaultTableModel modelo=(DefaultTableModel) panLisPers.table.getModel();
		int filasTabla = panLisPers.table.getRowCount();
		panLisPers.textBusca.setText("");
		pers.Listar(modelo, Sql, filasTabla);
		
	}
	
	if(ets.equals("comStatu")){
		String Sql;
		
			if(panLisPers.comCarg.getSelectedIndex()!=0){
				 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
							+ "intehora.decr as e "
							+ "from inteHora INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id "
							+ "INNER JOIN pers ON jornLabo.fk_pers=pers.id "
							+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' and pers.fk_tipoPers='"+(panLisPers.comCarg.getSelectedIndex()+1)+"'";
			}else{
				 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
						+ "count(cargHora.fk_pers) as e "
						+ "from cargHora INNER JOIN pers ON cargHora.fk_pers=pers.id"
						+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' and pers.fk_tipoPers='"+(panLisPers.comCarg.getSelectedIndex()+1)+"' group by cargHora.fk_pers";
			}		
		
		Personal pers = new Personal();
		DefaultTableModel modelo=(DefaultTableModel) panLisPers.table.getModel();
		int filasTabla = panLisPers.table.getRowCount();
		panLisPers.textBusca.setText("");
		pers.Listar(modelo, Sql, filasTabla);
	}
	
	}
	
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(ets.equals("textBusca")){
			
			String tex = panLisPers.textBusca.getText();
			if(Character.isLowerCase(key)){
				String cad = (""+key).toUpperCase();
				key=cad.charAt(0);
				e.setKeyChar(key);
				key=e.getKeyChar();
			}
			if(tex.length()<=10){
				
				if((key < 'A' || key > 'Z')&&!(key=='Ñ')&&!(key==' ')&&(key < '0' || key > '9')&&!(key=='-')){
					
					e.consume();
					
				}
				
				
			}else{
				e.consume();
			}
		
		}
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		if(ets.equals("textBusca")){
			String Sql;
			if(panLisPers.comCarg.getSelectedIndex()!=0){
				 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
							+ "intehora.decr as e "
							+ "from inteHora INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id "
							+ "INNER JOIN pers ON jornLabo.fk_pers=pers.id "
							+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' "
							+ "and pers.fk_tipoPers='"+(panLisPers.comCarg.getSelectedIndex()+1)+"' "
							+ "and  (cedu like '"+panLisPers.textBusca.getText()+"%' or nomb like '"+panLisPers.textBusca.getText()+"%' "
						    + "or apel like '"+panLisPers.textBusca.getText()+"%')";
				 
			}else{
				 Sql = "select pers.id as i, pers.cedu as a, pers.nomb as b, pers.apel as c, pers.tele as d, "
						+ "count(cargHora.fk_pers) as e "
						+ "from cargHora INNER JOIN pers ON cargHora.fk_pers=pers.id"
						+ " where pers.stat = '"+panLisPers.comStatu.getSelectedItem().toString()+"' and pers.fk_tipoPers='1' "
						+ "and  (cedu like '"+panLisPers.textBusca.getText()+"%' or nomb like '"+panLisPers.textBusca.getText()+"%' "
						+ "or apel like '"+panLisPers.textBusca.getText()+"%') group by cargHora.fk_pers";
			}
		
		
	
		Personal pers = new Personal();
		DefaultTableModel modelo=(DefaultTableModel) panLisPers.table.getModel();
		int filasTabla = panLisPers.table.getRowCount();
		pers.Listar(modelo, Sql, filasTabla);
		}
	}

	public void mouseClicked(MouseEvent e) {
		if(ets.equals("btmAtras")){
		visGesPer.dispose();
		}
		if(ets.equals("btmConsultar")){
			
			
			DefaultTableModel list=(DefaultTableModel) panLisPers.table.getModel();
			DefaultTableModel horario=(DefaultTableModel) visCarHor.table.getModel();
			if(panLisPers.table.getSelectedRow()!=-1 ){
				Personal pers = new Personal(panRegPers);
				CargaHoraria carHo = new CargaHoraria(panRegPers);
				JornadaLaboral jorN = new JornadaLaboral(panRegPers);
				String ident = (String)list.getValueAt(panLisPers.table.getSelectedRow(), 1);
			
				pers.Mostrar(ident);
				
				if(panRegPers.comCargo.getSelectedIndex()==1){
					panRegPers.btnCargaHoraria.setVisible(true);
					panRegPers.lblJornadaLaboral.setVisible(false);
					panRegPers.comJornaLabo.setVisible(false);
					carHo.Mostrar(ident);
				}else{
					panRegPers.btnCargaHoraria.setVisible(false);
					panRegPers.lblJornadaLaboral.setVisible(true);
					panRegPers.comJornaLabo.setVisible(true);
					jorN.Mostrar();
				}
				
				
				panRegPers.comCargo.setEnabled(false);
				panRegPers.lblStatus.setVisible(true);
				panRegPers.comStatus.setVisible(true);
				panRegPers.btmGuardar.setVisible(false);
				panRegPers.btmActualizar.setVisible(true);
				
				ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/panelRegistrarPersonal/titConsulta.png"));
				Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(panRegPers.tituRegsiPers.getWidth(), panRegPers.tituRegsiPers.getHeight(), Image.SCALE_DEFAULT));
				panRegPers.tituRegsiPers.setIcon(icono11);
				
				panLisPers.setVisible(false);
				panRegPers.setVisible(true);
			}else{
				
				JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
				
			}
			
			
		}
		if(ets.equals("btmExportaList")){
			JRTableModelDataSource jrtmd = new JRTableModelDataSource( panLisPers.table.getModel() );
			String carg=null;
				
				carg = panLisPers.comCarg.getSelectedItem().toString();
				
			
			Personal pers = new Personal();
			int filas = panLisPers.table.getRowCount();
			if(filas!=0){
				
				pers.generarListado(jrtmd, carg);
				
			}else{
				JOptionPane.showMessageDialog(null, "No hay datos que exportar en la tabla");
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		if(ets.equals("btmAtras")){
		ImageIcon mA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
		Icon btmA = new ImageIcon(mA.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
		panLisPers.btmAtras.setIcon(btmA);
		}
		if(ets.equals("btmConsultar")){
			ImageIcon tmC = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmConsultar-2.png"));
			Icon Con = new ImageIcon(tmC.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmConsultar.setIcon(Con);
		}
		
		if(ets.equals("btmExportaList")){
			
			ImageIcon tmC1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-2.png"));
			Icon Con1 = new ImageIcon(tmC1.getImage().getScaledInstance(panLisPers.btmExportaList.getWidth(), panLisPers.btmExportaList.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmExportaList.setIcon(Con1);
			
		}
	}

	public void mouseExited(MouseEvent e) {
		if(ets.equals("btmAtras")){
		ImageIcon mA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon btmA = new ImageIcon(mA.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
		panLisPers.btmAtras.setIcon(btmA);
		}
		if(ets.equals("btmConsultar")){
			ImageIcon tmC = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmConsultar-1.png"));
			Icon Con = new ImageIcon(tmC.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmConsultar.setIcon(Con);
		}
		if(ets.equals("btmExportaList")){
			
			ImageIcon tmC1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
			Icon Con1 = new ImageIcon(tmC1.getImage().getScaledInstance(panLisPers.btmExportaList.getWidth(), panLisPers.btmExportaList.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmExportaList.setIcon(Con1);
			
		}
	}


	public void mousePressed(MouseEvent e) {
		if(ets.equals("btmAtras")){
		ImageIcon mA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon btmA = new ImageIcon(mA.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
		panLisPers.btmAtras.setIcon(btmA);
		}
		if(ets.equals("btmConsultar")){
			ImageIcon tmC = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmConsultar-1.png"));
			Icon Con = new ImageIcon(tmC.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmConsultar.setIcon(Con);
		}
		if(ets.equals("btmExportaList")){
			
			ImageIcon tmC1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
			Icon Con1 = new ImageIcon(tmC1.getImage().getScaledInstance(panLisPers.btmExportaList.getWidth(), panLisPers.btmExportaList.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmExportaList.setIcon(Con1);
			
		}
	}

	
	public void mouseReleased(MouseEvent e) {
		if(ets.equals("btmAtras")){
		ImageIcon mA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-2.png"));
		Icon btmA = new ImageIcon(mA.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
		panLisPers.btmAtras.setIcon(btmA);
		}
		
		if(ets.equals("btmConsultar")){
			ImageIcon tmC = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmConsultar-2.png"));
			Icon Con = new ImageIcon(tmC.getImage().getScaledInstance(panLisPers.btmAtras.getWidth(), panLisPers.btmAtras.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmConsultar.setIcon(Con);
		}
		if(ets.equals("btmExportaList")){
			
			ImageIcon tmC1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-2.png"));
			Icon Con1 = new ImageIcon(tmC1.getImage().getScaledInstance(panLisPers.btmExportaList.getWidth(), panLisPers.btmExportaList.getHeight(), Image.SCALE_DEFAULT));
			panLisPers.btmExportaList.setIcon(Con1);
			
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	
}
