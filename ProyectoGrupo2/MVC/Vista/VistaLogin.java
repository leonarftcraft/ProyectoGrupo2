package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class VistaLogin extends JFrame {

	private JPanel contentPane;
	public JTextField textUser;
	public JPasswordField texPass;
	public JButton btnIniciar;
	
	/**
	 * Create the frame.
	 */
	public VistaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaLogin.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(264, 50, 150, 32);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		texPass = new JPasswordField();
		texPass.setBounds(264, 107, 150, 32);
		contentPane.add(texPass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblUsuario.setBounds(193, 57, 58, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContrasea.setBounds(173, 114, 81, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VistaLogin.class.getResource("/Login/icologinn.png")));
		lblNewLabel.setBounds(10, 11, 162, 154);
		contentPane.add(lblNewLabel);
		
		btnIniciar = new JButton("Iniciar ");
		btnIniciar.setBounds(293, 161, 89, 23);
		contentPane.add(btnIniciar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VistaLogin.class.getResource("/Dise\u00F1oGeneral/fondo.png")));
		lblNewLabel_1.setBounds(0, 0, 444, 208);
		contentPane.add(lblNewLabel_1);
	}
}
