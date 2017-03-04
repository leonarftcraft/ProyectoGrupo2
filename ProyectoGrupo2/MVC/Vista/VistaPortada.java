package Vista;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classLibreria.JPanelRound;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class VistaPortada extends JFrame {

	private Container contentPane;
	private Image ima;
	private URL dire;
	private JPanel panelMenu;
	
	public JLabel menGestiPers;
	public JLabel menGestAsis;
	public JLabel menRegiAsis;
	public JLabel menOpcioSiste;
	public JLabel itenAdminUsuar;
	public JLabel itenAdminMysql;
	public JLabel itenSalir;
	public boolean opciSiste = false;
	
	/**
	 * Create the frame.
	 */
	public VistaPortada() {
		setExtendedState(this.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 499);
		contentPane = getContentPane();		
		
		contentPane.add(panel);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		panel.setLayout(null);
		
		panelEscudo.setBounds(785, 93, 214, 188);
		panel.add(panelEscudo);
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 166, pantalla.width, 48);
		panelMenu.setBackground(Color.CYAN);
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel MenuFondo = new JLabel("New label");
		MenuFondo.setBounds(0, 0, pantalla.width, 48);
		ImageIcon fot = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/fondoMEnu.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(MenuFondo.getWidth(), MenuFondo.getHeight(), Image.SCALE_DEFAULT));
		MenuFondo.setIcon(icono);
		
		menGestiPers = new JLabel("New label");
		menGestiPers.setBounds(10, 0, 182, 48);
		ImageIcon fot2 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGesPersonal-1.png"));		
		Icon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(menGestiPers.getWidth(), menGestiPers.getHeight(), Image.SCALE_DEFAULT));		
		menGestiPers.setIcon(icono2);
		
		menGestAsis = new JLabel("New label");
		menGestAsis.setBounds(198, 0, 182, 48);
		ImageIcon fot3 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuGestAsistencia-1.png"));		
		Icon icono3 = new ImageIcon(fot3.getImage().getScaledInstance(menGestAsis.getWidth(), menGestAsis.getHeight(), Image.SCALE_DEFAULT));		
		menGestAsis.setIcon(icono3);
		
		menRegiAsis = new JLabel("New label");
		menRegiAsis.setBounds(387, 0, 182, 48);
		ImageIcon fot4 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuRegisAsitencia-1.png"));		
		Icon icono4 = new ImageIcon(fot4.getImage().getScaledInstance(menRegiAsis.getWidth(), menRegiAsis.getHeight(), Image.SCALE_DEFAULT));		
		menRegiAsis.setIcon(icono4);
		
		menOpcioSiste = new JLabel("New label");
		menOpcioSiste.setBounds(576, 0, 182, 48);
		ImageIcon fot5 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/menuOpcioSistema-1.png"));		
		Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(menOpcioSiste.getWidth(), menOpcioSiste.getHeight(), Image.SCALE_DEFAULT));		
		menOpcioSiste.setIcon(icono5);
		
		
		panelMenu.add(menOpcioSiste);
		
		
		panelMenu.add(menRegiAsis);		
		panelMenu.add(menGestAsis);
		panelMenu.add(menGestiPers);
		panelMenu.add(MenuFondo);
		
		
		panelMenbrete = new JPanel();
		panelMenbrete.setBounds(0, 0, pantalla.width, 166);
		panel.add(panelMenbrete);
		panelMenbrete.setBackground(Color.BLACK);
		panelMenbrete.setLayout(null);
		
		lblMenbrete = new JLabel("New label");
		lblMenbrete.setBounds(0, 0, pantalla.width, 166);
		ImageIcon nb = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/Menbrete.png"));
		Icon enb = new ImageIcon(nb.getImage().getScaledInstance(lblMenbrete.getWidth(), lblMenbrete.getHeight(), Image.SCALE_DEFAULT));
		lblMenbrete.setIcon(enb);
	
		panelMenbrete.add(lblMenbrete);
		
		menDes.setBounds(492, -158, 270, 146);

		panel.add(menDes);
		menDes.setLayout(null);
		
		itenAdminUsuar = new JLabel("New label");

		itenAdminUsuar.setBounds(0, 0, 270, 47);
		ImageIcon fot6 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminUsuario-1.png"));		
		Icon icono6 = new ImageIcon(fot6.getImage().getScaledInstance(itenAdminUsuar.getWidth(), itenAdminUsuar.getHeight(), Image.SCALE_DEFAULT));		
		itenAdminUsuar.setIcon(icono6);
		menDes.add(itenAdminUsuar);
		
		itenAdminMysql = new JLabel("New label");
	
		itenAdminMysql.setBounds(0, 47, 270, 47);
		ImageIcon fot7 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennAdminMysql-1.png"));		
		Icon icono7 = new ImageIcon(fot7.getImage().getScaledInstance(itenAdminMysql.getWidth(), itenAdminMysql.getHeight(), Image.SCALE_DEFAULT));		
		itenAdminMysql.setIcon(icono7);
		menDes.add(itenAdminMysql);
		
		itenSalir = new JLabel("New label");
	
		itenSalir.setBounds(0, 94, 270, 47);
		ImageIcon fot8 = new ImageIcon(VistaPortada.class.getResource("/VistaPortada/itennSalir-1.png"));		
		Icon icono8 = new ImageIcon(fot8.getImage().getScaledInstance(itenSalir.getWidth(), itenSalir.getHeight(), Image.SCALE_DEFAULT));		
		itenSalir.setIcon(icono8);
		menDes.add(itenSalir);
		
		this.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(ComponentEvent e){
                                                                                                                           
                       panelMenbrete.setSize(pantalla.width, panelMenbrete.getSize().height);
                       panelMenu.setSize(pantalla.width, panelMenu.getSize().height);
                       MenuFondo.setSize(panelMenu.getWidth(), MenuFondo.getSize().height);  
                       Icon icono = new ImageIcon(fot.getImage().getScaledInstance(MenuFondo.getWidth(), MenuFondo.getHeight(), Image.SCALE_DEFAULT));
               		   MenuFondo.setIcon(icono);
               		  
               		
			}
		});
		
		dire = this.getClass().getResource("/DiseñoGeneral/fondo.png");
		ima = new ImageIcon(dire).getImage();
	}
	private JPanel panelMenbrete;
	
	public JPanel panel = new JPanel(){
		public void paintComponent(Graphics g){		
			g.drawImage(ima, 0, 159, getWidth(), getHeight()-159, this);
		}
	};
	
	public JPanelRound menDes = new JPanelRound(){
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			AlphaComposite old = (AlphaComposite) g2.getComposite();
			g2.setComposite(AlphaComposite.SrcOver.derive( 0.5f));
			super.paintComponent(g);
			g2.setComposite(old);
			}
	};
	private JPanelRound panelEscudo = new JPanelRound(){
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			AlphaComposite old = (AlphaComposite) g2.getComposite();
			g2.setComposite(AlphaComposite.SrcOver.derive( 0.5f));
			super.paintComponent(g);
			g2.setComposite(old);
			}
	};
	private JLabel lblMenbrete;;
}
