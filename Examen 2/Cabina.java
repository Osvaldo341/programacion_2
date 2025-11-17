package hola;
import java.util.*;
public class Cabina {
	private int nroCabina;
	ArrayList<Persona> Personaabordo= new ArrayList<Persona>();
	public Cabina(int nroCabina) {
		this.nroCabina = nroCabina;
	}
	public void AgregarPersona(Persona p) {
		Personaabordo.add(p);
	}
}
