package Ingresar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class Ingresardocente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingresardocente frame = new Ingresardocente();
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
	public Ingresardocente() {
		/*
		 * Se importo un jar llamado rsutilities Con este se puede configurar la ventana
		 * 
		 */
		rsutilities.RSUtilities.setCentrarVentana(this);
		rsutilities.RSUtilities.setMoverVentana(this);
		rsutilities.RSUtilities.setOpaqueVentana(this, false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 030, 650, 950);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/***
		 * Icono de cerrar, y quitar las opciones de cerrado y decorado de arriba
		 * predeterminadas de Java
		 * 
		 */

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 650, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(587, 26, 32, 32);
		panel.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			/***
			 * Nuevo icono para cerrar con Joptionpane preguntando si desea salir :v
			 */

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = JOptionPane.YES_NO_OPTION;
				int re = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?", "Salir", i);
				if (re == 0) {
					System.exit(0);
				}
			}

			/**
			 * Marca de agua cuando el mouse esta sobre la x
			 */
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 255)));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(155, 155, 155)));

			}
		});
		lblNewLabel.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8_Multiply_32px.png")));

		JLabel lblNewLabel_1 = new JLabel("INGRESAR DOCENTE");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 25));
		lblNewLabel_1.setBounds(94, 13, 280, 56);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-insertar-64.png")));
		lblNewLabel_2.setBounds(14, 13, 56, 56);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(232, 788, 392, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Ingresardocente.class.getResource("/imagenes/icons8-plan-de-estudios-32.png")));
		label_2.setBounds(0, 0, 56, 40);
		panel_1.add(label_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(232, 642, 392, 37);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Ingresardocente.class.getResource("/imagenes/icons8-cumplea\u00F1os-32.png")));
		label_1.setBounds(0, 0, 56, 40);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.textHighlightText);
		panel_3.setBounds(232, 510, 392, 37);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-usuario-32.png")));
		label.setBounds(0, 0, 56, 40);
		panel_3.add(label);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.textHighlightText);
		panel_4.setBounds(232, 390, 392, 37);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Ingresardocente.class.getResource("/imagenes/icons8-fecha-desde-32.png")));
		lblNewLabel_4.setBounds(0, 0, 56, 40);
		panel_4.add(lblNewLabel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_5.setBounds(232, 282, 392, 37);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(
				new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-contrase\u00F1a-32 (1).png")));
		lblNewLabel_5.setBounds(0, 0, 56, 40);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Ingresardocente.class.getResource("/imagenes/icons8-aula-96 (1).png")));
		lblNewLabel_3.setBounds(12, 127, 626, 105);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel("C\u00D3DIGO DEL DOCENTE");
		lblNewLabel_6.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblNewLabel_6.setBounds(22, 245, 349, 16);
		contentPane.add(lblNewLabel_6);

		JLabel lblIngreseElCdigo = new JLabel("FECHA DE ENTRADA");
		lblIngreseElCdigo.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblIngreseElCdigo.setBounds(22, 361, 349, 16);
		contentPane.add(lblIngreseElCdigo);

		JLabel lblNombreCompleto = new JLabel("NOMBRE COMPLETO");
		lblNombreCompleto.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblNombreCompleto.setBounds(22, 481, 349, 16);
		contentPane.add(lblNombreCompleto);

		JLabel lblDireccin = new JLabel("FECHA DE NACIMIENTO");
		lblDireccin.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblDireccin.setBounds(22, 616, 349, 16);
		contentPane.add(lblDireccin);

		JLabel lblCorreoElectrnico = new JLabel("CARRERA");
		lblCorreoElectrnico.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblCorreoElectrnico.setBounds(22, 753, 349, 16);
		contentPane.add(lblCorreoElectrnico);

		JSeparator separator = new JSeparator();
		separator.setBounds(329, 332, -86, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.controlShadow);
		separator_1.setBounds(302, 324, 322, 1);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.controlShadow);
		separator_2.setBounds(302, 432, 322, 4);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(SystemColor.controlShadow);
		separator_3.setBounds(302, 551, 322, 10);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(SystemColor.controlShadow);
		separator_4.setBounds(302, 684, 322, 10);
		contentPane.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(SystemColor.controlShadow);
		separator_5.setBounds(302, 825, 322, 16);
		contentPane.add(separator_5);

		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnNewButton.setBounds(113, 879, 423, 45);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("\u00A1TODOS LOS CAMPOS SON REQUERIDOS!");
		lblNewLabel_7.setToolTipText("");
		lblNewLabel_7.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		lblNewLabel_7.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblNewLabel_7.setBounds(147, 850, 362, 16);
		contentPane.add(lblNewLabel_7);
		setResizable(false);
		setUndecorated(true);
	}
}
