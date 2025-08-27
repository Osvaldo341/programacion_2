package tarea1;
import java.text.DecimalFormat;
import java.util.Scanner;
public class EcuacionCuadratica {
	private double a;
	private double b;
	private double c;
	public EcuacionCuadratica(double a, double b, double c){
		this.a=a;
		this.b=b;
		this.c=c;
	
	}
	public double getDistrimidante() {
		double aux= this.b*this.b - 4*this.a*this.c;
		return aux;
		
	}
	public double getRaiz1() {
		return (-1*this.b + Math.sqrt((this.b*this.b)- 4 * this.a *this.c))/(2*this.a);
	}
	public double getRaiz2() {
		return (-1*this.b - Math.sqrt((this.b*this.b)- 4 * this.a *this.c))/(2*this.a);
	}
	public String toString() {
		return String.format("EcuacionCuadratica [%f],[%f],[%f]", a, b,c);
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		 scanner.useLocale(java.util.Locale.US);
			System.out.print("ingrese a,b,c : ");
			 double a = scanner.nextDouble();
			 double b = scanner.nextDouble();
			 double c = scanner.nextDouble();
			 EcuacionCuadratica x= new EcuacionCuadratica(a,b,c);
			 double aux2=x.getDistrimidante();
			 DecimalFormat df1 = new DecimalFormat("#.######");
		if(aux2>0) {
			System.out.print("La ecuacion tiene dos raices " + df1.format(x.getRaiz1())+ " y " + df1.format(x.getRaiz2()));			
		}
		else if(aux2==0){
			System.out.print("La ecuacion tiene una raız " + df1.format(x.getRaiz1()));
			
		}
		else if (0>aux2) {
			System.out.print("La ecuacicon no tiene raıces reales");
		}
			
		
	}
	
	
}

