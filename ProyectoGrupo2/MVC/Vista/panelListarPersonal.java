package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classLibreria.validarTablas;
import javax.swing.DefaultComboBoxModel;

public class panelListarPersonal extends JPanel {


	public JTextField textBusca;
	public JLabel btmAtras;
	public JTable table;
	public JComboBox comCarg;
	public JLabel btmConsultar;
	public JComboBox comStatu;
	public JLabel btmExportaList;


	/**
	 * Create the dialog.
	 */
	public panelListarPersonal() {
		
	    setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 928, 473);
		ImageIcon fot = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 24, 928, 449);
		ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/marco.png"));
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(panelListarPersonal.class.getResource("/panelListarPersonal/tituListarPers.png")));
		label.setBounds(81, 30, 268, 37);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/panelListarPersonal/tituListarPers.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		
		textBusca = new JTextField();
		textBusca.setBounds(127, 78, 151, 20);
		add(textBusca);
		textBusca.setColumns(10);
		
		btmAtras = new JLabel("New label");
		
		btmAtras.setBounds(119, 408, 169, 37);
		ImageIcon mA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon btmA = new ImageIcon(mA.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmAtras.setIcon(btmA);
		add(btmAtras);
		
		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblBuscador.setBounds(45, 74, 86, 23);
		add(lblBuscador);
		
		btmConsultar = new JLabel("New label");
		btmConsultar.setBounds(382, 408, 169, 37);
		ImageIcon tmC = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmConsultar-1.png"));
		Icon Con = new ImageIcon(tmC.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmConsultar.setIcon(Con);
		add(btmConsultar);
		
		JLabel lblCargo = new JLabel("Tipo de personal");
		lblCargo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCargo.setBounds(315, 74, 134, 23);
		add(lblCargo);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStatus.setBounds(660, 74, 86, 23);
		add(lblStatus);
		
		btmExportaList = new JLabel("New label");
		btmExportaList.setBounds(637, 408, 169, 37);
		ImageIcon tmC1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
		Icon Con1 = new ImageIcon(tmC1.getImage().getScaledInstance(btmExportaList.getWidth(), btmExportaList.getHeight(), Image.SCALE_DEFAULT));
		btmExportaList.setIcon(Con1);
		add(btmExportaList);
		
		comStatu = new JComboBox();
		comStatu.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comStatu.setBounds(715, 78, 169, 20);
		add(comStatu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 113, 839, 291);
		add(scrollPane);
		validarTablas va = new validarTablas();
		table = va.Validar2();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cedula", "Nombre", "Apellido", "Telefono", "H.L"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		scrollPane.setViewportView(table);
		
		comCarg = new JComboBox();
		comCarg.setModel(new DefaultComboBoxModel(new String[] {"Docente", "Administrativo", "Operativo"}));
		comCarg.setBounds(451, 78, 169, 20);
		add(comCarg);
		label.setIcon(icono11);

		add(label);
	

		
		add(lblNewLabel_1);
		
		add(lblNewLabel);
	}
}
