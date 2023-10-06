import Vehiculo.Camion;
import Vehiculo.Motocicleta;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PruebaVehiculos {
    public static void main(String[] args) {

        Motocicleta Moto1 = new Motocicleta("Rojo", 2, 25, 125);
        Motocicleta Moto2 = new Motocicleta("Verde ", 2, 25, 125, 2);
        Camion Cam1 = new Camion("Azul",4, 300, 4000, 2);
        Camion Cam2 = new Camion("Fosforito",24, 0, 15000,0);

        Moto1.setPasajeros(1);

        System.out.println("Cilindrada de la segunda moto: "+Moto2.getCilindrada());

        Cam2.setPotencia(800);

        System.out.println("Moto Nº1");
        System.out.println(Moto1);
        System.out.println("---------------");

        System.out.println("Moto Nº2");
        System.out.println(Moto2);
        System.out.println("---------------");

        System.out.println("Camión Nº1");
        System.out.println(Cam1);
        System.out.println("---------------");

        System.out.println("Camión Nº2");
        System.out.println(Cam2);
        System.out.println("---------------");


    }
    }
