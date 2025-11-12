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
import java.awt.event.ActionEvent;

public class AgregarAutorGUI {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtNacionalidad;
	private Biblioteca biblioteca;

	public AgregarAutorGUI(Biblioteca bib) {
		this.biblioteca = bib;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Agregar Autor");
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 434, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGREGAR AUTOR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(140, 25, 150, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(50, 100, 80, 20);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 100, 240, 25);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidad.setBounds(50, 140, 80, 20);
		frame.getContentPane().add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(140, 140, 240, 25);
		frame.getContentPane().add(txtNacionalidad);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setBounds(120, 200, 100, 30);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarAutor();
			}
		});
		frame.getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(240, 200, 100, 30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
	}
	
	private void agregarAutor() {
		String nombre = txtNombre.getText();
		String nacionalidad = txtNacionalidad.getText();
		
		if(nombre.isEmpty() || nacionalidad.isEmpty()) {
			javax.swing.JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos");
			return;
		}
		
		Autor nuevoAutor = new Autor(nombre, nacionalidad);
		biblioteca.agregarAutor(nuevoAutor);
		
		javax.swing.JOptionPane.showMessageDialog(frame, "Autor agregado exitosamente");
		txtNombre.setText("");
		txtNacionalidad.setText("");
	}
}