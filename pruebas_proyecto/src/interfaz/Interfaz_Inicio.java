package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import AppPackage.AnimationClass;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Interfaz_Inicio extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

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

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Imagen_Nacho = new JLabel("");
		Imagen_Nacho.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/Logo_Universidad.png")));
		Imagen_Nacho.setBounds(0, 13, 967, 487);
		contentPane.add(Imagen_Nacho);

		
		JLabel Pantalla = new JLabel("");
		Pantalla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				AnimationClass ac = new AnimationClass();
				ac.jLabelYDown(-425, 5, 15, 5,Pantalla);
				
			}
		});
		Pantalla.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/desktop-computer.png")));
		Pantalla.setBounds(250, -425, 600, 450);
		contentPane.add(Pantalla);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Interfaz_Inicio.class.getResource("/imagenes/Diapositiva1.JPG")));
		lblNewLabel.setBounds(0, 0, 1027, 500);
		contentPane.add(lblNewLabel);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				AnimationClass ac = new AnimationClass();
				ac.jLabelXLeft(0, -1000, 35, 5, Imagen_Nacho);

			}
             
			
			
		});

	}
}
