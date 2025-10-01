package allgo;

public class EmpleadoTiempoCompleto extends Empleado {
	public double salario_anual;
	public EmpleadoTiempoCompleto(String nom,double sa) {
		super(nom);
		this.salario_anual=sa;
	}
	public double CalcularSalarioMensual() {
		return salario_anual/12;
	}
	@Override
	public String toString() {
		return  super.toString()+" EmpleadoTiempoCompleto salario_anual : " + salario_anual + "";
	}
}
