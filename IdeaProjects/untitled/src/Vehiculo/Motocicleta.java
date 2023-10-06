package Vehiculo;

public class Motocicleta extends Vehiculo{

    private int pasajeros;

    public Motocicleta(String color, int ruedas, int potencia, int cilindrada) {
        super(color, ruedas, potencia, cilindrada);
    }

    public Motocicleta(String color, int ruedas, int potencia, int cilindrada, int pasajeros) {
        super(color, ruedas, potencia, cilindrada);
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    double obtenerImpuesto() {
        return getCilindrada()/30 + getPotencia()*30;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasajeros "+this.pasajeros+"\n");
        sb.append("Impuesto "+this.obtenerImpuesto()+"\n");
        return super.toString() + sb.toString();
    }


}
