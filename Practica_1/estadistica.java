package tarea1;
import java.util.Scanner;
import java.text.DecimalFormat;
public class estadistica {
	private double [] n1;
	public estadistica() {
	n1 = new double[10];
	}
	public void setNumeros(double[] numeros) {
        this.n1 = numeros;
    }
	public double  Promedio() {
        double suma = 0;
        for (int i = 0; i < n1.length; i++) {
            suma=suma + n1[i];
            
        }
        return suma / n1.length;
    }
	public double Desviacion() {
        double promedio = Promedio();
        double sumaCuadrados = 0;
        
        for (int i = 0; i < n1.length; i++) {
            sumaCuadrados += Math.pow(n1[i] - promedio, 2);
        }
        
        return Math.sqrt(sumaCuadrados / (n1.length - 1));
    }
	public String toString() {
        return String.format("Estadistica [%f],[%f]", Promedio(), Desviacion());
    }
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			scanner.useLocale(java.util.Locale.US);
			    double[] datos = new double[10] ;
			   for(int i = 0;i < datos.length; i++) {
				   datos[i]=scanner.nextDouble();
			   }
			   estadistica datos1= new estadistica();
			   datos1.setNumeros(datos);
			   DecimalFormat df1 = new DecimalFormat("#.#####");
			   System.out.println("El promedio es "+ df1.format(datos1.Promedio()));
			   System.out.println("Ladesviacion estandar es "+ df1.format(datos1.Desviacion()));
		 
	    }
	
	
}
