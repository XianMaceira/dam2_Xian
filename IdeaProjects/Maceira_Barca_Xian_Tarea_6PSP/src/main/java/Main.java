import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena de caracteres: ");
        String cadena = sc.nextLine();
        cadena.toUpperCase();

        Contador contador = new Contador();

        Thread hiloA = new Thread(new ContadorVocal("a", cadena, contador));
        Thread hiloE = new Thread(new ContadorVocal("e", cadena, contador));
        Thread hiloI = new Thread(new ContadorVocal("i", cadena, contador));
        Thread hiloO = new Thread(new ContadorVocal("o", cadena, contador));
        Thread hiloU = new Thread(new ContadorVocal("u", cadena, contador));


        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();


        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Total de vocales: "+contador.getTotal()+" en la cadena: "+cadena);
    }
}
