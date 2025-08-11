public class    InventarioTienda{
    

    public static void main(String[] args) {
        
        String [] productos = {"Laptop", "Mouse", "Teclado", "Monitor"};
        int [] cantidades = {15,50, 30, 8};
        double [] precios = { 15000.00, 250.00, 5500,00};

System.out.println("INVENTARIO DE TIENDA");
System.out.println("=====================");


double valorTotal = 0;
for (int i = 0; i < productos.length; i++){
    double valorProducto = cantidades [i] * precios [i];
    valorTotal += valorProducto;

 
System.out.printf("%-10s | Cant: %3d  | Precio: $%.2f  | Valor: $%10.2f%n",
   productos[i], cantidades[i], precios[i], valorProducto);

}
     
  
        System.out.println("===================="); 
        System.out.printf("VALOR TOTAL DEL INVENTARIO: $%.2f%n", valorTotal); 

}
}