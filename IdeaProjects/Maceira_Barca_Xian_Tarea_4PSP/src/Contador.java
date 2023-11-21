class Contador {
    private long cuenta = 0;

    public synchronized void sumarTiempo(long tiempo) {
        cuenta += tiempo;
    }

    public synchronized long getCuenta() {
        return cuenta;
    }
}