package ejercicio107;

import java.io.*;

class FicheroTexto {
    private File archivo;

    public FicheroTexto(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    public File getArchivo() {
        return archivo;
    }

    public void escribir(String texto) {
        try (FileWriter escritor = new FileWriter(archivo, true); // true para abrir en modo de añadir al final del archivo
             BufferedWriter bufferEscritura = new BufferedWriter(escritor)) {
            bufferEscritura.write(texto);
            bufferEscritura.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leer() {
        try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferLectura = new BufferedReader(lector)) {
            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}