public class EjecutarLibro {

    public static void main(String[] args) {
        Libro[] L = new Libro[5];

        L[0] = new Libro("100 años de soledad", "Gabriel Garcia Marquez", 55000);
        L[1] = new Libro("El amor en los tiempos del colera", "Gabriel Garcia Marquez", 60000);
        L[2] = new Libro("Cien años de perdon", "Isabel Allende", 40000);
        L[3] = new Libro("La casa de los espiritus", "Isabel Allende", 45000);
        L[4] = new Libro("El principito", "Antoine de Saint", 30000);

        // Muestra todos los libros del arreglo
        System.out.println("Lista de los Libros: ");
        for (Libro libro : L) {
            System.out.println(libro); // ahora sí llama al toString()
        }

        // Muestra el precio total de los Libros
        int total = calcularPrecioTotal(L);
        System.out.println("El precio total de los Libros es: " + total);

        // Filtra los libros por precio mayor a 45.000
        System.out.println("Libros con precio mayor a 45.000: ");
        Libro[] resultado = filtrarPorPrecio(L, 45000);

        for (Libro libro : resultado) {
            System.out.println(libro);
        }

        // Ordenar por precio
        ordenarPorPrecio(L);
        System.out.println("Libros Ordenados por Precio (menor a mayor): ");
        for (Libro libro : L) {
            System.out.println(libro);
        }

        // Actualizar precio de un libro
        actualizarPrecio(L, "El principito", 35000);
        System.out.println("Nuevo Precio actualizado: ");
        for (Libro libro : L) {
            System.out.println(libro);
        }

        // Búsqueda del libro por título
        Libro libroEncontrado = buscarPorTitulo(L, "Cien años de perdon");
        if (libroEncontrado != null) {
            System.out.println("Libro Encontrado: " + libroEncontrado);
        } else {
            System.out.println("Libro no Encontrado");
        }
    }

    // Método que calcula el precio total de los libros
    public static int calcularPrecioTotal(Libro[] libros) {
        int suma = 0;
        for (int i = 0; i < libros.length; i++) {
            suma += libros[i].getPrecio();
        }
        return suma;
    }

    // Filtrar libros por precio mayor al valor dado
    public static Libro[] filtrarPorPrecio(Libro[] libros, int valor) {
        int contador = 0;
        for (Libro libro : libros) {
            if (libro.getPrecio() > valor) {
                contador++;
            }
        }

        Libro[] filtrados = new Libro[contador];
        int i = 0;
        for (Libro libro : libros) {
            if (libro.getPrecio() > valor) {
                filtrados[i] = libro;
                i++;
            }
        }

        return filtrados;
    }

    // Ordenar libros por precio (burbuja)
    public static void ordenarPorPrecio(Libro[] libros) {
        int n = libros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (libros[j].getPrecio() > libros[j + 1].getPrecio()) {
                    // Intercambiar
                    Libro temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    }

    // Actualizar precio de un libro por título
    public static void actualizarPrecio(Libro[] libros, String titulo, int nuevoPrecio) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.setPrecio(nuevoPrecio);
                return;
            }
        }
    }

    // Buscar libro por título
    public static Libro buscarPorTitulo(Libro[] libros, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
