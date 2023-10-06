package ejercicio115;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManejoProductos manejador = new ManejoProductos();

        ArrayList<Producto> productos = manejador.crearProductos();
        manejador.almacenarProductos(productos);
        manejador.leerProdcutos();
    }
}
