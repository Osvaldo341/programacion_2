package allgo;

public abstract class Figura implements Coloreado{
	public String color;
	public Figura(String color) {
		super();
		this.color=color;
		}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public abstract double area();
	public abstract double Perimetro();
	@Override
	public String toString() {
		return " Color : " + color + "";
	}	
}
