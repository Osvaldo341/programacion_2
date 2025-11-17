public class MiTeleferico {
    private Linea[] lineas;
    private float cantidadIngresos[];

    MiTeleferico(){
        Linea[] lineas = new Linea[50];
        lineas[1]=new Linea("Rojo");
        lineas[2]=new Linea("Amarillo");
        lineas[3]=new Linea("Verde");
    }
    void agregarPersonaFila(Persona p, String linea){
        for (int i=1; i<=3; i++){
        if (lineas[i].getColor()==linea){
            lineas[i].agregarPersona(p);}
        }
    }
    void agregarCabina(String linea){
        for (int i =1;i<=3;i++){
            if (lineas[i].getColor()==linea){
                lineas[i].agregarCabinas(lineas[i].getCantidadCabinas()+1);
            }
        }
    }
}
