public class Main {
    public static void main(String[] args) {

        // Crear el gestor
        GestorTareas gestor = new GestorTareas();

        // Crear tareas con diferentes prioridades
        Tarea t1 = new Tarea("T001", "Revisar correos", 1);
        Tarea t2 = new Tarea("T002", "Actualizar servidor", 3);
        Tarea t3 = new Tarea("T003", "Enviar informe mensual", 2);
        Tarea t4 = new Tarea("T004", "Atender incidente crítico", 3);

        // Agregar las tareas
        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t4);

        System.out.println("\n===== PROCESAMIENTO DE TAREAS =====\n");

        // Procesar tres tareas
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();

        System.out.println("\n===== CONSULTAS DE ESTADO =====\n");

        // Consultar estados
        System.out.println(gestor.consultarEstadoTarea("T001"));
        System.out.println(gestor.consultarEstadoTarea("T002"));
        System.out.println(gestor.consultarEstadoTarea("T003"));
        System.out.println(gestor.consultarEstadoTarea("T004"));
        System.out.println(gestor.consultarEstadoTarea("T999")); // No existe
    }
}
