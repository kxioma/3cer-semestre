// Main.java
// Punto de entrada del programa: se encarga de iniciar el sistema bancario.

public class Main {

    public static void main(String[] args) {

        // Crear una instancia del banco para manejar las cuentas
        Bank bank = new Bank();

        // Ejecutar el menú principal del sistema
        bank.run();
    }
}
