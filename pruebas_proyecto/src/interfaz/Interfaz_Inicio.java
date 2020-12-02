package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import AppPackage.AnimationClass;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interfaz_Inicio extends JFrame {
	private static final long serialVersionUID = 1L;
	public static String nombre = "Ete setch";
	private JPanel contentPane;
	private JTextField textField;
	private JLabel Flecha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Inicio frame = new Interfaz_Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz_Inicio.class.getResource("/imagenes/owl.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Imagen_Nacho = new JLabel("");
		Imagen_Nacho.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/Logo_Universidad.png")));
		Imagen_Nacho.setBounds(0, 0, 967, 487);
		contentPane.add(Imagen_Nacho);
		
		Flecha = new JLabel("");
		Flecha.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/Flecha_inicio.gif")));
		Flecha.setBounds(1010, -100, 375, 361);
		contentPane.add(Flecha);

		JLabel Mensaje_Hola = new JLabel("Hola");
		Mensaje_Hola.setForeground(Color.WHITE);
		Mensaje_Hola.setFont(new Font("KG All of Me", Font.BOLD | Font.ITALIC, 40));
		Mensaje_Hola.setBounds(450, -400, 231, 200);
		contentPane.add(Mensaje_Hola);

		JLabel Mensaje_Como = new JLabel("\u00BFComo te llamas?");
		Mensaje_Como.setForeground(Color.WHITE);
		Mensaje_Como.setFont(new Font("KG All of Me", Font.BOLD | Font.ITALIC, 40));
		Mensaje_Como.setBounds(330, -300, 354, 117);
		contentPane.add(Mensaje_Como);

		JButton Enviar = new JButton("Seguir");
		Enviar.setBounds(620, -110, 89, 23);
		contentPane.add(Enviar);

		JLabel Pantalla = new JLabel("");
		Pantalla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				AnimationClass ac = new AnimationClass();
				ac.jLabelYDown(-425, 5, 10, 5, Pantalla);
				ac.jLabelYDown(-400, -30, 40, 5, Mensaje_Hola);
				ac.jLabelYDown(-300, 80, 30, 5, Mensaje_Como);
				ac.jTextFieldYDown(-100, 220, 20, 5, textField);
				ac.jButtonYDown(-110, 370, 10, 5, Enviar);
				ac.jLabelYDown(-100, 400, 10, 5, Flecha);

			}
		});
		Enviar.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				
				AnimationClass ac = new AnimationClass();
				ac.jLabelYUp(5, -425, 10, 5, Pantalla);
				ac.jLabelYUp(-30, -400, 10, 5, Mensaje_Hola);
				ac.jLabelYUp(80, -300, 10, 5, Mensaje_Como);
				ac.jTextFieldYUp(220, -100, 10, 5, textField);
				ac.jButtonYUp(370, -110, 10, 5, Enviar);

				nombre = textField.getText();	
				JOptionPane.showMessageDialog(null, "Bienvenido al tratamiento fonologido: "+nombre);
				
				System.out.println(nombre);
				Interfaz_EjercicioP Introduccion = new Interfaz_EjercicioP();
				Introduccion.setLocationRelativeTo(null);
				Introduccion.setVisible(true);
				dispose();

			}
		});

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				
				if(textField.getText().length()>=16) {
					e.consume();
				}
				
			}
		});
		textField.setBounds(306, -100, 400, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		Pantalla.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/desktop-computer.png")));
		Pantalla.setBounds(250, -425, 600, 450);
		contentPane.add(Pantalla);

		JLabel Fondo_de_pantalla = new JLabel("");
		Fondo_de_pantalla.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/Diapositiva1.JPG")));
		Fondo_de_pantalla.setBounds(0, 0, 1001, 500);
		contentPane.add(Fondo_de_pantalla);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				
				AnimationClass ac = new AnimationClass();
				ac.jLabelXLeft(0, -1000, 20, 5, Imagen_Nacho);
				ac.jLabelXLeft(1010, 320, 20, 5, Flecha);

			}

		});

	}
}
