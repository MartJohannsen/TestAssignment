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
        String txt = "Hello bandit.";
        LogHandler.getInstance().logMessage("Bueno", "XML");
        assertEquals(txt, "Hello bandit.");
    }


}
