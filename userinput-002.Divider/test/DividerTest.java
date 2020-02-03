import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("userinput-2")
public class DividerTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testDivider() {
        dividerTest(3, 2);
    }

    @Test
    public void testNegative() {
        dividerTest(3, -2);
    }

    @Test
    public void testWithInfinitelyManyDecimals() {
        dividerTest(10, 3);
    }

    private void dividerTest(int firstInput, int secondInput) {
        ReflectionUtils.newInstanceOfClass(Divider.class);
        io.setSysIn(firstInput + "\n" + secondInput + "\n");
        Divider.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("You did not ask anything!", out.trim().length() > 0);

        assertTrue("You should output \":\" when prompting user for input. You printed: " + out,
                out.contains(":"));


        assertTrue("You should output text 'Division: X / Y = Z' for some integers X, Y and Z. You printed: " + out,
                out.contains("ivision:"));


        String output = out.substring(out.indexOf("ivision:") + "ivision:".length());

        Matcher m = Pattern.compile("(?s)\\s*?([-.0-9]+)\\s*/\\s*([-.0-9]+)\\s*=\\s*([-.0-9]+)\\s*").matcher(output);

        assertTrue("Your output should be of the form 'X / Y = Z' for some integers X, Y and Z. Now it was: " + output,
                m.matches());


        String sa = m.group(1).trim();
        String sb = m.group(2).trim();
        String sc = m.group(3).trim();

        double a, b, c;

        try {
            a = Double.parseDouble(sa);
        } catch (NumberFormatException e) {
            fail("First value '" + sa + "' that you printed is not a proper value");
            return; 
        }

        try {
            b = Double.parseDouble(sb);
        } catch (NumberFormatException e) {
            fail("Second value '" + sb + "' that you printed is not a proper value");
            return; 
        }

        try {
            c = Double.parseDouble(sc);
        } catch (NumberFormatException e) {
            fail("Thirth value '" + sc + "' that you printed is not a proper value");
            return; // tyhmä java
        }

        if (firstInput != (int)a || secondInput != (int)b) {
          fail("String \"" + output + "\" contains wrong formula for the values " + firstInput + " and " + secondInput);
        }

        double divResult = 1.0 * a / b;
        assertEquals("Resut of " + a + " / " + b + " should be "
                + divResult + ", your output is: " + c + "\n"
                + "Did you remember to convert the values to double type?", divResult, c, 0.001);
    }
}
