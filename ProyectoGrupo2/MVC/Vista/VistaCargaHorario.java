package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classLibreria.Celda_CheckBox;
import classLibreria.Render_CheckBox;
import classLibreria.validarTablas;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;

public class VistaCargaHorario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTable table;
	public JLabel btmGuardar;
	public JLabel btmAtras = new JLabel("New label");
	public JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaCargaHorario dialog = new VistaCargaHorario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaCargaHorario() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 828, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 73, 682, 230);
		contentPanel.add(scrollPane);
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
				{"10:15-11:00", false, false, false, false, false},
				{"11:00-11:45", false, false, false, false, false},
				{"11:45-12:30", false, false, false, false, false},
				{"1:00-1:45", false, false, false, false, false},
				{"1:45-2:30", false, false, false, false, false},
				{"2:40-3:25", false, false, false, false, false},
				{"3:25-4:10", false, false, false, false, false},
				{"4:15-5:00", false, false, false, false, false},
				{"5:00-5:45", false, false, false, false, false},
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
		
		btmGuardar = new JLabel("New label");
		
		btmGuardar.setBounds(540, 352, 151, 37);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(662, 49, 89, 23);
		contentPanel.add(btnLimpiar);
		btmGuardar.setIcon(icono11);

		contentPanel.add(btmGuardar);
		
		btmAtras.setBounds(124, 352, 151, 37);
		ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmAtras.setIcon(icono111);
		
		contentPanel.add(btmAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
	
		lblNewLabel.setBounds(0, 0, 812, 400);
		ImageIcon tmA = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon mAt = new ImageIcon(tmA.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(mAt);
		contentPanel.add(lblNewLabel);
	}
}
