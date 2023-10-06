package ejercicio106;

public class ManejoFicherosBinarios {
    public static void main(String[] args) {
        FicheroBinario ficheroOrigen = new FicheroBinario("origen.bin");
        FicheroBinario ficheroDestino = new FicheroBinario("destino.bin");

        String textoFicheroOrigen = "ESTE ES EL TEXTO DE ORIGEN";
        ficheroOrigen.escribir(textoFicheroOrigen);

        System.out.println("Contenido del fichero de origen");
        ficheroOrigen.leer();

        ficheroOrigen.copiar(ficheroDestino);


        System.out.println("\nContenido del fichero de destino");
        ficheroDestino.leer();
    }
}
