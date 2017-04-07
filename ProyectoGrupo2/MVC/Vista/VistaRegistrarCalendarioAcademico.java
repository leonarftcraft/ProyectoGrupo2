package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classLibreria.Calendario;
import classLibreria.DateLabelFormatter;
import classLibreria.JDatePickerImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;

public class VistaRegistrarCalendarioAcademico extends JDialog {

	private JPanel contentPanel = new JPanel();
	public JDatePickerImpl textFechInci;
	public JDatePickerImpl textFechFin;
	public JLabel btmAtras;
	public JLabel btmGuardar;
	private Calendario ca = new Calendario();
	public JLabel btmActulizar;

	/**
	 * Create the dialog.
	 */
	public VistaRegistrarCalendarioAcademico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRegistrarCalendarioAcademico.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 465, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFechInci = new JDatePickerImpl(ca.GetCalendario(), new DateLabelFormatter());
		textFechInci.setBounds(188, 78, 169, 23);
		contentPanel.add(textFechInci);
		
		
		textFechFin = new JDatePickerImpl(ca.GetCalendario(), new DateLabelFormatter());
		textFechFin.setBounds(188, 146, 169, 23);
		contentPanel.add(textFechFin);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		lblFechaDeInicio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFechaDeInicio.setBounds(72, 78, 119, 23);
		contentPanel.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFechaDeFin.setBounds(85, 146, 93, 23);
		contentPanel.add(lblFechaDeFin);
		
		btmGuardar = new JLabel("New label");
		
		btmGuardar.setBounds(267, 207, 113, 36);
		ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
		
		btmActulizar = new JLabel("New label");
	
		btmActulizar.setBounds(267, 207, 113, 36);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmActualizar-1.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(btmActulizar.getWidth(), btmActulizar.getHeight(), Image.SCALE_DEFAULT));
		btmActulizar.setIcon(icono11);
		contentPanel.add(btmActulizar);
		btmGuardar.setIcon(icono11);
		contentPanel.add(btmGuardar);
		
		btmAtras = new JLabel("New label");
	
		btmAtras.setBounds(69, 207, 113, 36);
		ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmAtras.setIcon(icono111);
		contentPanel.add(btmAtras);
		
		JLabel lblNewLabel_1 = new JLabel("New label");

		lblNewLabel_1.setBounds(0, 0, 449, 271);
		ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono1111);
		contentPanel.add(lblNewLabel_1);
	}
}
