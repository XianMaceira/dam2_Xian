package ejercicio115;
import java.io.Serializable;
public class Producto implements Serializable{
    private int idProducto;
    private String descripcon;
    private double precios;

    public Producto(int idProducto, String descripcon, double precio) {
        this.idProducto = idProducto;
        this.descripcon = descripcon;
        this.precios = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcon() {
        return descripcon;
    }

    public double getPrecios() {
        return precios;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", descripcon='" + descripcon + '\'' +
                ", precio=" + precios +
                '}';
    }
}
