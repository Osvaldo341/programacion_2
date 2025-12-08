package hola;
import com.google.gson.Gson;
import java.io.*; 
public class Medico {
	private int idMed,aniosExp;
	private String nombreMed,apellidoMed;
	public Medico(int idMed, int aniosExp, String nombreMed, String apellidoMed) {
		this.idMed = idMed;
		this.aniosExp = aniosExp;
		this.nombreMed = nombreMed;
		this.apellidoMed = apellidoMed;
	}
	public Medico() {
		this.idMed = -1;
		this.aniosExp = -1;
		this.nombreMed = "";
		this.apellidoMed = "";
	}
	public void alta() {
		String ruta="Medicos/"+idMed+" "+nombreMed+".json";
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
	public int getIdMed() {
		return idMed;
	}
	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}
	public int getAniosExp() {
		return aniosExp;
	}
	public void setAniosExp(int aniosExp) {
		this.aniosExp = aniosExp;
	}
	public String getNombreMed() {
		return nombreMed;
	}
	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}
	public String getApellidoMed() {
		return apellidoMed;
	}
	public void setApellidoMed(String apellidoMed) {
		this.apellidoMed = apellidoMed;
	}
	
}
