package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XML {

    public static void exportXmlUser(User user, File file) throws ParserConfigurationException {

        String name = user.getName();
        String age = user.getAge();
        String mail = user.getEmail();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("user");
        doc.appendChild(rootElement);

        agregarElemento(doc, rootElement, "name", name);
        agregarElemento(doc, rootElement, "age", age);
        agregarElemento(doc, rootElement, "email", mail);

        try (FileOutputStream output = new FileOutputStream(file)) {
            writeXml(doc, output);
            System.out.println("¡Exportación exitosa!");
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void agregarElemento(Document doc, Element rootElement, String nombre, String valor) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(valor));
        rootElement.appendChild(elemento);
    }

    // Método para escribir el documento XML en un flujo de salida
    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);


    }
}
