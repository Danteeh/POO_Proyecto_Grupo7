package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppPackage.AnimationClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win extends JFrame {

	private static final long serialVersionUID = 23L;
	private JPanel contentPane;
	public Premios premio = new Premios();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win frame = new Win();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Win() {

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Premio_1 = new JLabel("");
		Premio_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				premio.setPrecio(200);
				premio.setTipo("Trofeo");
				if (Interfaz_Letra_A.cantidad_puntos >= premio.getPrecio()) {
					Impresion impresion = new Impresion();
					impresion.setLocationRelativeTo(null);
					impresion.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null,
							"No cuentas con suficientes puntos " + "\n Por favor elige otro premio o vuelve a jugar");
				}

			}
		});
		Premio_1.setIcon(new ImageIcon(Win.class.getResource("/imagenes/trophy-1674911_640 (1).png")));
		Premio_1.setBounds(69, -170, 166, 166);
		contentPane.add(Premio_1);

		JLabel Premio_2 = new JLabel("");
		Premio_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				premio.setPrecio(500);
				premio.setTipo("Corona");

				if (Interfaz_Letra_A.cantidad_puntos >= premio.getPrecio()) {
					Impresion impresion = new Impresion();
					impresion.setLocationRelativeTo(null);
					impresion.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null,
							"No cuentas con suficientes puntos " + "\n Por favor elige otro premio o vuelve a jugar");
				}
			}
		});
		Premio_2.setIcon(new ImageIcon(Win.class.getResource("/imagenes/image-3034792_640 (1).png")));
		Premio_2.setBounds(385, -170, 213, 166);
		contentPane.add(Premio_2);

		JLabel Premio_3 = new JLabel("");
		Premio_3.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				premio.setPrecio(1000);
				premio.setTipo("Diploma");

				if (Interfaz_Letra_A.cantidad_puntos >= premio.getPrecio()) {
					Impresion impresion = new Impresion();
					impresion.setLocationRelativeTo(null);
					impresion.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null,
							"No cuentas con suficientes puntos " + "\n Por favor elige otro premio o vuelve a jugar");
				}

			}
		});
		Premio_3.setIcon(new ImageIcon(Win.class.getResource("/imagenes/awards-2814023_1920 (1).jpg")));
		Premio_3.setBounds(755, -170, 213, 166);
		contentPane.add(Premio_3);

		JLabel Felicidades = new JLabel("Felicidades " + Interfaz_Inicio.nombre);
		Felicidades.setForeground(Color.WHITE);
		Felicidades.setFont(new Font("KG All of Me", Font.BOLD | Font.ITALIC, 40));
		Felicidades.setBounds(244, 500, 593, 146);
		contentPane.add(Felicidades);

		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(1);
			}
		});
		cerrar.setBounds(87, 500, 89, 23);
		contentPane.add(cerrar);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Win.class.getResource("/imagenes/Diapositiva1.JPG")));
		Fondo.setBounds(0, 0, 1000, 504);
		contentPane.add(Fondo);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				JOptionPane.showMessageDialog(null,
						"Felicidades " + Interfaz_Inicio.nombre + " por favor selecciona un premio");

				AnimationClass ac = new AnimationClass();
				ac.jLabelYDown(-170, 46, 25, 5, Premio_1);
				ac.jLabelYDown(-170, 46, 25, 5, Premio_2);
				ac.jLabelYDown(-170, 46, 25, 5, Premio_3);
				ac.jLabelYUp(500, 300, 25, 5, Felicidades);
				ac.jButtonYUp(500, 450, 25, 5, cerrar);

			}
		});

	}
}
