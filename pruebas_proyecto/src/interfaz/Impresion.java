package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Impresion extends JFrame implements Printable {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Impresion frame = new Impresion();
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
	public Impresion() {
		setResizable(false);
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 520, 638);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Impresion.class.getResource("/imagenes/m_certificate-31872_1280 (2).png")));
		lblNewLabel.setBounds(0, 0, 603, 627);
		panel.add(lblNewLabel);

		JLabel Frase = new JLabel("Se le concede a:");
		Frase.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 31));
		Frase.setBounds(148, 191, 455, 52);
		panel.add(Frase);

		JLabel Nombre = new JLabel("" + Interfaz_Inicio.nombre);
		Nombre.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		Nombre.setBounds(51, 241, 420, 115);
		panel.add(Nombre);

		JLabel lblNewLabel_1 = new JLabel("Se  otorga por haber cumplido con las activdades de rezago escolar");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 442, 446, 77);
		panel.add(lblNewLabel_1);

		JButton Imprimir = new JButton("Imprimir");

		PrinterJob gap = PrinterJob.getPrinterJob();
		gap.setPrintable(this);

		Imprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Imprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (gap.printDialog()) {

							try {
								gap.print();
							} catch (PrinterException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else {

							JOptionPane.showMessageDialog(null, "Se cancelo la impresion");
						}

					}
				});

			}
		});
		Imprimir.setBounds(441, 679, 89, 23);
		contentPane.add(Imprimir);

		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cerrar.setBounds(28, 679, 89, 23);
		contentPane.add(cerrar);
	}

	@Override
	public int print(Graphics gra, PageFormat Page, int Index) throws PrinterException {

		if (Index == 0) {

			Graphics2D graphics2d = (Graphics2D) gra;
			graphics2d.translate(Page.getImageableX(), Page.getImageableY());
			this.printAll(gra);
			return PAGE_EXISTS;
		} else {

			return NO_SUCH_PAGE;

		}

	}
}
