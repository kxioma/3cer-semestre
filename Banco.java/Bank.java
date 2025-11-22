// Bank.java
// Contiene la lógica principal del sistema bancario:
// Menú, creación de cuentas, depósitos, retiros, transferencias,
// reportes con merge/quick sort, y búsquedas con HashMap y Binaria.

import java.util.*;

public class Bank {

    // Lista principal donde se guardan todas las cuentas
    private ArrayList<Account> accounts;

    // Mapa ID → Cuenta para búsquedas rápidas
    private HashMap<Integer, Account> idMap;

    // Generador automático de IDs
    private int nextId;

    // Para leer datos del usuario
    private Scanner sc;

    // Constructor que inicializa estructuras
    public Bank() {
        accounts = new ArrayList<>();
        idMap = new HashMap<>();
        nextId = 1000; // ID inicial
        sc = new Scanner(System.in);
    }

    // ===============================
    // MÉTODO PRINCIPAL - MENÚ
    // ===============================
    public void run() {

        int option;

        do {
            printMenu(); // mostrar menú

            option = readInt("Elige una opción: ");

            switch (option) {
                case 1: createAccountUI(); break;
                case 2: updateHolderNameUI(); break;
                case 3: deleteAccountUI(); break;
                case 4: depositUI(); break;
                case 5: withdrawUI(); break;
                case 6: transferUI(); break;
                case 7: searchByIdUI(); break;
                case 8: reportByBalanceUI(); break;
                case 9: reportByNameUI(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }

        } while (option != 0);
    }

    // Mostrar el menú con las opciones en el orden de la imagen
    private void printMenu() {
        System.out.println("\n===== SISTEMA BANCARIO =====");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Actualizar nombre");
        System.out.println("3. Eliminar cuenta");
        System.out.println("4. Depositar");
        System.out.println("5. Retirar");
        System.out.println("6. Transferir");
        System.out.println("7. Buscar cuenta por ID");
        System.out.println("8. Reporte por balance (Merge Sort)");
        System.out.println("9. Reporte por nombre (Quick Sort)");
        System.out.println("0. Salir");
    }


    // ===============================
    // 1. CREAR CUENTA
    // ===============================
    private void createAccountUI() {
        System.out.println("== Crear cuenta ==");

        String name = readLine("Nombre del titular: ");
        double initial = readDouble("Saldo inicial: ");

        int id = ++nextId; // generar ID

        Account acc = new Account(id, name, initial);

        accounts.add(acc);
        idMap.put(id, acc);

        System.out.println("Cuenta creada: " + acc);
    }


    // ===============================
    // 2. ACTUALIZAR NOMBRE
    // ===============================
    private void updateHolderNameUI() {
        System.out.println("== Actualizar nombre ==");

        int id = readInt("ID de la cuenta: ");

        Account acc = idMap.get(id);

        if (acc == null) {
            System.out.println("No existe esa cuenta.");
            return;
        }

        String newName = readLine("Nuevo nombre: ");
        acc.setHolderName(newName);

        System.out.println("Nombre actualizado.");
    }


    // ===============================
    // 3. ELIMINAR CUENTA
    // ===============================
    private void deleteAccountUI() {
        System.out.println("== Eliminar cuenta ==");

        int id = readInt("ID: ");

        Account acc = idMap.remove(id);

        if (acc == null) {
            System.out.println("No existe esa cuenta.");
            return;
        }

        accounts.remove(acc);

        System.out.println("Cuenta eliminada.");
    }


    // ===============================
    // 4. DEPOSITAR
    // ===============================
    private void depositUI() {
        int id = readInt("ID: ");
        Account acc = idMap.get(id);

        if (acc == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        double amount = readDouble("Monto a depositar: ");
        acc.deposit(amount);

        System.out.println("Depósito exitoso.");
    }


    // ===============================
    // 5. RETIRAR
    // ===============================
    private void withdrawUI() {
        int id = readInt("ID: ");
        Account acc = idMap.get(id);

        if (acc == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        double amount = readDouble("Monto a retirar: ");

        if (acc.withdraw(amount)) {
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }


    // ===============================
    // 6. TRANSFERIR
    // ===============================
    private void transferUI() {
        int from = readInt("ID origen: ");
        int to = readInt("ID destino: ");
        double amount = readDouble("Monto: ");

        Account a = idMap.get(from);
        Account b = idMap.get(to);

        if (a == null || b == null) {
            System.out.println("Una de las cuentas no existe.");
            return;
        }

        if (!a.withdraw(amount)) {
            System.out.println("Fondos insuficientes.");
            return;
        }

        b.deposit(amount);

        System.out.println("Transferencia exitosa.");
    }


    // ===============================
    // 7. BÚSQUEDA POR ID
    // ===============================
    private void searchByIdUI() {
        int id = readInt("ID a buscar: ");

        System.out.println("1. Búsqueda Hash");
        System.out.println("2. Búsqueda Binaria");

        int op = readInt("Elige opción: ");

        if (op == 1) {
            Account acc = idMap.get(id);
            System.out.println(acc != null ? acc : "No encontrada.");
        } else {
            Account acc = searchBinary(id);
            System.out.println(acc != null ? acc : "No encontrada.");
        }
    }

    // Búsqueda binaria por ID
    private Account searchBinary(int id) {
        List<Account> copy = new ArrayList<>(accounts);
        copy.sort(Comparator.comparingInt(Account::getId));

        int low = 0, high = copy.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = copy.get(mid).getId();

            if (midId == id) return copy.get(mid);
            if (midId < id) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }


    // ===============================
    // 8. REPORTE POR BALANCE
    // ===============================
    private void reportByBalanceUI() {
        List<Account> sorted = Sorter.mergeSortByBalance(accounts);
        sorted.forEach(System.out::println);
    }


    // ===============================
    // 9. REPORTE POR NOMBRE
    // ===============================
    private void reportByNameUI() {
        List<Account> sorted = Sorter.quickSortByName(accounts);
        sorted.forEach(System.out::println);
    }


    // ===============================
    // MÉTODOS DE LECTURA
    // ===============================

    private int readInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    private double readDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine());
    }

    private String readLine(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}

