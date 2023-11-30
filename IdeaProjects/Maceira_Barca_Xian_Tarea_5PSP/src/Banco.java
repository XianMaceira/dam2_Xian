class Banco {
    private int saldo = 0;

    public synchronized void depositar(int cantidad) {
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() + " + " + cantidad);
    }

    public synchronized void retirar(int cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println(Thread.currentThread().getName() + " - " + cantidad);
        } else {
            System.out.println(Thread.currentThread().getName() + " - " + cantidad + " pero no hay suficiente saldo");
        }
    }

    public synchronized int balance() {
        return saldo;
    }
}