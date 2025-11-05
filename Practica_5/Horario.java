package p5;

public class Horario {
	private String dias_apertura;
	private String hora_apertura;
	private String hora_cierre;
	public Horario(String dias, String ha,String hc) {
		this.dias_apertura= dias;
		this.hora_apertura=ha;
		this.hora_cierre=hc;
	}
	public void mostrarHorario() {
		System.out.println("Dias que estar abierto : " + this.dias_apertura);
		System.out.println("Se atiende desde las "+ this.hora_apertura);
		System.out.println("Hasta las "+ this.hora_cierre);
	}

}
