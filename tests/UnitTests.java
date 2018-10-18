
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UnitTests {
    private final String XML_FILE = "C:\\Users\\Christian\\IdeaProjects\\TestAssignment\\data\\xmlforuserstory.XML";

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
    public void VelformedNessTest()
    {
        Document document = (Document) XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));

        String xmlString = XMLHandler.getInstance().convertDocumentToString(document);

        Document xmlDocument = XMLHandler.getInstance().convertStringToDocument(xmlString);

        assertNotNull(xmlDocument);
    }
}