import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private File file;

    private String numProceso;

    private int divisor;

    public Writer(File file, String numProceso, String divisor) {
        this.file = file;
        this.numProceso = numProceso;
        this.divisor = Integer.parseInt(divisor);
        calculator();
    }

    private void write(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String text = "Proceso ("+numProceso+"): "+message;
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculator() {
        for (int i = 1; i<101;i++) {
            if (i%divisor == 0) {
                write(divisor+" es divisor de "+i);
            }
        }
    }

    public static void main(String[] args) {
        Writer writer = new Writer(new File(args[0]), args[1], args[2]);
    }
}