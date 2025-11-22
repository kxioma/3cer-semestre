// Bank.java
// Contiene la lógica principal del sistema bancario.
// Incluye menú, creación de cuentas, depósitos, retiros, transferencias,
// reportes (merge/quick sort) y búsqueda con HashMap y búsqueda binaria.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Bank {

    // Lista donde se guardan todas las cuentas
    private ArrayList<Account> accounts;

    // Mapa para búsqueda rápida por ID
    private HashMap<Integer, Account> idMap;

    // ID autoincremental
    private int nextId;

    // Scanner para leer datos del usuario
    private Scanner sc;

    // Constructor que inicializa estructuras
    public Bank() {
        accounts = new ArrayList<>();
        idMap = new HashMap<>();
        nextId = 1000;
        sc = new Scanner(System.in); // Scanner correcto
    }

    // ===============================
    // MÉTODO PRINCIPAL - MENÚ
    // ===============================
    public void run() {

        int option;

        do {
            printMenu();

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

        String name = readLine("Nombre: ");
        double initial = readDouble("Saldo inicial: ");

        int id = ++nextId;

        Account acc = new Account(id, name, initial);

        accounts.add(acc);
        idMap.put(id, acc);

        System.out.println("Cuenta creada: " + acc);
    }

    // ===============================
    // 2. ACTUALIZAR NOMBRE
    // ===============================
    private void updateHolderNameUI() {
        int id = readInt("ID: ");

        Account acc = idMap.get(id);

        if (acc == null) {
            System.out.println("No existe la cuenta.");
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
        int id = readInt("ID: ");

        Account acc = idMap.remove(id);

        if (acc == null) {
            System.out.println("Cuenta no existe.");
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

        double amount = readDouble("Monto: ");
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

        double amount = readDouble("Monto: ");

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
    // 7. BUSCAR POR ID
    // ===============================
    private void searchByIdUI() {
        int id = readInt("ID: ");

        System.out.println("1. HashMap");
        System.out.println("2. Búsqueda Binaria");

        int op = readInt("Opción: ");

        if (op == 1) {
            Account acc = idMap.get(id);
            System.out.println(acc != null ? acc : "No encontrada.");
        } else {
            Account acc = searchBinary(id);
            System.out.println(acc != null ? acc : "No encontrada.");
        }
    }

    private Account searchBinary(int id) {

        List<Account> list = new ArrayList<>(accounts);

        list.sort(Comparator.comparingInt(Account::getId));

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = list.get(mid).getId();

            if (midId == id) return list.get(mid);

            if (midId < id) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    // ===============================
    // 8. MERGE SORT
    // ===============================
    private void reportByBalanceUI() {
        List<Account> sorted = Sorter.mergeSortByBalance(accounts);
        sorted.forEach(System.out::println);
    }

    // ===============================
    // 9. QUICK SORT
    // ===============================
    private void reportByNameUI() {
        List<Account> sorted = Sorter.quickSortByName(accounts);
        sorted.forEach(System.out::println);
    }

    // ===============================
    // MÉTODOS DE ENTRADA (SIN ERRORES)
    // ===============================

    private int readInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine().trim());
    }

    private double readDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine().trim());
    }

    private String readLine(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
