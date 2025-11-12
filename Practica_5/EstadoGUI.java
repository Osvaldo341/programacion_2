package p5;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstadoGUI {

	private JFrame frame;
	private JTextArea textArea;
	private Biblioteca biblioteca;

	public EstadoGUI(Biblioteca bib) {
		this.biblioteca = bib;
		initialize();
		mostrarEstado();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Estado de la Biblioteca");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 484, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADO DE LA BIBLIOTECA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(120, 25, 250, 30);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 424, 220);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(200, 330, 80, 30);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCerrar);
	}
	
	private void mostrarEstado() {
		StringBuilder estado = new StringBuilder();
		
		// Obtener información de la biblioteca
		estado.append("=== ESTADO DE LA BIBLIOTECA ===\n\n");
		estado.append("Nombre: ").append("Biblioteca URSS").append("\n");
		estado.append("Libros disponibles: ").append(biblioteca.getLibros().size()).append("\n");
		estado.append("Autores registrados: ").append(biblioteca.getAutores().size()).append("\n");
		estado.append("Préstamos activos: ").append(biblioteca.getPrestamos().size()).append("\n\n");
		estado.append("--- Horario ---\n");
		estado.append("Lunes a Viernes: 08:00 - 21:00\n");
		
		textArea.setText(estado.toString());
	}
}