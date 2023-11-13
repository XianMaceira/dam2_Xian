package model;

import org.w3c.dom.DOMException;
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

    public static void exportAllUsersXML (Users users, File path) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        try {
            if (!path.exists()) {
                path.mkdirs();
            }

            Document doc = db.newDocument();
            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);

            for (User user : users.getAllUsers()) {
                String name = user.getName();
                String age = user.getAge();
                String mail = user.getEmail();

                Element uElement = doc.createElement("user");
                rootElement.appendChild(uElement);

                agregarElemento(doc, rootElement, "name", name);
                agregarElemento(doc, rootElement, "age", age);
                agregarElemento(doc, rootElement, "email", mail);

            }

            File file = new File(path, "users.xml");
            try (FileOutputStream fos = new FileOutputStream(file)){
                writeXml(doc, fos);
            } catch (IOException | TransformerException e) {
                throw new RuntimeException(e);
            }
        } catch (DOMException e) {
            throw new RuntimeException(e);
        }

    }

    static void agregarElemento(Document doc, Element rootElement, String nombre, String valor) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(valor));
        rootElement.appendChild(elemento);
    }

    // Método para escribir el documento XML en un flujo de salida
    static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);


    }
}
