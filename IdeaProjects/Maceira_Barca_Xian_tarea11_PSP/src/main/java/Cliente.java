
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost";
        final int SERVER_PORT = 12345;
        final int NUM_CLIENTS = 220; // Puedes ajustar este número según tus necesidades

        Thread[] clientThreads = new Thread[NUM_CLIENTS];

        try {
            for (int i = 0; i < NUM_CLIENTS; i++) {
                final int clientId = i;
                clientThreads[i] = new Thread(() -> connectToServer(clientId, SERVER_HOST, SERVER_PORT));
                clientThreads[i].start();
            }

            // Espera a que todos los hilos de clientes terminen
            for (Thread clientThread : clientThreads) {
                clientThread.join();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void connectToServer(int clientId, String serverHost, int serverPort) {
        try (Socket clientSocket = new Socket(serverHost, serverPort)) {
            System.out.println("Cliente " + clientId + " conectado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al conectar cliente " + clientId);
        }
    }
}