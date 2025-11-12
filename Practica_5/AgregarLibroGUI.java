package p5;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AgregarLibroGUI {

	private JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtISBN;
	private JTextField txtContenido;
	private Biblioteca biblioteca;

	public AgregarLibroGUI(Biblioteca bib) {
		this.biblioteca = bib;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Agregar Libro");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 434, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGREGAR LIBRO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 25, 150, 30);
		panel.add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(50, 100, 80, 20);
		frame.getContentPane().add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(140, 100, 240, 25);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(50, 140, 80, 20);
		frame.getContentPane().add(lblIsbn);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(140, 140, 240, 25);
		frame.getContentPane().add(txtISBN);
		
		JLabel lblContenido = new JLabel("Contenido:");
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContenido.setBounds(50, 180, 80, 20);
		frame.getContentPane().add(lblContenido);
		
		txtContenido = new JTextField();
		txtContenido.setColumns(10);
		txtContenido.setBounds(140, 180, 240, 60);
		frame.getContentPane().add(txtContenido);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setBounds(120, 270, 100, 30);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarLibro();
			}
		});
		frame.getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(240, 270, 100, 30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
	}
	
	private void agregarLibro() {
		String titulo = txtTitulo.getText();
		String isbn = txtISBN.getText();
		String contenido = txtContenido.getText();
		
		if(titulo.isEmpty() || isbn.isEmpty() || contenido.isEmpty()) {
			javax.swing.JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos");
			return;
		}
		
		List<String> paginas = new ArrayList<>();
		paginas.add(contenido);
		
		libro nuevoLibro = new libro(titulo, isbn, paginas);
		biblioteca.agregarLibro(nuevoLibro);
		
		javax.swing.JOptionPane.showMessageDialog(frame, "Libro agregado exitosamente");
		txtTitulo.setText("");
		txtISBN.setText("");
		txtContenido.setText("");
	}
}
