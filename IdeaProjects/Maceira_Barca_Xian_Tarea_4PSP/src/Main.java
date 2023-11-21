import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int NUM_HILOS = 10;
        Thread[] hilosAsociados;

        List<String> nombresSuperdeportivos = new ArrayList<>();
        nombresSuperdeportivos.add("Ferrari F40");
        nombresSuperdeportivos.add("Lamborghini Diablo");
        nombresSuperdeportivos.add("Porsche 911 GT1");
        nombresSuperdeportivos.add("McLaren F1");
        nombresSuperdeportivos.add("Jaguar XJ220");
        nombresSuperdeportivos.add("Bugatti EB110");
        nombresSuperdeportivos.add("Dodge Viper");
        nombresSuperdeportivos.add("Aston Martin Vantage V600");
        nombresSuperdeportivos.add("Nissan 300ZX Twin Turbo");
        nombresSuperdeportivos.add("Honda NSX");

        Contador contador = new Contador();

        hilosAsociados = new Thread[NUM_HILOS];
        for (int i = 0; i < NUM_HILOS; i++) {

            TareaCarrera race = new TareaCarrera(contador);
            Thread hilo = new Thread(race);
            hilo.setName(nombresSuperdeportivos.get(i));
            hilo.start();
            hilosAsociados[i] = hilo;
        }

        for (int i = 0; i < NUM_HILOS; i++) {
            Thread hilo = hilosAsociados[i];
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println();
        System.out.println("---------- RESUMEN ------------");
        System.out.println("Tiempo total de la carrera: " + contador.getCuenta() + " milisegundos.");
        System.out.println("La carrera ha terminado.");
    }
}