package ejercicio117;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private String nombre;
    private int numIdentificacion;
    private int edad;
    private double promCalificaciones;

    public Estudiante(String nombre, int numIdentificacion, int edad, double promCalificaciones) {
        this.nombre = nombre;
        this.numIdentificacion = numIdentificacion;
        this.edad = edad;
        this.promCalificaciones = promCalificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", numIdentificacion=" + numIdentificacion +
                ", edad=" + edad +
                ", promCalificaciones=" + promCalificaciones +
                '}';
    }
}
