public class Main {
    public static void main(String[] args) {
        Abuelo abuelo = new Abuelo();

        // Supongamos que el abuelo ha caído.
        abuelo.setCaida(true);

        // Verificar si el abuelo ha caído.
        if (abuelo.haCaido()) {
            System.out.println("¡Alerta! El abuelo ha caído.");
            System.out.println("Llamando ambulancia...");
        } else {
            System.out.println("El abuelo está bien.");
        }
    }
}
