package Vehiculo;

public abstract class Vehiculo {
    private String Color;
    private  int ruedas;
    private int potencia;
    private int cilindrada;

    public Vehiculo(String color, int ruedas, int potencia, int cilindrada) {
        Color = color;
        this.ruedas = ruedas;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }



    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }



    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Color "+this.Color+"\n");
        sb.append("Ruedas "+this.ruedas+"\n");
        sb.append("Potencia "+this.potencia+"\n");
        sb.append("Cilindrada "+this.cilindrada+"\n");
        return sb.toString();

    }

    abstract double obtenerImpuesto();

}
