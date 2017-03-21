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

	public JLabel btmGuardar;
	private Calendario ca = new Calendario();
	public JComboBox comCargo;
	public JComboBox comStatus;
	public JLabel lblStatus;
	public JLabel btmAtras;
	public JLabel btmActualizar;
	public JLabel tituRegsiPers;
	public JButton btnCargaHoraria;
	public JComboBox comSexo;
	public JLabel lblJornadaLaboral;
	public JComboBox comJornaLabo;
	public boolean btCar=false;

	
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
		
		
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		textApellido.setColumns(10);
		textApellido.setBounds(421, 133, 169, 24);
		add(textApellido);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(344, 131, 86, 23);
		add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(78, 182, 86, 23);
		add(lblTelefono);
		
		comCargo = new JComboBox();
		comCargo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comCargo.setModel(new DefaultComboBoxModel(new String[] {"", "Docente", "Administrativo", "Operativo"}));
		comCargo.setBounds(155, 235, 169, 23);
		add(comCargo);
		
		textTelef = new JTextField();
		textTelef.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textTelef.setColumns(10);
		textTelef.setBounds(155, 184, 169, 24);
		add(textTelef);
		
		JLabel lblCargo = new JLabel("Personal");
		lblCargo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCargo.setBounds(78, 235, 86, 23);
		add(lblCargo);
		
		JLabel lblFechNacimiento = new JLabel("Fec. Nac.");
		lblFechNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechNacimiento.setBounds(602, 182, 86, 23);
		add(lblFechNacimiento);
		
		textFecNaci =  new JDatePickerImpl(ca.GetCalendario(), new DateLabelFormatter());
		textFecNaci.setBounds(677, 184, 169, 24);
		add(textFecNaci);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(324, 123, 28, 14);
		add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_1.setBounds(589, 123, 28, 14);
		add(label_1);
		
		comStatus = new JComboBox();
		comStatus.setVisible(false);
		comStatus.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		comStatus.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comStatus.setBounds(677, 235, 169, 23);
		add(comStatus);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_2.setBounds(324, 226, 28, 14);
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
		label_3.setBounds(844, 123, 28, 14);
		add(label_3);
		
		lblStatus = new JLabel("Status");
		lblStatus.setVisible(false);
		lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblStatus.setBounds(602, 235, 66, 23);
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
		textNombre.setBounds(155, 133, 169, 24);
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
		textCedula.setBounds(677, 133, 169, 24);
		add(textCedula);
		
		comJornaLabo = new JComboBox();
		comJornaLabo.setVisible(false);
		comJornaLabo.setModel(new DefaultComboBoxModel(new String[] {"", "7:00-1:00", "1:00-6:00", "7:00-3:00", "8:00-4:00", "9:00-5:00", "10:00-6:00"}));
		comJornaLabo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comJornaLabo.setBounds(214, 287, 169, 23);
		add(comJornaLabo);
		
		lblJornadaLaboral = new JLabel("Jornada Laboral");
		lblJornadaLaboral.setVisible(false);
		lblJornadaLaboral.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblJornadaLaboral.setBounds(78, 287, 126, 23);
		add(lblJornadaLaboral);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCedula.setBounds(600, 131, 86, 23);
		add(lblCedula);
		
		btnCargaHoraria = new JButton("Carga horaria");
		btnCargaHoraria.setVisible(false);
		btnCargaHoraria.setBounds(155, 287, 169, 23);
		add(btnCargaHoraria);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSexo.setBounds(344, 184, 86, 23);
		add(lblSexo);
		
		comSexo = new JComboBox();
		comSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Femenino"}));
		comSexo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comSexo.setBounds(421, 184, 169, 23);
		add(comSexo);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label_4.setBounds(589, 177, 28, 14);
		add(label_4);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_3.setBounds(78, 131, 86, 23);
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
