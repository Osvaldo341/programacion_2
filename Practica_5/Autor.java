package p5;

public class Autor {
	private String nombre;
	private String nacionalidad;
	public Autor(String nom, String nac) {
		this.nombre=nom;
		this.nacionalidad=nac;
		
	}
	public void mostrarInfo() {
		System.out.println("Nombre : " + this.nombre );
		System.out.println("Nacionalidad : " + this.nacionalidad );
	}
	public String getNombre() {
		return nombre;
	}
}
