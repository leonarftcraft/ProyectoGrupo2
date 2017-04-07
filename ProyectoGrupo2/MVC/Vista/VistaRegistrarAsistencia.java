package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;

public class VistaRegistrarAsistencia extends JDialog {

	private JPanel contentPanel = new JPanel();
	public JTextField texCedu;
	public JLabel btmGuardar;
	private JLabel lblCedula;
	public JComboBox comNaciona;
	private JLabel lblNewLabel_1;
	public JLabel btmAtras;
	private JLabel lblCalendarioAcademico;
	private JLabel lblIniciaEl;
	public JLabel labFechInic;
	private JLabel lblTerminaEl;
	public JLabel labFechFin;
	public JButton btnModifiCale;



	/**
	 * Create the dialog.
	 */
	public VistaRegistrarAsistencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRegistrarAsistencia.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 823, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			texCedu = new JTextField();
			texCedu.setBounds(378, 216, 133, 29);
			contentPanel.add(texCedu);
			texCedu.setColumns(10);
		}
		{
			JLabel lblAsistencia = new JLabel("Asistencia");
			lblAsistencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblAsistencia.setBounds(368, 185, 75, 20);
			contentPanel.add(lblAsistencia);
		}
		
			btmGuardar = new JLabel("New label");

			btmGuardar.setBounds(328, 279, 143, 29);
			ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
			Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
			btmGuardar.setIcon(icono11);
			contentPanel.add(btmGuardar);
		
		{
			lblNewLabel_1 = new JLabel("");
		
			lblNewLabel_1.setBounds(243, 152, 313, 186);
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/marco.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
			lblNewLabel_1.setIcon(icono111);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblCedula = new JLabel("Cedula");
			lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblCedula.setBounds(268, 218, 55, 20);
			contentPanel.add(lblCedula);
		}
		{
			btmAtras = new JLabel("New label");
			
			btmAtras.setBounds(10, 383, 143, 29);
			ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
			Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
			{
				lblCalendarioAcademico = new JLabel("Calendario Academico");
				lblCalendarioAcademico.setForeground(Color.BLUE);
				lblCalendarioAcademico.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				lblCalendarioAcademico.setBounds(568, 11, 184, 29);
				contentPanel.add(lblCalendarioAcademico);
			}
			btmAtras.setIcon(icono111);
			contentPanel.add(btmAtras);
		}
		{
			lblIniciaEl = new JLabel("Inicia el");
			lblIniciaEl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblIniciaEl.setBounds(499, 39, 64, 20);
			contentPanel.add(lblIniciaEl);
		}
		{
			labFechInic = new JLabel("0000-00-00");
			labFechInic.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			labFechInic.setBounds(558, 39, 87, 20);
			contentPanel.add(labFechInic);
		}
		{
			lblTerminaEl = new JLabel("Termina el");
			lblTerminaEl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblTerminaEl.setBounds(642, 39, 81, 20);
			contentPanel.add(lblTerminaEl);
		}
		
		comNaciona = new JComboBox();
		comNaciona.setModel(new DefaultComboBoxModel(new String[] {"", "V-", "E-"}));
		comNaciona.setBounds(322, 216, 47, 29);
		contentPanel.add(comNaciona);
		
		JLabel lblNewLabel = new JLabel("New label");

		lblNewLabel.setBounds(0, 0, 807, 423);
		ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/fondo.png"));
		Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		{
			btnModifiCale = new JButton("Modificar calendario");
			btnModifiCale.setBounds(570, 70, 153, 23);
			contentPanel.add(btnModifiCale);
		}
		{
			labFechFin = new JLabel("0000-00-00");
			labFechFin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			labFechFin.setBounds(720, 39, 87, 20);
			contentPanel.add(labFechFin);
		}
		lblNewLabel.setIcon(icono111);
		contentPanel.add(lblNewLabel);
	}
}
