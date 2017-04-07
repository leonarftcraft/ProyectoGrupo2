package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;

public class VistaVerJustificacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextPane textVerOpser;

	/**
	 * Create the dialog.
	 */
	public VistaVerJustificacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaVerJustificacion.class.getResource("/Dise\u00F1oGeneral/Asispro.fw.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textVerOpser = new JTextPane();
			textVerOpser.setEditable(false);
			textVerOpser.setBounds(44, 32, 348, 141);
			contentPanel.add(textVerOpser);
		}
		{
			JLabel lblNewLabel = new JLabel("Opservaci\u00F3n");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel.setBounds(44, 11, 134, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(163, 187, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}

}
