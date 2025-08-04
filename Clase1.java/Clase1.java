import java.util.Arrays;

public class Clase1{


public static void main(String[] args){
    
    System.out.println( "Estructura de datos");

//Arreglos ó arrays ó vectores

//Declaración del arreglo. forma1 
//int [] números;
//números =new int [5];

//Declaración del arreglo. Forma2
//int[] numeros = new int[5];

//Declaración  e inicialización 
//int [] numeros ={10, 20, 30, 40, 50};

OperacionesArreglos objArreglo = new OperacionesArreglos();

int [] numeros = objArreglo.llenarArregloEnteros(5);
System.out.println(Arrays.toString(numeros));


}
}