package allgo;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("introduzca los datos de 3 empleados de tiempo completo");
		Scanner sw=new Scanner(System.in);
		Empleado [] emple= new Empleado[5]  ;
		for(int i=0;i<3;i++) {
			System.out.println("Nombre : ");
			String aux1=sw.next();
			System.out.println("Salario Anual : ");
			double aux2=sw.nextDouble();
			emple[i]= new EmpleadoTiempoCompleto(aux1,aux2);
		}
		System.out.println("introduzca los datos de 2 empleados de tiempo horario");
		for(int i=3;i<5;i++) {
			System.out.println("Nombre : ");
			String aux1=sw.next();
			System.out.println("Horas trabajadas : ");
			double aux2=sw.nextDouble();
			System.out.println("Tarifa por hora  : ");
			double aux3=sw.nextDouble();
			emple[i]= new EmpleadoTiempoHorario(aux1,aux2,aux3);
		}
		for(int h=0;h<5;h++) {
			System.out.println(emple[h]);
			System.out.println("Salario Mensual : "+emple[h].CalcularSalarioMensual());
		}
		
		

	}

}
