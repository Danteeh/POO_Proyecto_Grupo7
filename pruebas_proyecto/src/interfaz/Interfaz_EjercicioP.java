package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;
import main.Rec_voz;
import sonidos.Reproducir_mp3;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



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
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {		
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Rec_voz reconocimiento = new Rec_voz();
				String Entrada = "";
				System.out.println(reconocimiento.voz_reconocida(Entrada));

				if (reconocimiento.paso == true && reconocimiento.Entrada.charAt(0) == 65) {

					Interfaz_Letra_A Ejercicio_A = new Interfaz_Letra_A();
					Ejercicio_A.setVisible(true);
					dispose();

				}

			}

		});
		btnNewButton.setBounds(433, 383, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Interfaz_EjercicioP.class.getResource("/imagenes/Diapositiva1.JPG")));
		lblNewLabel.setBounds(0, 0, 989, 488);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
