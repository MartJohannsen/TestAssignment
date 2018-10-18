import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.IOException;

public class XMLHandler
{
    private static XMLHandler instance = new XMLHandler();

    public static XMLHandler getInstance()
    {
        return instance;
    }

    private XMLHandler()
    {
    }

    public Document getXMLDocument(File inputFile) throws NullPointerException
    {
        try
        {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            return document;
        }
        catch (JDOMException | IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String convertDocumentToString(Document doc)
    {
        return new XMLOutputter().outputString(doc);
    }

    public Document convertStringToDocument(String xmlStr)
    {
        try
        {
            SAXBuilder saxBuilder = new SAXBuilder();
            return saxBuilder.build(xmlStr);
        }
        catch (JDOMException | IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
