package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classLibreria.Calendario;
import classLibreria.DateLabelFormatter;
import classLibreria.JDatePickerImpl;
import classLibreria.validarTablas;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelListarAsistencia extends JPanel {
	public JTable table;
	public JDatePickerImpl textFech;
	public JLabel btmExportar;
	public JComboBox comboTipoPers;
	public JButton btnJustInas;
	private Calendario ca = new Calendario();
	public JButton btnVerJustificacin;
	/**
	 * Create the panel.
	 */
	public PanelListarAsistencia() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 108, 839, 291);
		add(scrollPane);
		validarTablas va = new validarTablas();
		table = va.Validar2();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombre", "Apellido","Entrada", "Salida", "H.L", "Inas", "Inas.Just", "Total.Inas"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(20);
		table.getColumnModel().getColumn(8).setPreferredWidth(20);
	//	table.getColumnModel().getColumn(9).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		comboTipoPers = new JComboBox();
		comboTipoPers.setModel(new DefaultComboBoxModel(new String[] {"Docente", "Administrativo", "Operativo"}));
		comboTipoPers.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboTipoPers.setBounds(160, 58, 150, 25);
		add(comboTipoPers);
		
		JLabel lblNewLabel = new JLabel("Tipo de personal");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 61, 114, 20);
		add(lblNewLabel);
		
		textFech = new JDatePickerImpl(ca.GetCalendario(), new DateLabelFormatter());
		textFech.setBounds(410, 58, 166, 25);
		add(textFech);
		
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(352, 58, 48, 20);
		add(lblFecha);
		
		btnJustInas = new JButton("Justificar Inasistencia");
		btnJustInas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnJustInas.setBounds(685, 74, 190, 23);
		add(btnJustInas);
		
		btmExportar = new JLabel("New label");
			btmExportar.setBounds(326, 410, 235, 48);
		ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmExportarListado-1.png"));
		Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(btmExportar.getWidth(), btmExportar.getHeight(), Image.SCALE_DEFAULT));
		
		btnVerJustificacin = new JButton("Ver justificaci\u00F3n");
		btnVerJustificacin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnVerJustificacin.setBounds(685, 43, 190, 23);
		add(btnVerJustificacin);
		btmExportar.setIcon(icono1111);
		
		add(btmExportar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		lblNewLabel_1.setBounds(0, 0, 905, 469);
		ImageIcon fot11111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon icono11111 = new ImageIcon(fot11111.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono11111);
		add(lblNewLabel_1);

	}
}
