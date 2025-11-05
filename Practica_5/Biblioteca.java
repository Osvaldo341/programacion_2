package p5;
import java.util.*;
public class Biblioteca {
	private String nombre;
	private ArrayList<libro> libros;
	private ArrayList<Autor> autores;
	private ArrayList<Prestamo> prestamos;
	private Horario horario;
	public Biblioteca(String nom ) {
		this.nombre=nom;
		this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario= new Horario("Lunes a Viernes ", "08:00","21:00");
	}
	public void agregarLibro(libro libro) {
	    if (libro == null) {
	        System.out.println("Error: El libro no existe xd");
	    }
	    if (libros.contains(libro)) {
	        System.out.println("Error: El libro ya existe en la biblioteca");
	    }
	    libros.add(libro);
	    System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
	}
	public void agregarAutor(Autor aut) {
	    if (aut == null) {
	        System.out.println("Error: El autor no existe xd");
	    }
	    if (autores.contains(aut)) {
	        System.out.println("Error: El Autor ya esta en la biblioteca");
	    }
	    autores.add(aut);
	    System.out.println("Autor agregado exitosamente: " + aut.getNombre());
	}
	public void  prestarLibro(Estudiante est , libro lib, String p,String v) {
		if (est != null && lib != null && libros.contains(lib)) {
			Prestamo pres = new Prestamo(est, lib,p, v );
			prestamos.add(pres);
			libros.remove(lib);
			System.out.println("Prestamo realizado ");
		}
	}
	public void mostrarEstado() {
		System.out.println("=== ESTADO DE LA BIBLIOTECA: " + nombre + " ===");
        System.out.println("Libros disponibles: " + libros.size());
        System.out.println("Autores registrados: " + autores.size());
        System.out.println("Préstamos activos: " + prestamos.size());
        horario.mostrarHorario();	
	}
	public void cerrarBiblioteca() {
        System.out.println("La biblioteca " + this.nombre + " ha cerrado.");
        prestamos.clear(); 
    }
}
