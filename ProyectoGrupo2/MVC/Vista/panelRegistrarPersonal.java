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

import classLibreria.Celda_CheckBox;
import classLibreria.Render_CheckBox;
import classLibreria.validarTablas;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelRegistrarPersonal extends JPanel {
	private Image ima;
	private URL dire;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	public JTable table;
	public JLabel btmGuardar;
	

	
	/**
	 * Create the panel.
	 */
	public panelRegistrarPersonal() {
		setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");	
		lblNewLabel_2.setBounds(110, 18, 268, 37);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/panelRegistrarPersonal/tiuloRegPersonal.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_DEFAULT));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 172, 779, 206);
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(423, 68, 169, 24);
		add(textField_1);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(346, 66, 86, 23);
		add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(80, 100, 86, 23);
		add(lblTelefono);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(423, 103, 169, 23);
		add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 102, 169, 24);
		add(textField_3);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCargo.setBounds(346, 100, 86, 23);
		add(lblCargo);
		
		JLabel lblFechNacimiento = new JLabel("Fec. Nac.");
		lblFechNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechNacimiento.setBounds(604, 100, 86, 23);
		add(lblFechNacimiento);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(679, 102, 169, 24);
		add(textField_5);
		
		JLabel lblHorario = new JLabel("Carga horaria");
		lblHorario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHorario.setBounds(80, 152, 86, 23);
		add(lblHorario);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo=(DefaultTableModel) table.getModel();
				
				boolean  nom =   (boolean) modelo.getValueAt(1, 1);
				System.out.println(nom);
				if(nom==true){
					System.out.println("bien");
				}else{
					System.out.println("craddd");
				}
				
			}
		});
		btnNewButton.setBounds(90, 398, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(157, 68, 169, 24);
		add(textField);
		textField.setColumns(10);
		
		btmGuardar = new JLabel("New label");
		
		btmGuardar.setBounds(575, 389, 196, 46);
		ImageIcon mGua = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
		Icon btmGu = new ImageIcon(mGua.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
		btmGuardar.setIcon(btmGu);
		add(btmGuardar);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(679, 68, 169, 24);
		add(textField_2);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCedula.setBounds(616, 66, 86, 23);
		add(lblCedula);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_3.setBounds(80, 66, 86, 23);
		add(lblNewLabel_3);
		lblNewLabel_2.setIcon(icono11);
		add(lblNewLabel_2);
		
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
