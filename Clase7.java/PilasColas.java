import java.util.Stack;

public class PilasColas {

    public static void main(String[] args) {

        //// Pilas en java (Stack)

        // Se crea el objeto " pila " de tipo Stack

        Stack<Integer> pila = new Stack<>();
        System.out.println("La pila est vacia?" + pila.empty());

        // inserta 5 números enteros a la pila
        pila.push(5);
        pila.push(9);
        pila.push(10);
        pila.push(35);
        pila.push(12);

        // Se verifica si la pila esta vacia
        System.out.println(pila);

        // Se imprime la "la pila"
        System.out.println(pila.peek());

        // Se remueve el mismo eemento de la pila
        pila.pop();

        // se obtiene el elemento en la cim a de la pila sin removerlo
        System.out.println("pila.peek");

        // Se imprime la pila
        System.out.println(pila);

        // Se obtiene la posicion de cada elementro de la pila
        System.out.println(pila.search(9));
        System.out.println(pila.search(14));
        System.out.println(pila.search(19));
        System.out.println(pila.search(4));

        // BUSCAMOS un elemento que no este dentro de la pila
        System.out.println(pila.search(80));

    }
}
