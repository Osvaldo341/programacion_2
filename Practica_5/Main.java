package p5;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Biblioteca biblio= new Biblioteca("Biblioteca URSS");
		Autor au1= new Autor("Jorge Santos ", " Mexicano");
		Autor au2= new Autor("Lionel Messi ", " Argentino");
        List<String> paginasCienAnios = new ArrayList<>();
        paginasCienAnios.add("Muchos años después, frente al pelotón de fusilamiento...");
        paginasCienAnios.add("El mundo era tan reciente que muchas cosas carecían de nombre...");
        
        List<String> paginasFicciones = new ArrayList<>();
        paginasFicciones.add("La Biblioteca de Babel es una biblioteca tal que...");
        paginasFicciones.add("El jardín de senderos que se bifurcan es una imagen del tiempo...");
        libro libro1 = new libro("Cien Años de Soledad", "978-8437604947", paginasCienAnios);
        libro libro2 = new libro("Ficciones", "978-8420674623", paginasFicciones);  
        Estudiante estudiante1 = new Estudiante(2023001, "Juan Pérez");
        Estudiante estudiante2 = new Estudiante(2023002, "María García");
        biblio.agregarAutor(au1);
        biblio.agregarAutor(au2);
        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);
        biblio.mostrarEstado();
        biblio.prestarLibro(estudiante1, libro1, "09:00", "15:00S");
        biblio.mostrarEstado();
        System.out.println("\n=== INFORMACIÓN DE AUTORES ===");
        au1.mostrarInfo();
        au2.mostrarInfo();
        System.out.println("\n=== INFORMACIÓN DE ESTUDIANTES ===");
        estudiante1.mostrarInfo();
        estudiante2.mostrarInfo();
        System.out.println("\n=== LEYENDO LIBRO ===");
        libro2.leer();
        biblio.cerrarBiblioteca();
	}
}
