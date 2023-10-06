package ejercicio114;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class iniciarSesion {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("usuarios.xml"));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el nombre de usuario: ");
            String usuario = br.readLine();
            System.out.print("Ingrese la contraseña: ");
            String contraseña = br.readLine();

            NodeList usuariosList = doc.getElementsByTagName("usuario");
            boolean inicioSesionExitoso = false;
            for (int i = 0; i < usuariosList.getLength(); i++) {
                Element usuarioElement = (Element) usuariosList.item(i);
                String nombre = usuarioElement.getElementsByTagName("nombre").item(0).getTextContent();
                String clave = usuarioElement.getElementsByTagName("contraseña").item(0).getTextContent();

                if (usuario.equals(nombre) && contraseña.equals(clave)) {
                    inicioSesionExitoso = true;
                    break;
                }
            }

            if (inicioSesionExitoso) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaActual = formatter.format(date);
                String mensaje = "El usuario " + usuario + " ha iniciado sesión en la fecha " + fechaActual + ".";
                guardarEnArchivo("login.txt", mensaje);

                System.out.println("SE HA INICIADO SESIÓN CON ÉXITO.");
            } else {
                System.out.println("USUARIO O CONTRASEÑA INCORRECTOS.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void guardarEnArchivo(String archivo, String mensaje) {
        try {
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(mensaje);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}