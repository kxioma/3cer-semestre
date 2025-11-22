public class Account {
    
    
private int id;  //Identificarador único de la cuenta
 private String holderName;   //nombre de la persona titular de la cuenta
 private double balance;    //saldo actual de la cuenta

    //Constructor:
    public Account(int id, String holderName, double balance){

    this.id=id; 
    this.holderName= holderName;
    this.balance=balance;

}
   //getter y setters
   public int getId(){
    return id;
   }
public String getHolderName(){
    return holderName;
}

public void setHolderName(String holderName){
    this.holderName= holderName;
}
public double getBalance(){
    return balance;
}

//Agregar dinero a la cuenta. 
public void deposit(double amount){
    if (amount <= 0){
        throw new IllegalArgumentException("El monto a depositar debe ser positivo y Mayor que cero.");
    }
balance += amount;// Suma el monto al saldo actual
}

//Intenta retirar dinero
public boolean  withdraw(double amount) {
    if (amount <= 0){

        throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero ");
        
    }
if (amount > balance){
    return false; // Fondos insuficientes


}
balance -= amount; // Resta el monto del saldo actual   
return true; // Retiro exitoso

}
//Representación en cadena de la cuenta(importante para imprimir en reportes/console)
public String toString(){
    return "ID: " + id +
   " | Tittular: " + holderName +
   " | saldo:" + String.format("%.2f", balance);
 
}

}
