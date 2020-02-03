
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("userinput-5")
public class SumOfTheAgesTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testOneNumber() {
        ReflectionUtils.newInstanceOfClass(SumOfTheAges.class);
        io.setSysIn("Tim\n1\nJan\n2\n");
        try {
            SumOfTheAges.main(new String[0]);
        } catch (NumberFormatException e) {
            fail("Check that you read the input in correct order, first the name and then the age.");
        }

        String out = io.getSysOut();
        Pattern pattern = Pattern.compile("[^\\d]*(\\d+).*[^\\d]*(\\d+).*",
                Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(out);
        if (matcher.matches()) {
            fail("There should be no other values in your output than the sum of the ages. You printed: " + out);
        }
    }

    @Test
    public void test() {
        testIkienSumma("Tim", 2, "Jan", 1);
    }

    @Test
    public void testToinen() {
        testIkienSumma("Tim", 0, "Jan", 13);
    }

    private void testIkienSumma(String firstName ,int firstAge, String secondName, int secondAge) {
        ReflectionUtils.newInstanceOfClass(SumOfTheAges.class);
        io.setSysIn(firstName + "\n" + firstAge + "\n" + secondName + "\n" + secondAge + "\n");
        try {
            SumOfTheAges.main(new String[0]);
        } catch (NumberFormatException e) {
            fail("Check that you read the input in correct order, first the name and then the age.");
        }

        String out = io.getSysOut();

        assertTrue("You didn't ask for user input", out.trim().length() > 0);

        assertTrue("There should be \":\" in your output. Your output is: " + out,
                out.contains(":"));

        String names = firstName + " and " + secondName;
        assertTrue("Your output should contain '" + names + "'. Your output is '" + out + "'",
                out.contains(names));

        Pattern pattern = Pattern.compile("[^\\d]*(\\d+).*",
                Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(out);
        if (!matcher.matches()) {
            fail("You should print the sum of the ages. Your output is: " + out);
            return;
        }

        int sum = Integer.parseInt(matcher.group(1));

        assertTrue("Sum of ages " + firstAge + " and " + secondAge + " should be " + (firstAge + secondAge) + ", you printed" + out, (firstAge + secondAge) == sum);
    }
}
