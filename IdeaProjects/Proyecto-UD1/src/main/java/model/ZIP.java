package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static model.XML.*;

public class ZIP {
    public static void exportAllUsersZip (App app, File file) throws ParserConfigurationException, IOException {
        File path = new File(file.getParent(), "users");
        app.exportAllUsersToXML(path);
        app.exportAllUsersToJSON(path);

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file))){
            makeZip(path, "Users", zos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        delDirectory(Paths.get(path.getAbsolutePath()));
    }

    public static void makeZip (File path, String name, ZipOutputStream zos) throws IOException {

        File[] files = path.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                makeZip(file, name + File.separator + file.getName(), zos);
            } else {
                FileInputStream fis = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(name + File.separator + file.getName());
                zos.putNextEntry(zipEntry);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                fis.close();
            }

        }

    }

    public static void delDirectory(Path directory) throws IOException
    {
        if (Files.exists(directory))
        {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attr)
                        throws IOException
                {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path path, IOException ex)
                        throws IOException
                {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }

}
