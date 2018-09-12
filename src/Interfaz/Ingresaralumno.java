package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Conexion.Conexion;

public class Ingresaralumno extends JFrame {

	private JPanel contentPane;
	private JTextField codigoe;
	private JTextField codigoc;
	private JTextField name;
	private JTextField direction;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingresaralumno frame = new Ingresaralumno();
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
	public Ingresaralumno() {
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

		JPanel panelingresar = new JPanel();
		panelingresar.setBounds(0, 0, 650, 82);
		contentPane.add(panelingresar);
		panelingresar.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(587, 26, 32, 32);
		panelingresar.add(lblNewLabel);
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

		JLabel lblNewLabel_1 = new JLabel("INGRESAR");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 25));
		lblNewLabel_1.setBounds(94, 13, 235, 56);
		panelingresar.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-insertar-64.png")));
		lblNewLabel_2.setBounds(14, 13, 56, 56);
		panelingresar.add(lblNewLabel_2);

		JPanel correo = new JPanel();
		correo.setBackground(SystemColor.window);
		correo.setBounds(232, 788, 392, 37);
		contentPane.add(correo);
		correo.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-nuevo-post-32.png")));
		label_2.setBounds(0, 0, 56, 40);
		correo.add(label_2);

		email = new JTextField();
		email.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		email.setColumns(10);
		email.setBounds(70, 0, 322, 40);
		correo.add(email);

		JPanel direccion = new JPanel();
		direccion.setBackground(SystemColor.window);
		direccion.setBounds(232, 642, 392, 37);
		contentPane.add(direccion);
		direccion.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				Ingresaralumno.class.getResource("/imagenes/icons8-ubicaci\u00F3n-en-todo-el-mundo-32.png")));
		label_1.setBounds(0, 0, 56, 40);
		direccion.add(label_1);

		direction = new JTextField();
		direction.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		direction.setColumns(10);
		direction.setBounds(68, 0, 322, 40);
		direccion.add(direction);

		JPanel nombre = new JPanel();
		nombre.setBackground(SystemColor.textHighlightText);
		nombre.setBounds(232, 510, 392, 37);
		contentPane.add(nombre);
		nombre.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-usuario-32.png")));
		label.setBounds(0, 0, 56, 40);
		nombre.add(label);

		name = new JTextField();
		name.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		name.setColumns(10);
		name.setBounds(68, 0, 322, 40);
		nombre.add(name);

		JPanel carrera = new JPanel();
		carrera.setBackground(SystemColor.textHighlightText);
		carrera.setBounds(232, 390, 392, 37);
		contentPane.add(carrera);
		carrera.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-contrase\u00F1a-32 (1).png")));
		lblNewLabel_4.setBounds(0, 0, 56, 40);
		carrera.add(lblNewLabel_4);

		codigoc = new JTextField();
		codigoc.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		codigoc.setColumns(10);
		codigoc.setBounds(70, 0, 322, 40);
		carrera.add(codigoc);

		JPanel Estudiante = new JPanel();
		Estudiante.setBackground(SystemColor.window);
		Estudiante.setBounds(232, 282, 392, 37);
		contentPane.add(Estudiante);
		Estudiante.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(
				new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-contrase\u00F1a-32 (1).png")));
		lblNewLabel_5.setBounds(0, 0, 56, 40);
		Estudiante.add(lblNewLabel_5);

		codigoe = new JTextField();
		codigoe.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		codigoe.setBounds(70, 0, 322, 40);
		Estudiante.add(codigoe);
		codigoe.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(
				new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-estudiante-masculino-96 (2).png")));
		lblNewLabel_3.setBounds(12, 127, 626, 105);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel("C\u00D3DIGO DEL ESTUDIANTE");
		lblNewLabel_6.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblNewLabel_6.setBounds(22, 245, 349, 16);
		contentPane.add(lblNewLabel_6);

		JLabel lblIngreseElCdigo = new JLabel("C\u00D3DIGO DE CARRERA");
		lblIngreseElCdigo.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblIngreseElCdigo.setBounds(22, 361, 349, 16);
		contentPane.add(lblIngreseElCdigo);

		JLabel lblNombreCompleto = new JLabel("NOMBRE COMPLETO");
		lblNombreCompleto.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblNombreCompleto.setBounds(22, 481, 349, 16);
		contentPane.add(lblNombreCompleto);

		JLabel lblDireccin = new JLabel("DIRECCI\u00D3N");
		lblDireccin.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblDireccin.setBounds(22, 616, 349, 16);
		contentPane.add(lblDireccin);

		JLabel lblCorreoElectrnico = new JLabel("CORREO ELECTR\u00D3NICO");
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

		JButton button = new JButton("GUARDAR");
		button.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		button.setBounds(124, 892, 423, 45);
		contentPane.add(button);
		setResizable(false);
		setUndecorated(true);

		/*****
		 * Conexion mariadb para actualizar producto
		 */

		try {

			Conexion conexion = new Conexion("root", "", "neptuno");

			Integer.parseInt(codigoe.getText());
			Integer.parseInt(codigoc.getText());
			direction.getText();
			email.getText();

			String query = "INSERT INTO Estudiante (" + "cod_carrera," + "nombre =?," + "dirección =?,"
					+ "Correoelectrònico =?)";

			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			conexion.modificacion();
			conexion.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}