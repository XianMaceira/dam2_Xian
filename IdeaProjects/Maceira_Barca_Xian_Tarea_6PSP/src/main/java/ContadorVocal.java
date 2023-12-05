public class ContadorVocal implements Runnable{

    private String vocal;
    private String input;
    private Contador contador;


    public ContadorVocal(String vocal, String input, Contador contador) {
        this.vocal = vocal;
        this.input = input;
        this.contador = contador;
    }

    @Override
    public void run() {
        int contadorVocal = 0;

        for (int i = 0; i< input.length(); i++) {
            if (Character.toString(input.charAt(i)).equalsIgnoreCase(vocal)) {
                contadorVocal++;
                contador.incrementar();
            }
        }

        System.out.println("Hilo para la vocal " + vocal + ". Total: " + contadorVocal);
    }
}
