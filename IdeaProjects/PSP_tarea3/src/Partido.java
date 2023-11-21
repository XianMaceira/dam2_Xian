import java.util.Random;

class Partido extends Thread {
    private Jugador jugador1;
    private Jugador jugador2;
    private Random random = new Random();

    public Partido(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void run() {
        System.out.println("Inicio del partido entre " + jugador1.getNombre() + " y " + jugador2.getNombre());

        // Simulación del partido
        int resultado = random.nextInt(2); // 0 o 1, simulando un resultado simple

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Determinar al ganador
        Jugador ganador = (resultado == 0) ? jugador1 : jugador2;

        System.out.println("Fin del partido. Ganador: " + ganador.getNombre());
    }
}