package ejercicio115;

import java.io.*;
import java.util.ArrayList;

class ManejoProductos {
    public ArrayList<Producto> crearProductos() {
        int[] identificadores = {123, 456, 789, 235, 567};
        String[] descripciones = {"cafe", "leche", "arroz", "sal", "coco"};
        double[] precios = {1.22, 1.05, 1, 1.25, 3.2};

        ArrayList<Producto> productos = new ArrayList<>();

        for (int i = 0; i < identificadores.length; i++) {
            Producto producto = new Producto(identificadores[i], descripciones[i], precios[i]);
            productos.add(producto);
        }

        return productos;
    }

    public void almacenarProductos(ArrayList<Producto> productos) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.bin"));
            oos.writeObject(productos);
            oos.close();
            System.out.println("Productos almacenados en productos.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void leerProdcutos() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.bin"));
            ArrayList<Producto> productos = (ArrayList<Producto>) ois.readObject();
            ois.close();

            System.out.println("Contenido de productos.bin:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}