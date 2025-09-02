public class EjecutarVehiculo{

    public static void main(String[] args) {

        Vehiculo[] v = new Vehiculo[5];

        v[0] = new Vehiculo("GRG329", "Chevrolet", 2018, true);
        v[1] = new Vehiculo("PSG129", "Mazda", 2004, false);
        v[2] = new Vehiculo("JYH890", "Porsche", 1669, false);
        v[3] = new Vehiculo("KAO389", "Lamborghini", 1999, true);
        v[4] = new Vehiculo("EDI930", "Raptor", 2007, true);

        // Llamamos al método desde cualquier objeto, por ejemplo el primero:
        System.out.println(v[0].iterarvehiculos(v));
    }

}