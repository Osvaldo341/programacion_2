public class Cabina {
    private int nroCabina;
    private Persona[] personasAbordo;
    Cabina(int nroCabina){
        this.nroCabina=nroCabina;
        Persona[] personasAbordo = new Persona[50];
    }
    public void agregarPersona(Persona p){
        personasAbordo[obtenerNroPersonas()]=p;
    }
    public int obtenerNroPersonas(){
        return personasAbordo.length;
    }

    public int getNroCabina() {
        return nroCabina;
    }

    public Persona[] getPersonasAbordo() {
        return personasAbordo;
    }
    float ObtenerPeso(){
        float c=0;
        for (int i =1; i<personasAbordo.length;i++){
            c = c+ personasAbordo[i].getPesoPersona();
        }
        return c;
    }
}
