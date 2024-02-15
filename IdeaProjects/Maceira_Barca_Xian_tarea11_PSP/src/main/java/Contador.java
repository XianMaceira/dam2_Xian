class Contador {
    private int value;

    public Contador() {
        this.value = 0;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized int getValue() {
        return value;
    }
}
