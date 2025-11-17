public class Linea {
    private String color;
    private Persona[] filaPersonas;
    private Cabina[] cabinas;
    private int cantidadCabinas;

    Linea(String color){
        this.color=color;
        this.cantidadCabinas=0;
        Cabina[] cabinas =new Cabina[50];
        Persona[] filaPersonas = new Persona[50];
    }
    void agregarCabinas(int nroCabina){
        Cabina c = new Cabina(nroCabina);
        cantidadCabinas++;
        cabinas[cabinas.length]=c;

    }
    void agregarPersona(Persona p){
        filaPersonas[filaPersonas.length]=p;
    }

    public String getColor() {
        return color;
    }

    public int getCantidadCabinas() {
        return cantidadCabinas;
    }
    void agregarPersonaCabX(Persona p, int nroCab){
        for (int i = 1; i<=cantidadCabinas;i++){
            if(i==nroCab){
                if (cabinas[i].getPersonasAbordo().length<=10 && cabinas[i].ObtenerPeso()<=850){
                    cabinas[i].agregarPersona(p);
                }
            }
        }
    }
    void verificar(){
        for (int i =1; i<=cantidadCabinas;i++){
            if (!(cabinas[i].getPersonasAbordo().length<=10 && cabinas[i].ObtenerPeso()<=850)){
                System.out.println("No cumple con las reglas");
            }
            else {
                System.out.println("Cumple con las reglas");
            }
        }
    }

    public Cabina[] getCabinas() {
        return cabinas;
    }

    public Persona[] getFilaPersonas() {
        return filaPersonas;
    }
}
