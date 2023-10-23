import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public class Main {

    private static final String LOG_FILE = "log.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Use CountDownLatch to synchronize between processes
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // Process A
        Thread processA = new Thread(() -> {
            PrintWriter printWriter = new PrintWriter(System.out);
            try {
                printWriter.println("Process A starts.");
                printWriter.flush();

                // Process A1
                printWriter.println("Process A1 completes.");
                printWriter.flush();

                // Process A2
                printWriter.println("Process A2 completes.");
                printWriter.flush();

                // Signal to Process B that A2 has finished
                countDownLatch.countDown();
            } finally {
                printWriter.close();
            }
        });

        // Process B
        Thread processB = new Thread(() -> {
            PrintWriter printWriter = new PrintWriter(System.out);
            try {
                // Wait for Process A2 to finish
                countDownLatch.await();

                // Process B1
                printWriter.println("Process B1 completes.");
                printWriter.flush();

                // Process B2
                printWriter.println("Process B2 completes.");
                printWriter.flush();

                // Process B3
                printWriter.println("Process B3 completes.");
                printWriter.flush();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                printWriter.close();
            }
        });

        // Start Process A and Process B
        processA.start();
        processB.start();

        // Wait for Process A and Process B to finish
        processA.join();
        processB.join();
    }
}