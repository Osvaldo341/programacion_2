package p5;

public class Prestamo {
	private String f_pres;
	private String f_dev;
	private Estudiante est;
	private libro lib;
	public Prestamo(Estudiante est , libro lib, String pres,String dev) {
		this.est=est;
		this.lib=lib;
		this.f_dev=dev;
		this.f_pres=pres;
	}
	public void mostrarInfo() {
		System.out.println("Libro : " + lib.getTitulo());
		System.out.println("Prestamo realizado a : " + est.getNombre());
		System.out.println("fecha prestamo : " + this.f_pres);
		System.out.println("fecha devolucion : " + this.f_dev);
		
		
	}

}
