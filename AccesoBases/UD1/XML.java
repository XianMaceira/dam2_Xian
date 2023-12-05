import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XML {
    public static void main(String[] args) {
        try {
            File inputFile = new File("file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("employee");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println("Employee ID: " + element.getAttribute("id"));
                    System.out.println("First Name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());

                    NodeList carsNodeList = element.getElementsByTagName("car");
                    if (carsNodeList.getLength() > 0) {
                        System.out.println("Cars:");
                        for (int i = 0; i < carsNodeList.getLength(); i++) {
                            System.out.println("- " + carsNodeList.item(i).getTextContent());
                        }
                    }

                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
