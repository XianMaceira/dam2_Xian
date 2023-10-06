package Vehiculo;

public class Camion extends Vehiculo{

    private int ejes;



    public Camion(String color, int ruedas, int potencia, int cilindrada, int ejes) {
        super(color, ruedas, potencia, cilindrada);
        this.ejes = ejes;
    }

    @Override
    double obtenerImpuesto() {
        return getCilindrada()/30 + getPotencia()*20 + getRuedas()*20 + ejes*50;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasajeros "+this.ejes+"\n");
        sb.append("Impuesto "+this.obtenerImpuesto()+"\n");
        return super.toString() + sb.toString();
    }


}
