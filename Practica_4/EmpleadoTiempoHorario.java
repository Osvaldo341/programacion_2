package allgo;

public class EmpleadoTiempoHorario extends Empleado {
	public double horas_trabajadas;
	public double tarifa_por_hora;
	public EmpleadoTiempoHorario(String nom, double ht, double tph){
		super(nom);
		this.horas_trabajadas=ht;
		this.tarifa_por_hora=tph;
	}
	public double CalcularSalarioMensual() {
		return this.horas_trabajadas*this.tarifa_por_hora;
	}
	@Override
	public String toString() {
		return super.toString()+" EmpleadoTiempoHorario horas_trabajadas : " + horas_trabajadas + ", tarifa_por_hora=" + tarifa_por_hora
				+ "";
	}
	

}
