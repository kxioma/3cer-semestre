// Account.java
// Representa una cuenta bancaria con ID, nombre del titular y saldo.

public class Account {

    // Identificador único de la cuenta
    private int id;

    // Nombre del titular de la cuenta
    private String holderName;

    // Saldo disponible en la cuenta
    private double balance;

    // Constructor que asigna ID, nombre y saldo inicial
    public Account(int id, String holderName, double initialBalance) {
        this.id = id;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Obtener el ID de la cuenta
    public int getId() {
        return id;
    }

    // Obtener nombre del titular
    public String getHolderName() {
        return holderName;
    }

    // Actualizar nombre del titular
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    // Obtener saldo
    public double getBalance() {
        return balance;
    }

    // Depositar dinero en la cuenta
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El depósito debe ser mayor a cero.");
        }
        balance += amount;
    }

    // Retirar dinero si hay saldo suficiente
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El retiro debe ser mayor a cero.");
        }
        if (amount > balance) {
            return false; // no hay suficiente dinero
        }
        balance -= amount;
        return true;
    }

    // Representación en texto de la cuenta
    public String toString() {
        return "ID: " + id + " | Titular: " + holderName + " | Saldo: " + balance;
    }
}

