public class Contador {
    private int total = 0;

    public synchronized void incrementar() {
        total++;
    }

    public int getTotal() {
        return total;
    }

}
