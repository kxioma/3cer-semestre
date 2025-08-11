import java.util.Arrays;

public class EjecutarEstudiante {
    public static void main(String[] args) {

        // Forma1
        // Creación de los objetos
        Estudiante objEst1 = new Estudiante(909876, " Nicolas ", " pulido c ", " comerciante ");
        Estudiante objEst2 = new Estudiante(456098, " Jose Luis ", " Quiñonez Gomez ", " Trabajador ");
        Estudiante objEst3 = new Estudiante(235621, " Edidson ", " Castillo ", " Futbolista");

        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println("-------------------------");
        // Crear arreglio de objetos
        // int[] a = new int [5];
        Estudiante[] est = new Estudiante[3];
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;

        System.out.println(Arrays.toString(est));
    }
}