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

public class PrestamoGUI {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNombreEst;
	private JTextField txtLibro;
	private JTextField txtFechaDev;
	private Biblioteca biblioteca;

	public PrestamoGUI(Biblioteca bib) {
		this.biblioteca = bib;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Realizar Préstamo");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 434, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REALIZAR PRÉSTAMO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(120, 25, 200, 30);
		panel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Código Est:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(50, 100, 100, 20);
		frame.getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(160, 100, 220, 25);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombreEst = new JLabel("Nombre Est:");
		lblNombreEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreEst.setBounds(50, 140, 100, 20);
		frame.getContentPane().add(lblNombreEst);
		
		txtNombreEst = new JTextField();
		txtNombreEst.setColumns(10);
		txtNombreEst.setBounds(160, 140, 220, 25);
		frame.getContentPane().add(txtNombreEst);
		
		JLabel lblLibro = new JLabel("Libro:");
		lblLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLibro.setBounds(50, 180, 100, 20);
		frame.getContentPane().add(lblLibro);
		
		txtLibro = new JTextField();
		txtLibro.setColumns(10);
		txtLibro.setBounds(160, 180, 220, 25);
		frame.getContentPane().add(txtLibro);
		
		JLabel lblFechaDev = new JLabel("Fecha Dev:");
		lblFechaDev.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDev.setBounds(50, 220, 100, 20);
		frame.getContentPane().add(lblFechaDev);
		
		txtFechaDev = new JTextField();
		txtFechaDev.setColumns(10);
		txtFechaDev.setBounds(160, 220, 220, 25);
		frame.getContentPane().add(txtFechaDev);
		
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrestar.setBounds(120, 280, 100, 30);
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarPrestamo();
			}
		});
		frame.getContentPane().add(btnPrestar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(240, 280, 100, 30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
	}
	
	private void realizarPrestamo() {
		try {
			int codigo = Integer.parseInt(txtCodigo.getText());
			String nombreEst = txtNombreEst.getText();
			String libroTitulo = txtLibro.getText();
			String fechaDev = txtFechaDev.getText();
			
			if(nombreEst.isEmpty() || libroTitulo.isEmpty() || fechaDev.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(frame, "Por favor complete todos los campos");
				return;
			}
			
			Estudiante estudiante = new Estudiante(codigo, nombreEst);
			List<String> paginas = new ArrayList<>();
			paginas.add("Contenido del libro prestado");
			libro libroPrestamo = new libro(libroTitulo, "PRESTADO", paginas);
			
			biblioteca.prestarLibro(estudiante, libroPrestamo, "Hoy", fechaDev);
			
			javax.swing.JOptionPane.showMessageDialog(frame, "Préstamo realizado exitosamente");
			
			txtCodigo.setText("");
			txtNombreEst.setText("");
			txtLibro.setText("");
			txtFechaDev.setText("");
			
		} catch (NumberFormatException e) {
			javax.swing.JOptionPane.showMessageDialog(frame, "El código debe ser un número válido");
		}
	}
}