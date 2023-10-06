package Ejercicio5;

import java.util.Random;

public class PruebaCCentroEstudios {
    public static void main(String[] args) {
        CCentroEstudios centroEstudios = new CCentroEstudios();

        double[] notas = generarNotasAleatorias(30);

        int aprobados = centroEstudios.numeroDeAprobados(notas);
        int suspensos = centroEstudios.numeroDeSuspensos(notas);
        double media = centroEstudios.notaMedia(notas);





        System.out.println("Número de aprobados: "+aprobados);
        System.out.println("Número de suspensos: "+suspensos);
        System.out.println("Nota Media: "+media);

        System.out.println("Número de pisos: "+centroEstudios.numeroDePisos);
        System.out.println("Número de aulas: "+centroEstudios.numeroDeAulas);
        System.out.println("Número de despachos: "+centroEstudios.numeroDeDespachos);
    }

    public static double[] generarNotasAleatorias(int cantidad) {
        double[] notas = new double[cantidad];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            double nota = random.nextDouble() * 10;
            notas[i] = nota;
        }

        return notas;
    }
}
