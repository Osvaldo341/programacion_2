package hola;

import java.util.ArrayList;

public class Linea {
	public String color;
	ArrayList<Persona> FilaPersonas= new ArrayList<Persona>();
	ArrayList<Cabina> Cabinas= new ArrayList<Cabina>();
	public int cantidadCabinas;
	public Linea(String color) {
		this.color = color;
	}
	public void agregarPersona(Persona p){
		FilaPersonas.add(p);
		
	}
	public void  agregarCabina(int cantidadCabinas) {
		
		
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
