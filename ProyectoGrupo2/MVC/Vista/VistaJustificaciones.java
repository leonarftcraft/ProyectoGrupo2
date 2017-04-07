package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;

public class VistaJustificaciones extends JDialog {

	private JPanel contentPanel = new JPanel();
	public JTextField textHoraJust;
	public JTextField textInas;
	public JLabel btmAtras;
	public JLabel btmGuardar;
	private JLabel lblNewLabel;
	private JLabel lblObservacin;
	public JTextPane textOpserva;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaJustificaciones dialog = new VistaJustificaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaJustificaciones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaJustificaciones.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 405, 299);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHoraAJustificar = new JLabel("Hora a justificar");
		lblHoraAJustificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoraAJustificar.setBounds(28, 25, 113, 19);
		contentPanel.add(lblHoraAJustificar);
		
		textHoraJust = new JTextField();
		textHoraJust.setBounds(151, 24, 36, 20);
		contentPanel.add(textHoraJust);
		textHoraJust.setColumns(10);
		
		textOpserva = new JTextPane();
		textOpserva.setBounds(28, 77, 334, 116);
		contentPanel.add(textOpserva);
		
		JLabel lblInasistencia = new JLabel("Inasistencia");
		lblInasistencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblInasistencia.setBounds(233, 25, 91, 19);
		contentPanel.add(lblInasistencia);
		
		textInas = new JTextField();
		textInas.setEditable(false);
		textInas.setColumns(10);
		textInas.setBounds(326, 26, 36, 20);
		contentPanel.add(textInas);
		
		btmAtras = new JLabel("New label");
	
		btmAtras.setBounds(28, 215, 113, 35);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmAtras-1.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(btmAtras.getWidth(), btmAtras.getHeight(), Image.SCALE_DEFAULT));
		btmAtras.setIcon(icono11);
		lblObservacin = new JLabel("Observaci\u00F3n");
		lblObservacin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblObservacin.setBounds(28, 55, 113, 19);
		contentPanel.add(lblObservacin);
			
		contentPanel.add(btmAtras);
		
		btmGuardar = new JLabel("New label");
		btmGuardar.setBounds(249, 215, 113, 35);
		ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/Dise\u00F1oGeneral/btmGuardar-1.png"));
		Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(btmGuardar.getWidth(), btmGuardar.getHeight(), Image.SCALE_DEFAULT));
		btmGuardar.setIcon(icono111);
		contentPanel.add(btmGuardar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VistaJustificaciones.class.getResource("/Dise\u00F1oGeneral/fondo.png")));
		lblNewLabel.setBounds(0, 0, 399, 271);
		contentPanel.add(lblNewLabel);
	}
}
