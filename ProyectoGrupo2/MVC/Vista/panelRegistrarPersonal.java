package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import classLibreria.Calendario;
import classLibreria.Celda_CheckBox;
import classLibreria.DateLabelFormatter;
import classLibreria.JDatePickerImpl;
import classLibreria.Render_CheckBox;
import classLibreria.validarTablas;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class panelRegistrarPersonal extends JPanel {
	private Image ima;
	private URL dire;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textCedula;
	public JTextField textTelef;
	public JDatePickerImpl textFecNaci;
	public JTable table;
	public JLabel btmGuardar;
	private Calendario ca = new Calendario();
	public JComboBox comCargo;
	public JComboBox comStatus;
	public JLabel lblStatus;
	public JLabel btmAtras;
	public JLabel btmActualizar;
	public JLabel tituRegsiPers;
	

	
	/**
	 * Create the panel.
	 */
	public panelRegistrarPersonal() {
		setLayout(null);
		
		
		tituRegsiPers = new JLabel("New label");	
		tituRegsiPers.setBounds(110, 18, 268, 37);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/panelRegistrarPersonal/tiuloRegPersonal.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(tituRegsiPers.getWidth(), tituRegsiPers.getHeight(), Image.SCALE_DEFAULT));
		tituRegsiPers.setIcon(icono11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 186, 779, 199);
		add(scrollPane);
		validarTablas vT = new validarTablas();
		table = vT.Validar();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"7:00-7:45", false, false, false, false, false},
				{"7:45-8:30", false, false, false, false, false},
				{"8:40-9:25", false, false, false, false, false},
				{"9:25-10:10", false, false, false, false, false},
				{"10:20-11:05", false, false, false, false, false},
				{"11:05-11:50", false, false, false, false, false},
				{"2:00-2:45", false, false, false, false, false},
				{"2:45-3:30", false, false, false, false, false},
				{"3:40-4:25", false, false, false, false, false},
				{"4:25-5:10", false, false, false, false, false},
				{"5:20-6:05", false, false, false, false, false},
			},
			new String[] {
				"Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"
			}
		));
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		
		TableColumn con1 = 	table.getColumnModel().getColumn(1);
		
		con1.setCellEditor(new Celda_CheckBox());
		con1.setCellRenderer(new Render_CheckBox());
		
		TableColumn con2 = 	table.getColumnModel().getColumn(2);
		
		con2.setCellEditor(new Celda_CheckBox());
		con2.setCellRenderer(new Render_CheckBox());
		
		TableColumn con3 = 	table.getColumnModel().getColumn(3);
		
		con3.setCellEditor(new Celda_CheckBox());
		con3.setCellRenderer(new Render_CheckBox());
		
TableColumn con4 = 	table.getColumnModel().getColumn(4);
		
		con4.setCellEditor(new Celda_CheckBox());
		con4.setCellRenderer(new Render_CheckBox());
		
TableColumn con5 = 	table.getColumnModel().getColumn(5);
		
		con5.setCellEditor(new Celda_CheckBox());
		con5.setCellRenderer(new Render_CheckBox());
		
		scrollPane.setViewportView(table);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		textApellido.setColumns(10);
		textApellido.setBounds(423, 68, 169, 24);
		add(textApellido);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(346, 66, 86, 23);
		add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(80, 100, 86, 23);
		add(lblTelefono);
		
		comCargo = new JComboBox();
		comCargo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Docente", "Administrativo", "Operativo"}));
		comCargo.setBounds(423, 103, 169, 23);
		add(comCargo);
		
		textTelef = new JTextField();
		textTelef.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textTelef.setColumns(10);
		textTelef.setBounds(157, 102, 169, 24);
		add(textTelef);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCargo.setBounds(346, 100, 86, 23);
		add(lblCargo);
		
		JLabel lblFechNacimiento = new JLabel("Fec. Nac.");
		lblFechNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechNacimiento.setBounds(604, 100, 86, 23);
		add(lblFechNacimiento);
		
		textFecNaci =  new JDatePickerImpl(ca.GetCalendario(), new DateLabelFormatter());
		textFecNaci.setBounds(679, 102, 169, 24);
		add(textFecNaci);
		
		JLabel lblHorario = new JLabel("Carga horaria");
		lblHorario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHorario.setBounds(82, 162, 121, 23);
		add(lblHorario);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(326, 58, 28, 14);
		add(lblNewLabel_4);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label.setBounds(326, 92, 28, 14);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_1.setBounds(591, 58, 28, 14);
		add(label_1);
		
		comStatus = new JComboBox();
		comStatus.setVisible(false);
		comStatus.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comStatus.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comStatus.setBounds(679, 134, 169, 23);
		add(comStatus);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_2.setBounds(591, 96, 28, 14);
		add(label_2);
		
		btmAtras = new JLabel("New label");
	
		btmAtras.setBounds(158, 392, 196, 46);		
		ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmAtras.setIcon(mAt);
		add(btmAtras);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_3.setBounds(846, 58, 28, 14);
		add(label_3);
		
		lblStatus = new JLabel("Status");
		lblStatus.setVisible(false);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStatus.setBounds(624, 134, 66, 23);
		add(lblStatus);
		
		btmActualizar = new JLabel("New label");
	
		btmActualizar.setBounds(575, 392, 196, 46);
		ImageIcon mGu = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-1.png"));
		Icon btmG = new ImageIcon(mGu.getImage().getScaledInstance(btmActualizar.getWidth(), btmActualizar.getHeight(), Image.SCALE_DEFAULT));
		btmActualizar.setIcon(btmG);
		btmActualizar.setVisible(false);
		add(btmActualizar);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		textNombre.setBounds(157, 68, 169, 24);
		add(textNombre);
		textNombre.setColumns(10);
		
		btmGuardar = new JLabel("New label");
		
		btmGuardar.setBounds(575, 392, 196, 46);
		ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
		Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
		btmGuardar.setIcon(btmGu);
		add(btmGuardar);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textCedula.setColumns(10);
		textCedula.setBounds(679, 68, 169, 24);
		add(textCedula);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCedula.setBounds(616, 66, 86, 23);
		add(lblCedula);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_3.setBounds(80, 66, 86, 23);
		add(lblNewLabel_3);
	
		add(tituRegsiPers);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(31, 11, 873, 451);
		ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/marco.png"));
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono1);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 928, 473);
		ImageIcon fot = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		add(lblNewLabel);
		
		
		
		
		
		

		
	}
}
