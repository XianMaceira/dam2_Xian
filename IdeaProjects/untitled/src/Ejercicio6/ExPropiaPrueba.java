package Ejercicio6;

import java.util.Scanner;

import java.util.Scanner;


class ExPropia extends Exception {
    public ExPropia() {
        super("Ha ocurrido una excepción ExPropia");
    }
}


class ExPropiaClase {
    public void pedirNumero() throws ExPropia {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();

        if (numero == 0) {
            throw new ExPropia();
        }
    }
}


public class ExPropiaPrueba {
    public static void main(String[] args) {
        System.out.println("Hola");

        while (true) {
            try {
                ExPropiaClase instancia = new ExPropiaClase();
                instancia.pedirNumero();
            } catch (ExPropia e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

