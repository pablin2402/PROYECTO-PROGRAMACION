package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;

public class Student extends JFrame {

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
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final DefaultTableModel modelo = new DefaultTableModel();

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(20, 78, 1450, 750);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 11, 1428, 652);
		panel.add(scrollPane);
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);

		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Limpiamos el modelo cada que hagamos una consulta
				modelo.setRowCount(0);
				modelo.setColumnCount(0);
				// notifies the JTable that the model has changed
				// Creamos las columnas.

				modelo.addColumn("Código de Estudiante");
				modelo.addColumn("Nombre");
				modelo.addColumn("Dirección");
				modelo.addColumn("Correo Electrónico");
				ResultSet rs;

				try {

					Conexion conexion = new Conexion("root", "", "neptuno");
					conexion.consulta("select producto, cantidad_por_unidad, precio_unidad from productos ");

					rs = conexion.resultado();

					while (rs.next()) {

						// Se crea un array de objetos
						Object[] fila = new Object[3]; // Hay tres columnas en
														// la tabla

						// Se rellena cada posición del array con una de las
						// columnas de la tabla en base de datos.
						for (int i = 0; i < 3; i++)
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
		btnNewButton.setBounds(1225, 676, 196, 48);
		panel.add(btnNewButton);
	}
}
