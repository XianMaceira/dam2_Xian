package ejercicio113;

import org.w3c.dom.Node;

import org.w3c.dom.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirPeliculasXML {
    public static void main(String[] args) {

        try {
            File xmlOriginal = new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio113\\peliculas.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlOriginal);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource((Node) doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio113\\copia_peliculas.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
