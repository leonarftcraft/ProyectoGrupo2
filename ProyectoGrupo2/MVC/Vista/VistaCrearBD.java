package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.AdministrarBD;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class VistaCrearBD extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCrearBD frame = new VistaCrearBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCrearBD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaCrearBD.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Importar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministrarBD a = new AdministrarBD();
				a.ImportarBD("asisPers", "1323027");
				dispose();
			}
		});
		btnNewButton.setBounds(106, 73, 235, 30);
		contentPane.add(btnNewButton);
		
		JButton btnCrearNuevaBase = new JButton("Crear nueva base de datos");
		btnCrearNuevaBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministrarBD a = new AdministrarBD();
				a.crearBD("asisPers", "/classLibreria/ScritAsisPers.txt", "1323027");
				dispose();
			}
		});
		btnCrearNuevaBase.setBounds(106, 143, 235, 30);
		contentPane.add(btnCrearNuevaBase);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(106, 215, 235, 30);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Administrar base de datos");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(98, 23, 259, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VistaCrearBD.class.getResource("/Dise\u00F1oGeneral/fondo.png")));
		lblNewLabel.setBounds(0, 0, 444, 272);
		contentPane.add(lblNewLabel);
	}
}
