import org.junit.Test;
import org.junit.Rule;
import java.util.regex.*;

import static org.junit.Assert.*;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import org.junit.Before;

@Points("variables-4")
public class MultiplicationTest {

       private String out;

    @Rule
    public MockStdio io = new MockStdio();

    @Before
    public void capturePrint() {
        Multiplication.main(new String[0]);
        out = io.getSysOut();
    }

    @Test
    public void test() {

        assertTrue("You did not print anything!", out.trim().length()>0);

        Matcher m = Pattern.compile("(?s).*?(\\d+)\\s*\\*\\s*(\\d+)\\s*=\\s*(\\d+).*").matcher(out);

        assertTrue("Your output should be of the form 'X * Y = Z' for some integers X, Y ja Z. Now it was: "+out,
                   m.matches());

        String sa = m.group(1).trim();
        String sb = m.group(2).trim();
        String sc = m.group(3).trim();

        int a,b,c;

        try {
            a = Integer.parseInt(sa);
        } catch (NumberFormatException e) {
            fail("First value '" + sa + "' that you printed is not an integer");
            return; 
        }

        try {
            b = Integer.parseInt(sb);
        } catch (NumberFormatException e) {
            fail("Second value '" + sb + "' that you printed is not an integer");
            return; 
        }

        try {
            c = Integer.parseInt(sc);
        } catch (NumberFormatException e) {
            fail("Thirth value '" + sc + "' that you printed is not an integer");
            return; 
        }

        assertEquals("Your program claims that "+a+" * "+b+" = "+c+" , but that is not true!",a*b,c);
    }
}
