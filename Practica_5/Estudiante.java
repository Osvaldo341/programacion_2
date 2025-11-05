package p5;

public class Estudiante {
	private int Cod_Estudiante;
	private String Nombre;
	public Estudiante(int cod , String nom) {
		this.Cod_Estudiante=cod;
		this.Nombre=nom;
		
	}
	public void mostrarInfo() {
		System.out.println("Codigo de Estudiante : "+ this.Cod_Estudiante);
		System.out.println("Estudiante : "+ this.Nombre);
	}
	public String getNombre() {
		return Nombre;
	}
}
