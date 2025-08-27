package tarea1;
import java.util.Scanner;

public class EcuacionLineal {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	public EcuacionLineal(double a, double b, double c, double d, double e, double f ) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
	}
	public boolean  TieneSolucion() {
		double aux=this.a*this.d-this.b*this.c;
		if ( aux != 0) {
			return  true; 
		}
		return false;
	}
	public double getX() {
		return (this.e*this.d-this.b*this.f)/(this.a*this.d-this.b*this.c);
	}
	public double getY() {
		return (this.a*this.f-this.e*this.c)/(this.a*this.d-this.b*this.c);
	}
	public String toString() {
		return String.format("EcuacionLineal [%f],[%f],[%f],[%f],[%f],[%f]", a, b,c,d,e,f);
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
			 scanner.useLocale(java.util.Locale.US);
			System.out.print("ingrese a,b,c,d,e,f : ");
			 double a = scanner.nextDouble();
			 double b = scanner.nextDouble();
			 double c = scanner.nextDouble();
			 double d = scanner.nextDouble();
			 double e = scanner.nextDouble();
			 double f = scanner.nextDouble();
			 EcuacionLineal z=new EcuacionLineal(a,b,c,d,e,f);
			boolean aux = z.TieneSolucion();
			if(aux) {
			System.out.println("x = "+ z.getX()+ " , "+ "y = " +z.getY());
			}
			else {
				System.out.println("La ecuacion no tiene solucion ");
			}
		 }
	}

