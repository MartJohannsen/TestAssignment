
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;


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
    public void wellFormednessNotNull()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));

        //If this document is null, the test fails, else succes
        if(document == null)
        {
            LogHandler.getInstance().logMessage("Document is not Wellformed", "Validation Error");
            fail("Is Null");
        }
    }

    @Test
    public void wellFormednessIsNull()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));

        //If this document is not null(we want it to be null), the test fails, else succes (the document is null)
        if(document != null)
        {
            LogHandler.getInstance().logMessage("Document is not Wellformed", "Validation Error");
            fail("Is Not Null");
        }
    }
}