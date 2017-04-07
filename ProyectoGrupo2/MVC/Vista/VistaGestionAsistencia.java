package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;

public class VistaGestionAsistencia extends JDialog {

	public JPanel contentPanel = new JPanel();
	public JLabel menLisAsis;
	public JLabel menListarAsisIndib;
	public JLabel menLisSanc;
	private JLabel lblNewLabel;


	/**
	 * Create the dialog.
	 */
	public VistaGestionAsistencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaGestionAsistencia.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 921, 553);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 905, 46);
		contentPanel.add(panel);
		panel.setLayout(null);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = getSize();
        //igual pero para la ventana
        setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
		menLisAsis = new JLabel("New label");
		
		menLisAsis.setBounds(10, 0, 267, 46);
		ImageIcon fot1 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/iteLisAsis-2.png"));
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(menLisAsis.getWidth(), menLisAsis.getHeight(), Image.SCALE_DEFAULT));
		menLisAsis.setIcon(icono1);
		panel.add(menLisAsis);
		
		menListarAsisIndib = new JLabel("New label");
		
		menListarAsisIndib.setBounds(283, 0, 267, 46);
		ImageIcon fot11 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisAsisIndi-1.png"));
		Icon icono11 = new ImageIcon(fot11.getImage().getScaledInstance(menListarAsisIndib.getWidth(), menListarAsisIndib.getHeight(), Image.SCALE_DEFAULT));
		menListarAsisIndib.setIcon(icono11);
		panel.add(menListarAsisIndib);
		
		menLisSanc = new JLabel("New label");
		
		menLisSanc.setBounds(558, 0, 267, 46);
		ImageIcon fot111 = new ImageIcon(VistaPortada.class.getResource("/vistaGestionAsistencia/itenLisSancio-1.png"));
		Icon icono111 = new ImageIcon(fot111.getImage().getScaledInstance(menLisSanc.getWidth(), menLisSanc.getHeight(), Image.SCALE_DEFAULT));
		menLisSanc.setIcon(icono111);
		panel.add(menLisSanc);
		
		lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setBounds(0, 0, 905, 46);
		ImageIcon fot1111 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/fondoMEnu.png"));
		Icon icono1111 = new ImageIcon(fot1111.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono1111);
		panel.add(lblNewLabel);
		
		//panel_1.setBounds(0, 46, 905, 469);
	}
}
