package hola;
import com.google.gson.Gson;
import java.io.*; 
public class Consulta {
	private int ci;
	private String NombrePaciente;
	private String apellidoPaciente;
	private int idmed;
	private int dia;
	private String mes;
	private int anio;
	public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idmed, int dia, String mes,
			int anio) {
		super();
		this.ci = ci;
		NombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.idmed = idmed;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	public Consulta() {
		super();
		this.ci = -1;
		NombrePaciente = "";
		this.apellidoPaciente ="";
		this.idmed = -1;
		this.dia = -1;
		this.mes ="";
		this.anio = -1;
	}
	public void alta() {
		String ruta="Consultas/"+ci+".json";
		Gson gson=new Gson();
		try{
			FileWriter w= new FileWriter(ruta);
			gson.toJson(this,w);
			w.close();
			System.out.println("Subido correctamente");
			
		}catch(Exception e) {
			System.out.println("Hubo un error "+ e);
			
		}
	}
	@Override
	public String toString() {
		return "Consulta [ci=" + ci + ", NombrePaciente=" + NombrePaciente + ", apellidoPaciente=" + apellidoPaciente
				+ ", idmed=" + idmed + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public String getNombrePaciente() {
		return NombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		NombrePaciente = nombrePaciente;
	}
	public String getApellidoPaciente() {
		return apellidoPaciente;
	}
	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}
	public int getIdmed() {
		return idmed;
	}
	public void setIdmed(int idmed) {
		this.idmed = idmed;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
