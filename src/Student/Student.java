package Student;

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

	/**
	 * 
	 */
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
		setBounds(100, 100, 770, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final DefaultTableModel modelo = new DefaultTableModel();

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// Limpiamos el modelo cada que hagamos una consulta
				modelo.setRowCount(0);
				modelo.setColumnCount(0);
				// notifies the JTable that the model has changed
				// Creamos las columnas.

				modelo.addColumn("Nombre");
				modelo.addColumn("Direcciòn");
				modelo.addColumn("Còdigo Estudiante");

				ResultSet rs;

				try {

					Conexion conexion = new Conexion("root", "", "universidad");
					conexion.consulta("select Nombre, Dirección, cod_Estudiante from estudiante ");

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(20, 78, 438, 267);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 11, 399, 245);
		panel.add(scrollPane);
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		btnNewButton.setBounds(472, 11, 89, 23);
		contentPane.add(btnNewButton);
	}
}
