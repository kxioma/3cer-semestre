public class Libro {
    private String titulo;
    private String autor;
    private int precio;

    // Constructor
    public Libro(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPrecio() {
        return precio;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    // Método toString para imprimir el libro bonito
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Precio: " + precio;
    }
}
