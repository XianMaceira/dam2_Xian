import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        List<Thread> clientes = new ArrayList<>();

        // Crear e iniciar los hilos de clientes
        for (int i = 1; i <= 3; i++) {
            Cliente cliente = new Cliente(banco);
            Thread threadCliente = new Thread(cliente, "Cliente " + i);
            clientes.add(threadCliente);
            threadCliente.start();
        }

        // Esperar a que todos los hilos de clientes terminen
        for (Thread clienteThread : clientes) {
            try {
                clienteThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar el saldo final del banco
        System.out.println("Saldo final del banco: " + banco.balance());
    }
}
