import java.io.File;
import java.util.Collection;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XML {
    public static void exportGames(File outputFile, Collection<Game> games, int totalGames, int deletedGames) {

        try {
            // Crear el DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "games", null);

            // Manipular el DOM
            Element root = doc.getDocumentElement();
            Attr attrTotal = doc.createAttribute("total");
            attrTotal.setValue(String.valueOf(totalGames));
            root.setAttributeNode(attrTotal);
            Attr attrDeleted = doc.createAttribute("deleted");
            attrDeleted.setValue(String.valueOf(deletedGames));
            root.setAttributeNode(attrDeleted);
            for (Game g : games) {
                Element game = doc.createElement("game");
                game.setTextContent(g.exportXML());
                root.appendChild(game);
            }

            // Exportar a un fichero XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);

            System.out.println("Exportado a XML");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
