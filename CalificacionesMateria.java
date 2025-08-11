public class CalificacionesMateria {
    public static void main(String[] args) {
        String[] materias = { "Matemáticas", "Física", "Química", "Historia" };
        String[] estudiantes = { "Ana", "Carlos", "María" };
        // Matriz: [estudiante][materia]
        double[][] calificaciones = {
                { 85.5, 78.0, 92.5, 88.0 }, // Ana
                { 90.0, 85.5, 87.0, 82.5 }, // Carlos
                { 88.5, 91.0, 89.5, 94.0 } // María
        };
        // Mostrar calificaciones
        System.out.println("REPORTE DE CALIFICACIONES");
        System.out.println("=========================");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("\n" + estudiantes[i] + ":");
            double suma = 0;
            for (int j = 0; j < materias.length; j++) {
                System.out.printf(" %-12s: %.1f%n",
                        materias[j], calificaciones[i][j]);
                suma += calificaciones[i][j];
            }
            double promedio = suma / materias.length;
            System.out.printf(" Promedio: %.1f%n", promedio);
        }

    }

}
