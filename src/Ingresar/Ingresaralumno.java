package Ingresar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Ingresaralumno extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 650, 800);
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
		lblNewLabel.setBounds(587, 13, 51, 56);
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

		JLabel lblNewLabel_1 = new JLabel("INGRESAR");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 25));
		lblNewLabel_1.setBounds(94, 13, 235, 56);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ingresaralumno.class.getResource("/imagenes/icons8-insertar-64.png")));
		lblNewLabel_2.setBounds(14, 13, 56, 56);
		panel.add(lblNewLabel_2);
		setResizable(false);
		setUndecorated(true);
	}
}