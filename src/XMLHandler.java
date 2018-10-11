import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

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

    public void readXMLFile(File inputFile)
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

            String expression = "/TRACE_OECD/MessageSpec";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Something :");
                    System.out.println("SendingCountry : "
                            + eElement
                            .getElementsByTagName("SendingCountry")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (SAXException e)
        {
            e.printStackTrace();
        } catch (XPathExpressionException e)
        {
            e.printStackTrace();
        }
    }
}
