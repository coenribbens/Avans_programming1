import org.junit.Test;
import org.junit.Rule;
import org.junit.Before;
import java.util.regex.*;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import nl.avans.testhelper.ContainOrderTester;

@Points("variables-1")
public class VariablesTest {

    private String out;

    @Rule
    public MockStdio io = new MockStdio();

    @Before
    public void capturePrint() {
        Variables.main(new String[0]);
        out = io.getSysOut();
    }

    /*String ekaRegex(String a, String b) {
        return "(?s).*" + a + "\\s*" + b + "\\s.*";
    }

    String tokaRegex(String a, String b) {
        return "(?s).*In a nutshell:.*\\s*" + b + "\\s.*";
    }

    void testaa(String a, String b) {
        assertTrue("Check that " + a + " prints right",
                   Pattern.matches(ekaRegex(a,b),out));
        assertTrue("Check that " + a + " prints right also in the nutshell",
                   Pattern.matches(tokaRegex(a,b),out));
    }

    @Test
    public void testChicken() {
        testaa("Chickens:","9000");
    }

    @Test
    public void testBecon() {
        testaa("Bacon \\(kg\\):","0\\.1");
    }

    @Test
    public void testTractor() {
        testaa("A tractor:","Zetor");
    }*/
    
    @Test
    public void testOutput() {
        String[] output = {out};
        new ContainOrderTester(output).contains("Chickens:").
                then("9000").
                then("Bacon (kg):").
                then("0.1").
                then("A tractor").then("Zetor").then("In a nutshell").
                then("9000").then("0.1").then("Zetor");
    }

}
