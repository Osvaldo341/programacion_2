package allgo;

public abstract class Empleado {
	public String nombre;
	public Empleado(String nom) {
		super();
		this.nombre=nom;
	}
	public abstract double CalcularSalarioMensual();
	@Override
	public String toString() {
		return "Empleado nombre :" + nombre + "";
	}	
}
	

