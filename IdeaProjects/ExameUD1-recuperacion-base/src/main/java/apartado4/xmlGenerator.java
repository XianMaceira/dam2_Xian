package apartado4;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class xmlGenerator {

    public static void xmlGen(File outfile) {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "devices", null);

            Element root = doc.getDocumentElement();
            Attr dateAttr = doc.createAttribute("date-creation");
            dateAttr.setValue(date);
            root.setAttributeNode(dateAttr);

            System.out.println("Cuantos pcs de sobremesa quieres introducir? ");
            int desktop = sc.nextInt();

            System.out.println("Cuantos pcs portatiles quieres introducir? ");
            int laptop = sc.nextInt();

            pcTypeDesktop(doc, root, desktop);
            pcTypeLaptop(doc, root, laptop);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outfile);
            transformer.transform(source, result);

            System.out.println("Exportado...");

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }

    }

    public static void pcTypeDesktop(Document doc, Element root, int desktop) {
        Scanner sc = new Scanner(System.in);
        Element pcType = doc.createElement("desktop");

        int i = 0;
        while (i!=desktop) {
            System.out.print("Introduce el nombre de tu pc de escritorio: ");
            String name = sc.nextLine();

            Element devElement = doc.createElement("device");
            devElement.appendChild(doc.createTextNode(name));
            pcType.appendChild(devElement);
            i++;
        }



        root.appendChild(pcType);

    }

    public static void pcTypeLaptop(Document doc, Element root, int laptop) {
        Scanner sc = new Scanner(System.in);
        Element pcType = doc.createElement("laptop");

        int i = 0;
        while (i!=laptop) {
            System.out.print("Introduce el nombre de tu pc portatil: ");
            String name = sc.nextLine();

            Element devElement = doc.createElement("device");
            devElement.appendChild(doc.createTextNode(name));
            pcType.appendChild(devElement);
            i++;
        }



        root.appendChild(pcType);

    }

}
