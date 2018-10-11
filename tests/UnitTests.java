import org.junit.jupiter.api.Test;


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

        assertEquals(txt, "Hello bandit.");
    }
}
