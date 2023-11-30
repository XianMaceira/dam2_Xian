import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Collection;

public class XML {
    public static void exportGamesToXML (App app, File file, Collection<Game> games){

      int totalGames = games.size();
      int delGames = 0;
      for (Game game : games) {
          if (game.isDeleted()) {
              delGames++;
          }
      }


        try {
            // Crear el DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "games", null);

            // Manipular el DOM
            Element root = doc.getDocumentElement();

            Attr attr1 = doc.createAttribute("total");
            attr1.setValue(String.valueOf(totalGames));
            root.setAttributeNode(attr1);

            Attr attr2 = doc.createAttribute("deleted");
            attr2.setValue(String.valueOf(delGames));
            root.setAttributeNode(attr2);

            Element elementGame = doc.createElement("game");

            for (Game currGame : games) {
                Element game = doc.createElement("game");
                game.setTextContent(currGame.getTitle());
                root.appendChild(game);
            }

            // Exportar a un fichero XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
