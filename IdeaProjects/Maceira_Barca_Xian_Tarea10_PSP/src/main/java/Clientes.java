import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clientes {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 8080;

        try {
            // Cliente 1
            Socket socketCliente1 = new Socket(host, puerto);
            enviarMensaje(socketCliente1, "Hola desde Cliente 1");

            // Cliente 2
            Socket socketCliente2 = new Socket(host, puerto);
            enviarMensaje(socketCliente2, "Saludos desde Cliente 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enviarMensaje(Socket socket, String mensaje) throws IOException {
        BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salidaCliente = new PrintWriter(socket.getOutputStream(), true);

        salidaCliente.println(mensaje);

        String respuestaServidor = entradaServidor.readLine();
        System.out.println("Respuesta del servidor: " + respuestaServidor);

        entradaServidor.close();
        salidaCliente.close();
        socket.close();
    }
}
