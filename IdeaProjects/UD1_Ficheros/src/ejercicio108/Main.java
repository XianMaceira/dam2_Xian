package ejercicio108;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Crear una persona
        Persona persona = new Persona("Paco", 23);

        // Crear un fichero persona.ser
        File fichero = new File("persona.ser");

        // Crear una instancia de SerializarPersona
        SerializarPersona serializador = new SerializarPersona();

        // Escribir los datos de la persona en el fichero
        serializador.escribirPersonaEnFichero(persona, fichero);

        // Leer los datos y almacenarlos en un objeto diferente
        Persona personaLeida = serializador.leerPersonaDeFichero(fichero);

        // Mostrar por consola los datos recuperados
        if (personaLeida != null) {
            System.out.println("Persona recuperada: " + personaLeida);
        }
    }

}
