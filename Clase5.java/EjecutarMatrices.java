public class EjecutarMatrices {

    public static void main(String[] args) {

        Matrices objMatrices = new Matrices();

        int[][] m = objMatrices.llenarMatrizEnteros(3, 3);
        System.out.println(objMatrices.mostrarMatrizEnteros(m));

    }

}