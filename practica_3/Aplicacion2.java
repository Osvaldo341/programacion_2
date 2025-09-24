package practica_3;

public class Aplicacion2 {

	public static void main(String[] args) {
		JuegoAdivinaNumero a = new JuegoAdivinaNumero(3);
		JuegoAdivinaPar b = new JuegoAdivinaPar(3);
		JuegoAdivinaImpar c = new JuegoAdivinaImpar(3);
		System.out.println("Juego adivina numero (Normal)");
		a.juega();
		System.out.println("Juego adivina numero (Par)");
		b.juega();
		System.out.println("Juego adivina numero (Impar)");
		c.juega();
		
	}

}
