
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class UnitTests
{
    private final String XML_FILE = "data\\Students.XML";

    @Test
    public void helloWorldTest()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));
        System.out.println("Root element :" + document.getRootElement().getName());
        Element classElement = document.getRootElement();

        List<Element> elementList = classElement.getChildren();
        System.out.println("----------------------------");

        if (elementList != null)
        {
            for (Element node : elementList)
            {
                System.out.println("Element Name: " + node.getName());
                System.out.println("Element Text: " + node.getValue());

                if (node.getChildren() == null || node.getChildren().isEmpty())
                    continue;
            }
        }
    }

    @Test
    public void VelformedNessNotNullTest()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));

        String xmlString = XMLHandler.getInstance().convertDocumentToString(document);

        Document xmlDocument = XMLHandler.getInstance().convertStringToDocument(xmlString);

        assertNotNull(xmlDocument);
    }

    @Test
    public void VelformedNessIsNullTest()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));

        String xmlString = XMLHandler.getInstance().convertDocumentToString(document);

        Document xmlDocument = XMLHandler.getInstance().convertStringToDocument(xmlString);

        assertNull(xmlDocument);
    }
}