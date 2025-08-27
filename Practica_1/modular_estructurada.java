package tarea1;
import java.util.Scanner;

public class modular_estructurada {
	public static double calcularPromedio(double[] numeros, int n) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma = suma + numeros[i];
        }
        return suma / n;
    }


    public static double calcularDesviacion(double[] numeros, int n, double promedio) {
        double sumaCuadrados = 0;
        for (int i = 0; i < n; i++) {
            sumaCuadrados =  sumaCuadrados +( Math.pow(numeros[i] - promedio, 2));
        }
        return Math.sqrt(sumaCuadrados / (n - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);
        
        double[] numeros = new double[10];
        int n = 10;
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextDouble();
        }


        double promedio = calcularPromedio(numeros, n);
        double desviacion = calcularDesviacion(numeros, n, promedio);
        System.out.println("El promedio es : "+ promedio);
        System.out.println("La desviacion estandar es " + desviacion);

    }

}