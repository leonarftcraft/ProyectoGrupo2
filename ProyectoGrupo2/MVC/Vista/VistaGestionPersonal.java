package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.VistaPortada;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;

public class VistaGestionPersonal extends JDialog {

	public JPanel contentPanel = new JPanel();
	public JLabel menRegistrar;
	public JLabel menListar;

	/**
	 * Create the dialog.
	 */
	public VistaGestionPersonal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//codigo que no permite el acceso a otras ventanas mientras este en ejecucion esta
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		
		setBounds(100, 100, 914, 510);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = getSize();
        //igual pero para la ventana
        setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
        setSize(934, 546);
        setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 928, 46);
		contentPanel.add(panel);
		panel.setLayout(null);
	
		menRegistrar = new JLabel("New label");
		menRegistrar.setBounds(10, 0, 214, 46);
		ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Registrar-1.png"));
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(menRegistrar.getWidth(), menRegistrar.getHeight(), Image.SCALE_DEFAULT));
		menRegistrar.setIcon(icono1);
		panel.add(menRegistrar);
		
		menListar = new JLabel("New label");
		menListar.setBounds(230, 0, 214, 46);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/VistaGestionPersonal/Listar-2.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(menListar.getWidth(), menListar.getHeight(), Image.SCALE_DEFAULT));
		menListar.setIcon(icono11);
		panel.add(menListar);
		
		JLabel menGestPers = new JLabel("New label");
		menGestPers.setBounds(0, 0, 928, 46);
		ImageIcon fot = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/fondoMEnu.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(menGestPers.getWidth(), menGestPers.getHeight(), Image.SCALE_DEFAULT));
		menGestPers.setIcon(icono);
		panel.add(menGestPers);
		
		
		
		
		
		
		
	}
}
