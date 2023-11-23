import java.util.Random;

class TareaCarrera implements Runnable {
    private Contador contador;

    public TareaCarrera(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        Random random = new Random();
        long tiempoTotal = 0;

        System.out.println(Thread.currentThread().getName() + " ha comenzado la carrera.");
            for (int checkpoint = 1; checkpoint <= 6; checkpoint++) {
                long tiempoTramo = 1000 + random.nextInt(101);
                tiempoTotal += tiempoTramo;

                System.out.println(Thread.currentThread().getName() + " ha pasado por el checkpoint " + checkpoint +
                        " en " + tiempoTramo + " milisegundos.");

                contador.sumarTiempo(tiempoTramo);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("\n"+Thread.currentThread().getName() + ": Tiempo total ---> " +
                tiempoTotal + " milisegundos.");
    }
}