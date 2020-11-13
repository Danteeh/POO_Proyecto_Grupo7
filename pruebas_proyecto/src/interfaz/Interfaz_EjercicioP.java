package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Rec_voz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_EjercicioP extends JFrame {

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

	public Interfaz_EjercicioP() {
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
				String Entrada=""; 
	           	System.out.println(reconocimiento.voz_reconocida(Entrada));
                   
                 if(reconocimiento.paso== true) {
                	 
                	 Interfaz_Letra_A Ejercicio_A = new Interfaz_Letra_A();
                	 Ejercicio_A.setVisible(true);
                	 dispose();
                	 
                	 
                 }	          
    
				}
				
				
				
			
		});
		btnNewButton.setBounds(421, 384, 89, 23);
		contentPane.add(btnNewButton);
	}
}
