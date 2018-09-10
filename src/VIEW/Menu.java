package VIEW;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		/***
		 * Para no cambiar el tamaño del panel y quitar el diseño por defecto de la
		 * parte superio por java
		 */
		setResizable(false);
		setUndecorated(true);
		/*
		 * Se importo un jar llamado rsutilities Con este se puede configurar la ventana
		 * 
		 */
		this.setLocationRelativeTo(this);

		rsutilities.RSUtilities.setCentrarVentana(this);
		rsutilities.RSUtilities.setMoverVentana(this);
		rsutilities.RSUtilities.setOpaqueVentana(this, false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 90, 1450, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1450, 28);
		panel.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			/**
			 * Cuando presione el mouse sobre el icono de x saldra de la app
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = JOptionPane.YES_NO_OPTION;
				int re = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?", "Salir", i);
				if (re == 0) {
					System.exit(0);
				}
			}

			/****
			 * Efecto de borde al mouse
			 * 
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 255)));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(
						javax.swing.BorderFactory.createLineBorder(new Color(SystemColor.ACTIVE_CAPTION_BORDER)));

			}
		});

		lblNewLabel.setBounds(1406, 0, 32, 28);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8_Multiply_32px.png")));
		panel.add(lblNewLabel);

		JPanel panelmenu = new JPanel();
		panelmenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelmenu.setBounds(0, 88, 275, 812);
		contentPane.add(panelmenu);
		panelmenu.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ALUMNOS");
		lblNewLabel_1.setBounds(0, 316, 275, 70);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		panelmenu.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(12, 329, 38, 47);
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-estudiante-masculino-30.png")));
		panelmenu.add(lblNewLabel_2);

		JLabel lblDocentes = new JLabel("DOCENTES");
		lblDocentes.setBounds(0, 387, 275, 70);
		lblDocentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocentes.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		panelmenu.add(lblDocentes);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(12, 409, 56, 37);
		lblNewLabel_3.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-aula-32.png")));
		panelmenu.add(lblNewLabel_3);

		JLabel lblInformacin = new JLabel("INFORMACI\u00D3N");
		lblInformacin.setBounds(0, 742, 275, 70);
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		panelmenu.add(lblInformacin);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(12, 752, 56, 47);
		lblNewLabel_4.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-informaci\u00F3n-32.png")));
		panelmenu.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("UNIVERSlDAD");
		lblNewLabel_5.setBounds(12, 99, 251, 37);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 25));
		panelmenu.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(24, 160, 251, 97);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-universidad-96.png")));
		panelmenu.add(lblNewLabel_6);

		JLabel lblNotas = new JLabel("NOTAS");
		lblNotas.setBounds(0, 459, 275, 70);
		lblNotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotas.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		panelmenu.add(lblNotas);

		JLabel lblClases = new JLabel("CLASES");
		lblClases.setBounds(0, 531, 275, 70);
		lblClases.setHorizontalAlignment(SwingConstants.CENTER);
		lblClases.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		panelmenu.add(lblClases);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(10, 470, 56, 48);
		lblNewLabel_7.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-examen-32.png")));
		panelmenu.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-cursos-32.png")));
		lblNewLabel_8.setBounds(12, 547, 56, 37);
		panelmenu.add(lblNewLabel_8);

		JLabel lblAula = new JLabel("AULA");
		lblAula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAula.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		lblAula.setBounds(0, 597, 275, 70);
		panelmenu.add(lblAula);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-formaci\u00F3n-32.png")));
		lblNewLabel_9.setBounds(12, 614, 56, 53);
		panelmenu.add(lblNewLabel_9);

		JLabel menuboton = new JLabel("");
		menuboton.setBounds(10, 38, 38, 37);
		contentPane.add(menuboton);
		menuboton.addMouseListener(new MouseAdapter() {
			/***
			 * Mouse click
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int pos = panelmenu.getX();
				if (pos > -1) {
					Animacion.Animacion.mover_izquierda(0, -275, 2, 2, panelmenu);
				} else {
					Animacion.Animacion.mover_derecha(-275, 0, 2, 2, panelmenu);
				}

			}
		});
		menuboton.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-men\u00FA-2-32 (1).png")));
	}
}
