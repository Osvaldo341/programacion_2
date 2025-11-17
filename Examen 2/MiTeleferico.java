package hola;
import java.util.*;
public class MiTeleferico {
	ArrayList<Linea> lineas= new ArrayList<Linea>();
	private float cantidadingresos;
	public MiTeleferico(){
		Linea Roja= new Linea("rojo");
		Linea Amarrilla= new Linea("Amarrillo");
		Linea Verde= new Linea("Verde");
		lineas.add(Verde);
		lineas.add(Roja);
		lineas.add(Amarrilla);
		
	}
	
	public void agregarPersonaFila(Persona p , String linea) {
		for ( int i = 0 ; i < 3; i++) {
			if(linea.equals(Roja.getColor();)) {
				
			}
			
		}
	}
	public void agregarCabina(String linea) {
		
	}
}
