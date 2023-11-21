public class Abuelo {
    private boolean haCaido;

    public Abuelo() {
        this.haCaido = false; // Inicialmente, el abuelo no ha caído.
    }

    public boolean haCaido() {
        return haCaido;
    }

    public void setCaida(boolean haCaido) {
        this.haCaido = haCaido;
    }
}
