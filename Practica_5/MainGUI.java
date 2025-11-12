package p5;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame frame;
	private Biblioteca biblioteca;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI() {
		biblioteca = new Biblioteca("Biblioteca URSS");
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sistema de Biblioteca");
		frame.setBounds(100, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 484, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA BIBLIOTECA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 25, 232, 30);
		panel.add(lblNewLabel);
		
		JButton btnAgregarLibro = new JButton("Agregar Libro");
		btnAgregarLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarLibro.setBounds(150, 110, 180, 35);
		btnAgregarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgregarLibroGUI(biblioteca);
			}
		});
		frame.getContentPane().add(btnAgregarLibro);
		
		JButton btnAgregarAutor = new JButton("Agregar Autor");
		btnAgregarAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarAutor.setBounds(150, 160, 180, 35);
		btnAgregarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgregarAutorGUI(biblioteca);
			}
		});
		frame.getContentPane().add(btnAgregarAutor);
		
		JButton btnPrestamo = new JButton("Realizar Préstamo");
		btnPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrestamo.setBounds(150, 210, 180, 35);
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrestamoGUI(biblioteca);
			}
		});
		frame.getContentPane().add(btnPrestamo);
		
		JButton btnEstado = new JButton("Ver Estado");
		btnEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEstado.setBounds(150, 260, 180, 35);
		btnEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EstadoGUI(biblioteca);
			}
		});
		frame.getContentPane().add(btnEstado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(150, 310, 180, 35);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnSalir);
	}
}