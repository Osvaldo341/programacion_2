package allgo;

public class Circulo extends Figura implements Coloreado{
	public double radio;
	public Circulo(String color, double radio) {
		super(color);
		this.radio=radio;
	}
	public String comoColorear() {
		return "Colorear Todo el interior del circulo ";
	}
	public double area() {
		return Math.PI*this.radio*this.radio;
	}
	public double Perimetro() {
		return 2* Math.PI*this.radio;
	}
	@Override
	public String toString() {
		return  " Circulo Radio : " + radio + " " + super.toString();
	}
	
}
