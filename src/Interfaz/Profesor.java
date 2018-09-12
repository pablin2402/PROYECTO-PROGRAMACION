package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import Ingresar.Ingresardocente;

public class Profesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesor frame = new Profesor();
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
	public Profesor() {
		/*
		 * Se importo un jar llamado rsutilities Con este se puede configurar la ventana
		 * 
		 */
		rsutilities.RSUtilities.setCentrarVentana(this);
		rsutilities.RSUtilities.setMoverVentana(this);
		rsutilities.RSUtilities.setOpaqueVentana(this, false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final DefaultTableModel modelo = new DefaultTableModel();

		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// Limpiamos el modelo cada que hagamos una consulta
				modelo.setRowCount(0);
				modelo.setColumnCount(0);
				// notifies the JTable that the model has changed
				// Creamos las columnas.

				modelo.addColumn("CÓDIGO DEL DOCENTE");
				modelo.addColumn("FECHA DE ENTRADA");
				modelo.addColumn("NOMBRE");
				modelo.addColumn("FECHA DE NACIMIENTO");
				modelo.addColumn("CARRERA");

				ResultSet rs;

				try {

					Conexion conexion = new Conexion("root", "", "universidad");
					conexion.consulta(
							"select cod_Docente, fecha_entrada, Nombre, fecha_Nacimiento, Carrera from DOCENTE ");

					rs = conexion.resultado();

					while (rs.next()) {

						// Se crea un array de objetos
						Object[] fila = new Object[5]; // Hay SEIS columnas en
														// la tabla

						// Se rellena cada posición del array con una de las
						// columnas de la tabla en base de datos.
						for (int i = 0; i < 5; i++)
							fila[i] = rs.getObject(i + 1); // El primer indice
															// en rs es el 1, no
															// el cero, por eso
															// se suma 1.

						// Se añade al modelo la fila completa.
						modelo.addRow(fila);

					}
					tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					rs.close();

				} catch (java.sql.SQLException e) {
					System.out.println("Error SQL: " + e);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(20, 183, 1100, 504);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(12, 13, 998, 478);
		panel.add(scrollPane);
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		btnNewButton.setBounds(976, 124, 162, 46);
		contentPane.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 0, 1234, 92);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = JOptionPane.YES_NO_OPTION;
				int re = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?", "Salir", i);
				if (re == 0) {
					System.exit(0);
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 255)));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(155, 155, 155)));

			}
		});
		lblNewLabel.setBounds(1127, 31, 32, 32);
		lblNewLabel.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/icons8_Multiply_32px.png")));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("CONSULTAR DOCENTES");
		lblNewLabel_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 25));
		lblNewLabel_2.setBounds(126, 13, 412, 66);
		panel_1.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(377, 71, 0, -29);
		panel_1.add(separator);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Profesor.class.getResource("/imagenes/icons8-aula-64.png")));
		lblNewLabel_3.setBounds(34, 13, 96, 66);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(908, 124, 56, 46);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Alumno.class.getResource("/imagenes/icons8_Search_32px.png")));

		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			/***
			 * Cuando se presiona el boton llama a Ingresar maestro
			 */
			public void actionPerformed(ActionEvent e) {
				Ingresardocente i = new Ingresardocente();
				i.setVisible(true);

			}
		});
		btnIngresar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnIngresar.setBounds(62, 124, 162, 46);
		contentPane.add(btnIngresar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Profesor.class.getResource("/imagenes/icons8-m\u00E1s-32.png")));
		label.setBounds(22, 124, 56, 46);
		contentPane.add(label);
		setResizable(false);
		setUndecorated(true);
	}

}
