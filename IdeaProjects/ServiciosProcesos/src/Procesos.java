// Java code illustrating ProcessBuilder
// command(List<String> command)
// Java code illustrating environment() method
import java.io.*;
import java.util.*;
class ProcessBuilderDemo {
    public static void main(String[] arg) throws IOException
    {
        // creating the process
        ProcessBuilder pb = new ProcessBuilder();

        // map view of this process builder's environment
        Map<String, String> envMap = pb.environment();

        // checking map view of environment
        for (Map.Entry<String, String> entry :
                envMap.entrySet()) {
            // checking key and value separately
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
