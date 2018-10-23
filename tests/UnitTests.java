import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

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

    @Test
    public void isMark()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));
        Element classElement = document.getRootElement();

        List<Element> elementList = classElement.getChildren();

        if (elementList != null)
        {
            for (Element node : elementList)
            {
                try
                {
                    Integer marks = Integer.parseInt(node.getChild("marks").getValue());
                    System.out.println("number is:  " + marks);
                }
                catch (NumberFormatException ex)
                {
                    // ex.printStackTrace();
                    LogHandler.getInstance().logMessage(ex.getMessage(), "Element validation error.");
                    fail("The parsed number was not an integer.");
                }

            }
        }
    }

    @Test
    public void isNotMark()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));
        Element classElement = document.getRootElement();

        List<Element> elementList = classElement.getChildren();

        if (elementList != null)
        {
            for (Element node : elementList)
            {
                try
                {
                    Integer marks = Integer.parseInt(node.getChild("marks").getValue());
                    System.out.println("number is:  " + marks);

                    LogHandler.getInstance().logMessage("The mark was not validated as a number.", "Element validation error.");
                    fail("The parsed number was an integer.");
                }
                catch (NumberFormatException ex)
                {
                    continue;
                }
            }
        }
    }

    @Test
    public void nameIsString()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));
        Element classElement = document.getRootElement();

        List<Element> elementList = classElement.getChildren();

        if (elementList != null)
        {
            for (Element node : elementList)
            {
                System.out.println("Element Name: " + node.getName());
                System.out.println("Element Text: " + node.getValue());

                String firstName = node.getChild("firstname").getValue();
                String lastName = node.getChild("lastname").getValue();

                if (isString(firstName) || isString(lastName))
                {
                    continue;
                }
                else
                {
                    LogHandler.getInstance().logMessage("Text is null", "Element Validition Error; "
                            + "firstname does not only contain letters, Element: " + node.getChild("firstname").getName() + ", Value: " + firstName
                            + ", Element: " + node.getChild("lastname").getName() + ", Value: " + lastName);
                    fail("Element Validition Error; "
                            + "firstname does not only contain letters, Element: " + node.getChild("firstname").getName() + ", Value: " + firstName
                            + ", Element: " + node.getChild("lastname").getName() + ", Value: " + lastName);
                }
            }
        }
    }

    public boolean isString(String str)
    {
        if (str.chars().allMatch(Character::isLetter))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Test
    public void nameIsNotString()
    {
        Document document = XMLHandler.getInstance().getXMLDocument(new File(XML_FILE));
        Element classElement = document.getRootElement();

        List<Element> elementList = classElement.getChildren();

        if (elementList != null)
        {
            for (Element node : elementList)
            {
                System.out.println("Element Name: " + node.getName());
                System.out.println("Element Text: " + node.getValue());

                String firstName = node.getChild("firstname").getValue();
                String lastName = node.getChild("lastname").getValue();

                if (isString(firstName) || isString(lastName))
                {
                    LogHandler.getInstance().logMessage("Text is null", "Element Validition Error; "
                            + "firstname does only contain letters, Element: " + node.getChild("firstname").getName() + ", Value: " + firstName
                            + ", Element: " + node.getChild("lastname").getName() + ", Value: " + lastName);
                    fail("Element Validition Error; "
                            + "firstname does only contain letters, Element: " + node.getChild("firstname").getName() + ", Value: " + firstName
                            + ", Element: " + node.getChild("lastname").getName() + ", Value: " + lastName);
                }
                else
                {
                    continue;
                }
            }
        }
    }
}