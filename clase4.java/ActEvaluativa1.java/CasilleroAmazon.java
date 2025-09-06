import java.util.Scanner;

public class CasilleroAmazon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Creamos una Matriz de 3 x 3 para guardar los paqueteCastillo
        
        PaqueteCasillero[][] casilleros = new PaqueteCasillero[3][3];

        int opcion = 0;
        while (opcion != 4) {
            // Menú principal
            System.out.println("\n--- SISTEMA DE CASILLEROS DE AMAZON 🌟 ---");
            System.out.println("1. Registre su paquete en un casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Ver información de paquetes");
            System.out.println("4. Salir");
            System.out.print("eleccione una opción amable usuario: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {
                // Registrar paquete
                System.out.println("\n*** Registre su  paquete ***");
                System.out.print("Ingrese fila (0-2): ");
                int fila = sc.nextInt();
                System.out.print("Ingrese columna (0-2): ");
                int col = sc.nextInt();
                sc.nextLine();

                if (casilleros[fila][col] == null) {
                    System.out.print("Ingrese nombre del destinatario porfavor : ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese fecha de ingreso porfavor (dd/mm/aaaa): ");
                    String fecha = sc.nextLine();


                  //Guardamos el obj hijo en la Matriz 
                    casilleros[fila][col] = new PaqueteCasillero(nombre, fecha, fila, col);

                    System.out.println("✅ Paquete registrado en [" + fila + "][" + col + "]");
                } else {
                    System.out.println("⚠️Este  Casillero esta  ocupado. Elija otro porfavor.");
                }

            } else if (opcion == 2) {
                // Mostrar casilleros libres/ocupados
                System.out.println("\n*** Casilleros disponibles ***");
                for (int i = 0; i < casilleros.length; i++) {
                    for (int j = 0; j < casilleros[i].length; j++) {
                        if (casilleros[i][j] == null) {
                            System.out.print("[ Esta Libre] ");
                        } else {
                            System.out.print("[Esta Ocupado] ");
                        }
                    }
                    System.out.println();
                }

            } else if (opcion == 3) {
                // Mostrar información de paquetes
                System.out.println("\n*** Información de paquetes ***");
                for (int i = 0; i < casilleros.length; i++) {
                    for (int j = 0; j < casilleros[i].length; j++) {
                        if (casilleros[i][j] != null) {
                            System.out.println(casilleros[i][j].mostrarInfo());
                        }
                    }
                }

            } else if (opcion == 4) {
                System.out.println("👋 Cerrando la aplicación...");
            } else {
                System.out.println("❌ Opción inválida, intente de nuevo porfavor.");
            }
        }
    }
}
