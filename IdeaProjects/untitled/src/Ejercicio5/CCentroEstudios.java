package Ejercicio5;

public class CCentroEstudios implements CentroEstudios {

    @Override
    public int numeroDeAprobados(double[] notas) {
        int aprobados = 0;
        for (double nota : notas) {
            if (nota >= 5.0) {
                aprobados++;
            }
        }
        return aprobados;
    }

    @Override
    public int numeroDeSuspensos(double[] notas) {
        int suspensos = 0;
        for (double nota : notas) {
            if (nota < 5.0) {
                suspensos++;
            }
        }
        return suspensos;
    }

    @Override
    public double notaMedia(double[] notas) {
        if (notas.length == 0) {
            return 0.0;
        }

        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;

    }
}
