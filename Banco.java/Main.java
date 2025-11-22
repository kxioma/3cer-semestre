// Main.java
// Punto de entrada del programa: crea una instancia de Bank y ejecuta el menú.
public class Main {
    public static void main(String[] args) {
        // Crear el objeto banco que contiene la lógica y la interfaz por consola
        Bank bank = new Bank();
        // Ejecutar el loop principal del menú
        bank.run();
    }
}
