public class PaqueteCasillero  extends Paquete{

    //Atributos adicionales 
    private int fila;
    private int columna;


    public PaqueteCasillero(String destinatario, String fechaIngreso, int fila, int col){
        super(destinatario, fechaIngreso);//Llamamos al constructor de paquete

        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
    }

    //Método que sobrescribe  mostrarInfo() 
public String mostarInfo(){
    return "Casillero [" + fila + "][" + columna  + "] -->"   + " Destinatario: "  + destinatario  + "| Fecha:  "  + fechaIngreso;

}

    
}
