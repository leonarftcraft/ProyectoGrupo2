package Vista;

import java.awt.AWTError;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.animation.effects.EffectsManager;

import Controlador.ControladorVistaMenuPrincipal;
import Modelo.CarruselDeImagenes;
import classLibreria.JPanelRound;

import org.apache.batik.parser.AWTTransformProducer;
import org.edisoncor.gui.button.ButtonAction;
import org.edisoncor.gui.button.ButtonIcon;
import org.edisoncor.gui.button.ButtonPopup;
import org.edisoncor.gui.button.ButtonTransluceIcon;
import org.edisoncor.gui.panel.PanelTranslucido;
import org.edisoncor.gui.panel.PanelShadow;
import org.edisoncor.gui.panel.PanelRoundTranslucidoComplete;
import org.edisoncor.gui.panel.PanelRound;
import org.edisoncor.gui.panel.PanelAvatarChooser;
import org.edisoncor.gui.panel.PanelCurves;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.edisoncor.gui.panel.PanelNice;
import org.edisoncor.gui.varios.ClockFace;
import org.edisoncor.gui.panel.Panel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.edisoncor.gui.panel.PanelImageReflect;
import org.edisoncor.gui.panel.PanelReflect;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import org.edisoncor.gui.button.ButtonCircle;
import org.edisoncor.gui.button.ButtonShadow;
import org.edisoncor.gui.button.ButtonTask;
import org.edisoncor.gui.varios.PanelDeslizante;
import org.edisoncor.gui.textField.TextFieldRoundImage;
import org.edisoncor.gui.util.Avatar;
import org.edisoncor.gui.textField.TextFieldRoundIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VistaMenuPrincipal extends JFrame {

	
	public JLabel lblcarrusel;
	public JLabel lblImag1;
	public JLabel lablblImag2;
	public JLabel lablblImag3;
	public JLabel lablblImag5;
	public JLabel lablblImag4;
	public ButtonCircle butConfCarru;
	public PanelNice panelConfig;
	public ButtonTask btntImag1;
	public ButtonTask btntImag2;
	public ButtonTask btntImag3;
	public ButtonTask btntImag4;
	public ButtonTask btntImag5;
	public PanelAvatarChooser panelAvatarChooser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenuPrincipal frame = new VistaMenuPrincipal();
						
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public VistaMenuPrincipal(){
		intComponet();
		iniciarCarrusel();
		llenarMenu();
	}
	
	public void llenarMenu(){
	List<Avatar> icoMenu = new ArrayList<Avatar>();
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	icoMenu.add(new Avatar("Gestion Personal", cargarImagen("/menu/Personal.png")));
	icoMenu.add(new Avatar("Gestion Asistencia", cargarImagen("/menu/gestAsist.png")));
	icoMenu.add(new Avatar("Registrar Asistencia", cargarImagen("/menu/AsisPro.png")));
	icoMenu.add(new Avatar("Administrar Sistema", cargarImagen("/menu/AdminSistema.png")));
	icoMenu.add(new Avatar("Salir", cargarImagen("/menu/cerrar.png")));
	panelAvatarChooser.setAvatars(icoMenu);
	
	

	}
	public Image cargarImagen(String url){
		
		try {
			return ImageIO.read(VistaMenuPrincipal.class.getResource(url));
			
		} catch (Exception e) {
			return null;
		}
		
		
		
		
	}
	public void iniciarCarrusel(){
		CarruselDeImagenes ca = new CarruselDeImagenes(lblcarrusel);
		ca.cargarImagenes();
		ca.iniciarCarrusel();
		
		
		Icon icono = new ImageIcon(ca.getImag1().getImage().getScaledInstance(lblImag1.getWidth(), lblImag1.getHeight(), Image.SCALE_DEFAULT));
		lblImag1.setIcon(icono);
		Icon icono1 = new ImageIcon(ca.getImag2().getImage().getScaledInstance(lablblImag2.getWidth(), lablblImag2.getHeight(), Image.SCALE_DEFAULT));
		lablblImag2.setIcon(icono1);
		Icon icono11 = new ImageIcon(ca.getImag3().getImage().getScaledInstance(lablblImag3.getWidth(), lablblImag3.getHeight(), Image.SCALE_DEFAULT));
		lablblImag3.setIcon(icono11);
		Icon icono111 = new ImageIcon(ca.getImag4().getImage().getScaledInstance(lablblImag4.getWidth(), lablblImag4.getHeight(), Image.SCALE_DEFAULT));
		lablblImag4.setIcon(icono111);
		Icon icono1111 = new ImageIcon(ca.getImag5().getImage().getScaledInstance(lablblImag5.getWidth(), lablblImag5.getHeight(), Image.SCALE_DEFAULT));
		lablblImag5.setIcon(icono1111);

	}
	/**
	 * Create the frame.
	 */
	public void intComponet() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 563);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = getSize();
        //igual pero para la ventana
        setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
		
		panelConfig = new PanelNice();
		panelConfig.setToolTipText("");
		panelConfig.setAnchoDeBorde(4.0f);
		panelConfig.setBorder(UIManager.getBorder("CheckBox.border"));
		panelConfig.setBorderColor(Color.BLACK);
		panelConfig.setBackground(Color.BLUE);
		panelConfig.setBounds(0, 560, 773, 285);
		//panelConfig.setBounds(0, 255, 773, 285);
		contentPane.add(panelConfig);
		panelConfig.setLayout(null);
		
		lblImag1 = new JLabel("New label");
	
		lblImag1.setBounds(29, 11, 170, 126);
		panelConfig.add(lblImag1);
		
		lablblImag2 = new JLabel("New label");
	
		
		lablblImag2.setBounds(209, 11, 170, 126);
		panelConfig.add(lablblImag2);
		
		lablblImag3 = new JLabel("New label");
	
		
		lablblImag3.setBounds(389, 11, 170, 126);
		panelConfig.add(lablblImag3);
		
		lablblImag4 = new JLabel("New label");
	
		lablblImag4.setBounds(569, 11, 170, 126);
		panelConfig.add(lablblImag4);
		
		lablblImag5 = new JLabel("New label");
	
		lablblImag5.setBounds(296, 148, 170, 126);
		panelConfig.add(lablblImag5);
		
		btntImag1 = new ButtonTask();
		btntImag1.addActionListener(new ControladorVistaMenuPrincipal(this, "btntImag1"));
		btntImag1.setText(" ");
		btntImag1.setDescription(" ");
		btntImag1.setBounds(21, 137, 61, 50);
		panelConfig.add(btntImag1);
		
		btntImag2 = new ButtonTask();
		btntImag2.addActionListener(new ControladorVistaMenuPrincipal(this, "btntImag2"));
		btntImag2.setText(" ");
		btntImag2.setDescription(" ");
		btntImag2.setBounds(198, 137, 61, 50);
		panelConfig.add(btntImag2);
		
		btntImag3 = new ButtonTask();
		btntImag3.addActionListener(new ControladorVistaMenuPrincipal(this, "btntImag3"));
		btntImag3.setText(" ");
		btntImag3.setDescription(" ");
		btntImag3.setBounds(511, 137, 61, 50);
		panelConfig.add(btntImag3);
		
		btntImag4 = new ButtonTask();
		btntImag4.addActionListener(new ControladorVistaMenuPrincipal(this, "btntImag4"));
		btntImag4.setText(" ");
		btntImag4.setDescription(" ");
		btntImag4.setBounds(688, 137, 61, 50);
		panelConfig.add(btntImag4);
		
		btntImag5 = new ButtonTask();
		btntImag5.addActionListener(new ControladorVistaMenuPrincipal(this, "btntImag5"));
		btntImag5.setText(" ");
		btntImag5.setDescription(" ");
		btntImag5.setBounds(459, 235, 61, 50);
		panelConfig.add(btntImag5);
		PanelCurves panelCurves = new PanelCurves();
		panelCurves.setForeground(Color.WHITE);
		panelCurves.setBackground(Color.WHITE);
		panelCurves.setBounds(0, 0, 785, 563);
		contentPane.add(panelCurves);
		panelCurves.setLayout(null);
		
		butConfCarru = new ButtonCircle();
		
		butConfCarru.setBounds(375, 535, 35, 24);
		panelCurves.add(butConfCarru);
		butConfCarru.addActionListener(new ControladorVistaMenuPrincipal(this, "butConfCarru"));
		
		PanelReflect panelReflect = new PanelReflect();
		panelReflect.setBounds(0, 195, 10, 10);
		panelCurves.add(panelReflect);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-14, 241, 820, 14);
		ImageIcon fot = new ImageIcon(VistaMenuPrincipal.class.getResource("/VistaMenuPrincipal/Separador.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		panelCurves.add(lblNewLabel);
		
		PanelNice panelNice_1 = new PanelNice();
		panelNice_1.setForeground(Color.WHITE);
		panelNice_1.setBackground(Color.BLUE);
		panelNice_1.setBounds(10, 280, 211, 212);
		panelCurves.add(panelNice_1);
		panelNice_1.setLayout(null);
		
		ClockFace clockFace = new ClockFace();
		clockFace.setBounds(10, 11, 193, 219);
		panelNice_1.add(clockFace);
		clockFace.setBackground(Color.GRAY);
		clockFace.setRomano(false);
		
		PanelNice panelNice_2 = new PanelNice();
		panelNice_2.setLayout(null);
		panelNice_2.setForeground(Color.WHITE);
		panelNice_2.setBackground(Color.BLUE);
		panelNice_2.setBounds(551, 280, 211, 212);
		panelCurves.add(panelNice_2);
		
		PanelNice panelNice_3 = new PanelNice();
		panelNice_3.setForeground(Color.WHITE);
		panelNice_3.setBackground(Color.BLUE);
		panelNice_3.setBounds(231, 280, 310, 212);
		panelCurves.add(panelNice_3);
		panelNice_3.setLayout(null);
		
		lblcarrusel = new JLabel("New label");
		lblcarrusel.setBounds(0, 0, 310, 212);
		panelNice_3.add(lblcarrusel);
		
		panelAvatarChooser = new PanelAvatarChooser();
		panelAvatarChooser.setColorSecundario(Color.BLUE);
		panelAvatarChooser.setColorPrimario(Color.BLACK);
		panelAvatarChooser.setBounds(0, 38, 785, 285);
		contentPane.add(panelAvatarChooser);
		panelAvatarChooser.setLayout(null);
		
		PanelNice panelNice = new PanelNice();
		panelNice.setBackground(Color.BLUE);
		panelNice.setForeground(Color.BLACK);
		panelNice.setBounds(-12, 38, 804, 545);
		contentPane.add(panelNice);
		panelNice.setLayout(null);
		
	
		
	
	}
	public JPanelRound contentPane = new JPanelRound(){
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			AlphaComposite old = (AlphaComposite) g2.getComposite();
			g2.setComposite(AlphaComposite.SrcOver.derive( 0.9f));
			super.paintComponent(g);
			g2.setComposite(old);
			}
	};
}
