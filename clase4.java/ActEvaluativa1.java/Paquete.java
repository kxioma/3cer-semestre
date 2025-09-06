public class Paquete {
    // Atributos accesibles para la hija (protected)
    protected String destinatario;
    protected String fechaIngreso;

    // Constructor que inicializa los atributos del paquete
    public Paquete(String destinatario, String fechaIngreso) {
        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
    }

    // Método para mostrar la información básica del paquete
    public String mostrarInfo() {
        return "Destinatario: " + destinatario + " | Fecha: " + fechaIngreso;
    }
}

