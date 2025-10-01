package allgo;

public class Cuadrado extends Figura implements Coloreado {
	public double lado;
	public Cuadrado(String color, double lado) {
		super(color);
		this.lado=lado;
	}
	public String comoColorear() {
		return "Colorear los cuatro lados ";
	}
	public double area() {
		return this.lado*this.lado;
	}
	public double Perimetro() {
		return 4*this.lado;
	}
	@Override
	public String toString() {
		return  " Cuadrado lado : " + lado + " " + super.toString();
	}
	
}
