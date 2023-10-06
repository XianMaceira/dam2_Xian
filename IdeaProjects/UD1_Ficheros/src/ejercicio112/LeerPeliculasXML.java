package ejercicio112;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class LeerPeliculasXML {
    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio112\\peliculas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("pelicula");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nPELÍCULA #"+(temp+1)+": "+ nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Título: "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Año:  "+ eElement.getElementsByTagName("ano").item(0).getTextContent());
                    System.out.println("Precio: "+eElement.getElementsByTagName("precio").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
