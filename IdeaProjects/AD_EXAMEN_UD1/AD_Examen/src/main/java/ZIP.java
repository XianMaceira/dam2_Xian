import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {

    public static void exportGames(File dir) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(dir, "result.zip"));
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            for (File f : dir.listFiles()) {
                if (f.isDirectory())
                    addToZIP(f, f.getName(), zipOut);
            }
            zipOut.close();
            fos.close();
            System.out.println("Exportado a ZIP");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void addToZIP(File fileToZip, String fileName, ZipOutputStream zipOut) {
        try {
            if (fileToZip.isDirectory()) {
                String folderName = fileName.endsWith("/") ? fileName : (fileName + "/");
                zipOut.putNextEntry(new ZipEntry(folderName));
                zipOut.closeEntry();

                File[] children = fileToZip.listFiles();
                for (File childFile : children) {
                    addToZIP(childFile, fileName + "/" + childFile.getName(), zipOut);
                }
                return;
            }

            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int lenght;
            while ((lenght = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, lenght);
            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
