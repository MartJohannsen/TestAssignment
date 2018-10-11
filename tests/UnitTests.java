import org.junit.jupiter.api.Test;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;




import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Martin on 11-10-2018.
 */
public class UnitTests
{
    @Test
    public void hellowWorldTest()
    {
        XMLHandler.getInstance().readXMLFile(new File("C:\\Users\\Martin\\IdeaProjects\\UnitTestProject\\data\\xmlforuserstory.XML"));
    }


}
