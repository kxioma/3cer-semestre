public class Tarea {

 
    private String id;             // Identificador único de la tarea
    private String descripcion;    // Descripción de la tarea
    private int prioridad;         // 1 = Baja, 2 = Media, 3 = Alta
    private long tiempoLlegada;    // Marca de tiempo (timestamp) de llegada

    // ===== Constructor =====
    public Tarea(String id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = System.currentTimeMillis(); // Guarda el momento actual
    }

    // ===== Getters =====:)
    public String getId() { 
        return id; }


    public String getDescripcion() {
         return descripcion;
         }

    public int getPrioridad() { 
        return prioridad; 
    }
    public long getTiempoLlegada() { 
        return tiempoLlegada; 
    }

    // ===== Representación textual =====
    public String toString() {
        return "Tarea { " +
                "ID = '" + id + '\'' +
                ", Descripción = '" + descripcion + '\'' +
                ", Prioridad = " + prioridad +
                ", Llegó en = " + tiempoLlegada +
                " }";
    }
}