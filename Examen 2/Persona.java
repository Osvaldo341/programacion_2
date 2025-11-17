public class Persona {
    private String nombre;
    private int edad;
    private float pesoPersona;
    Persona(String nombre, int edad, float peso){
        this.edad=edad;
        this.nombre=nombre;
        this.pesoPersona=peso;
    }

    public float getPesoPersona() {
        return pesoPersona;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPesoPersona(float pesoPersona) {
        this.pesoPersona = pesoPersona;
    }
}
