package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppPackage.AnimationClass;
import main.Rec_voz;







public class Interfaz_EjercicioP extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Interfaz_EjercicioP frame = new Interfaz_EjercicioP();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_EjercicioP()  {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz_EjercicioP.class.getResource("/imagenes/owl.png")));
		
		setUndecorated(true);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton Microfono = new JButton("");
		Microfono.setBackground(Color.WHITE);
		Microfono.setContentAreaFilled(false);
		Microfono.setIcon(new ImageIcon(Interfaz_EjercicioP.class.getResource("/imagenes/microphone@2x.png")));
		Microfono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Rec_voz reconocimiento = new Rec_voz();
				String Entrada = "";
				System.out.println(reconocimiento.voz_reconocida(Entrada));

				if ( reconocimiento.paso==true && reconocimiento.Entrada.equals("M")) {
                     
					
					JOptionPane.showMessageDialog(null, "Excelente la letra es correcta ");
					Interfaz_Letra_A Ejercicio_A = new Interfaz_Letra_A();
					Ejercicio_A.setVisible(true);
					Ejercicio_A.setLocationRelativeTo(null);
					dispose();

				}else {
					
					JOptionPane.showMessageDialog(null, "Palabra incorrecta \n pista: Di una palabra que contenga la letra M ");
				}

			}

		});
		
		
		
		JLabel Mensaje = new JLabel("Hola "+Interfaz_Inicio.nombre);
		Mensaje.setForeground(Color.WHITE);
		Mensaje.setFont(new Font("KG All of Me", Font.PLAIN, 70));
		Mensaje.setBounds(-480, 140, 909, 196);
		contentPane.add(Mensaje);
		Microfono.setBounds(419, 600, 119, 124);
		contentPane.add(Microfono);
		
		JLabel Indicador = new JLabel("");
		Indicador.setIcon(new ImageIcon(Interfaz_EjercicioP.class.getResource("/imagenes/Flecha microfono.gif")));
		Indicador.setBounds(390, 650, 227, 216);
		contentPane.add(Indicador);
		
		JButton Empezar = new JButton("Empezar");
	
		Empezar.setBounds(1010, 320, 89, 23);
		contentPane.add(Empezar);
		
		JLabel Letra_Ejemplo = new JLabel("");
		Letra_Ejemplo.setIcon(new ImageIcon(Interfaz_EjercicioP.class.getResource("/letras/M-removebg-preview.png")));
		Letra_Ejemplo.setBounds(301, 550, 369, 341);
		contentPane.add(Letra_Ejemplo);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Interfaz_EjercicioP.class.getResource("/imagenes/Diapositiva1.JPG")));
		Fondo.setBounds(0, 0, 1005, 506);
		contentPane.add(Fondo);
		
		
		Empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnimationClass ac = new AnimationClass();
				ac.jButtonYUp(320, -500, 5, 5, Empezar);
				ac.jLabelYUp(140, -130, 5, 5, Mensaje);
				ac.jLabelYUp(550, 10,  5, 5, Letra_Ejemplo);
				ac.jButtonYUp(600, 330, 15, 5, Microfono);
				ac.jLabelYUp(650, 290, 15, 5,Indicador);
				
			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				
				AnimationClass ac = new AnimationClass();
				ac.jLabelXRight(-480, 220, 15, 5, Mensaje);
				ac.jButtonXLeft(1010, 450, 15, 5, Empezar);
				
				
			}
		});
		
	}
}
