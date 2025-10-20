import java.util.*;


public class GestorTareas{
private     Queue<Tarea> colaEspera;// Cola FIFO para tareas que pueden esperar
private  Stack <Tarea>pilaPrioritaria;// Pila LIFO para tareas urgentes
private  Map<String, String> registroTrazabilidad; // Mapa para saber si las  tareas ya estan completadas


public GestorTareas(){
    colaEspera = new LinkedList<>();   // Implementación de Queue
    pilaPrioritaria = new Stack<>();  // Implementación de Stack
 registroTrazabilidad = new HashMap<>();  // Implementación de Map

}

public void agregarTarea(Tarea tarea ){
    if (tarea.getPrioridad()==3 ){
        pilaPrioritaria.push(tarea);// Alta prioridad → Pila
    System.out.println("[+]tarea PRIORITARIA agregada a la pila: " + tarea.getId());


    }else {
        colaEspera.offer(tarea);// Baja o media prioridad → Cola
        System.out.println("[+] tarea NORMAL agregada a la cola: " + tarea.getId());
    }

}



public Tarea procesarSiguienteTarea(){
    Tarea tareaProcesada = null; 

    if (!pilaPrioritaria.isEmpty()){
        tareaProcesada = pilaPrioritaria.pop();// Saca la última de la pila

    System.out.println("[*] Procesando tarea Prioritaria:  " +tareaProcesada.getId());

    }else if (!colaEspera.isEmpty()){
        tareaProcesada = colaEspera.poll();// Saca la primera de la cola
         System.out.println("[*] procesando tarea Normal : " +tareaProcesada.getId());

    }else  {
        System.out.println("[!] No hay tareas para procesar :) .");

        return null; // No hay tareas
    }

    String registro = "completada |Llegó : " +tareaProcesada.getTiempoLlegada() + 
    "| Procesada en: " + System.currentTimeMillis();
    registroTrazabilidad.put(tareaProcesada.getId(), registro);

    return tareaProcesada;
    

}

public String consultarEstadoTarea(String idTarea){ 
    if 
   (registroTrazabilidad.containsKey(idTarea)) {
            return "Tarea " + idTarea + ": " + registroTrazabilidad.get(idTarea);
        }

        // Buscar en la pila
        for (Tarea t : pilaPrioritaria) {
            if (t.getId().equals(idTarea)) {
                return "Tarea " + idTarea + " está PENDIENTE en la PILA prioritaria.";
            }
        }

        // Buscar en la cola
        for (Tarea t : colaEspera) {
            if (t.getId().equals(idTarea)) {
                return "Tarea " + idTarea + " está PENDIENTE en la COLA de espera.";
            }
        }

        return "ID no encontrado.";
    }
}
