public class Ejercicio_Xian {
    public static void main(String[] args) {
        // Usando el operador +
        long t0 = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "a";
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Tiempo usando +: " + (t1 - t0) + " ms");

        // Usando StringBuilder
        long t2 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("a");
        }
        long t3 = System.currentTimeMillis();
        System.out.println("Tiempo con el StringBuilder: " + (t3 - t2) + " ms");
    }
}