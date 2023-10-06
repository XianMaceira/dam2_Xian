package ejercicio106;

import java.io.*;

public class FicheroBinario {
    private File archivo;

    public File getFichero() {
        return archivo;
    }

    public FicheroBinario(String nombreArchivo) {

        archivo = new File(nombreArchivo);
    }

    public void escribir(String texto) {
        try (FileOutputStream fos = new FileOutputStream(archivo)){
            fos.write(texto.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        try (FileInputStream fis = new FileInputStream(archivo)){
            int data;
            while ((data = fis.read()) != -1 ) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiar(FicheroBinario ficheroDestino) {
        try(FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream(ficheroDestino.getFichero())) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
