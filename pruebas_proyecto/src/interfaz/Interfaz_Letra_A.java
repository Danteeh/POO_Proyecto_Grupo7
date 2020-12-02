package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Rec_voz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_Letra_A extends JFrame {
	public static int cantidad_puntos;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Letra_A frame = new Interfaz_Letra_A();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz_Letra_A() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Letra_A = new JLabel("");
		Letra_A.setBounds(371, 11, 258, 273);
		Letra_A.setIcon(new ImageIcon(Interfaz_Letra_A.class.getResource("/letras/A-removebg-preview.png")));
		contentPane.add(Letra_A);

		JButton Microfono = new JButton("");
		Microfono.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				Rec_voz reconocimiento = new Rec_voz();
				String Entrada = "";

				System.out.println(reconocimiento.voz_reconocida(Entrada));

				if (reconocimiento.paso == true && reconocimiento.Entrada.equals("A")) {

					JOptionPane.showMessageDialog(null, "Excelente la letra es correcta ");
					Win ganador = new Win();
					ganador.setLocationRelativeTo(null);
					ganador.setVisible(true);
					cantidad_puntos = 1000;
					dispose();

				} else {

					JOptionPane.showMessageDialog(null, "Palabra incorrecta \n pista: Di una palabra A ");
				}

			}
		});
		Microfono.setContentAreaFilled(false);
		Microfono.setIcon(new ImageIcon(Interfaz_Letra_A.class.getResource("/imagenes/microphone@2x.png")));
		Microfono.setBounds(439, 318, 113, 131);
		contentPane.add(Microfono);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Interfaz_Letra_A.class.getResource("/imagenes/Diapositiva1.JPG")));
		Fondo.setBounds(0, 0, 999, 502);
		contentPane.add(Fondo);
	}
}
