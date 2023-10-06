package ejercicio108;

import java.io.*;

public class SerializarPersona {

    public void escribirPersonaEnFichero(Persona persona, File fichero) {
        try (FileOutputStream fos = new FileOutputStream(fichero)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persona);
            System.out.println("Persona escrita en el fichero exitosamente.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Persona leerPersonaDeFichero(File fichero) {
        Persona persona = null;
        try (FileInputStream fis = new FileInputStream(fichero)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            persona = (Persona) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return persona;
    }

}
