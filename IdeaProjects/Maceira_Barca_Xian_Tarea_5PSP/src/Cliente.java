import java.util.Random;

class Cliente implements Runnable {
    private Banco banco;

    private Thread thread;
    private int saldoFinal;

    public Cliente(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int cantidad = random.nextInt(100, 3000) + 1;
            banco.depositar(cantidad);

            cantidad = random.nextInt(50, 500) + 1;
            banco.retirar(cantidad);


            saldoFinal = banco.balance();
        }
    }
}
