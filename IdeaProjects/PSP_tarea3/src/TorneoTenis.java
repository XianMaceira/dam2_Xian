import java.util.Arrays;
import java.util.List;
public class TorneoTenis {
    public static void main(String[] args) throws InterruptedException {


        List<String> nombresTenistas = Arrays.asList(
                "Rafael Nadal", "Novak Djokovic", "Roger Federer", "Dominic Thiem",
                "Daniil Medvedev", "Stefanos Tsitsipas", "Alexander Zverev", "Andrey Rublev",
                "Diego Schwartzman", "Denis Shapovalov", "Matteo Berrettini", "Felix Auger-Aliassime",
                "Roberto Bautista Agut", "Pablo Carreño Busta", "Gael Monfils", "Andrey Rublev",
                "Stan Wawrinka", "Karen Khachanov", "Grigor Dimitrov", "David Goffin",
                "John Isner", "Alex de Minaur", "Borna Coric", "Milos Raonic",
                "Kyle Edmund", "Fernando Verdasco", "Fabio Fognini", "Nick Kyrgios",
                "Kei Nishikori", "Taylor Fritz", "Mikhail Kukushkin", "Guido Pella"
        );

        Jugador[] jugadores = new Jugador[32];
        for (int i = 0; i < 32; i++) {
            jugadores[i] = new Jugador(nombresTenistas.get(i));
        }

        Partido[] partidos = new Partido[16];
        for (int i = 0; i < 16; i++) {
            partidos[i] = new Partido(jugadores[i], jugadores[31 - i]);
            partidos[i].start();
        }

        for (Partido partido : partidos) {
            try {
                partido.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }
}