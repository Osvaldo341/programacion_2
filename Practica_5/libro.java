package p5;
import java.util.*;
public class libro {
    private String titulo;
    private String isbn;
    private List<Pagina> paginas;  
    
    public libro(String titulo, String isbn, List<String> contenidosPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        for (int i = 0; i < contenidosPaginas.size(); i++) {
            this.paginas.add(new Pagina(i + 1, contenidosPaginas.get(i)));
        }
        }
    public void leer() {
    	System.out.println("Titulo : " + this.titulo);
    	System.out.println("ISBN : " + this.isbn);
    	for(Pagina pagina: paginas ) {
    		pagina.mostrarContenido();
    	} 
    }
	public String getTitulo() {
		return titulo;
	}
}
