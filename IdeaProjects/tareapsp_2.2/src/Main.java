

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

      ProcessBuilder[] pBuilder = new ProcessBuilder[5];
      String[] divisores = {"2","3","4","6","12"};
      for (int i = 0; i < pBuilder.length; i++) {
          pBuilder[i] = PBuilder(String.valueOf(i + 1), divisores[i]);
      }

      Process divi2 = pBuilder[0].start();
      Process divi3 = pBuilder[1].start();

      divi2.waitFor();
      Process divi4 = pBuilder[2].start();

      divi3.waitFor();
      Process divi6 = pBuilder[3].start();

      divi4.waitFor();
      divi6.waitFor();

      Process divi12 = pBuilder[4].start();




    }

    public static ProcessBuilder PBuilder(String processNumber, String divisor) {
        File file = new File("divisores.txt");
        File errorsFile = new File("error.txt");
        String command = "Writer";
        ProcessBuilder pbuilder = new ProcessBuilder("java", "-cp", "C:\\Users\\dam2_alu11\\Documents\\GitHub\\dam2_Xian\\IdeaProjects\\tareapsp_2.2\\out\\production\\tareapsp_2.2\\", command, file.getAbsolutePath(), processNumber, divisor);

        pbuilder.redirectError(errorsFile);

        return pbuilder;
    }
}