
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("userinput-3")
public class CircumferenceTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testCirlecumference() {
        testCircumferenceInput(3);
    }

    private void testCircumferenceInput(int inputValue) {
        ReflectionUtils.newInstanceOfClass(Circumference.class);
        io.setSysIn(inputValue + "\n");
        Circumference.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("You did not ask anything!", out.trim().length() > 0);

        assertTrue("You should output \":\" when prompting user for input. Your output: " + out,
                out.contains(":"));


        assertTrue("You should output text  \"Type the radius:\". Your output: " + out,
                out.contains("adius:"));

        String resultString = out.substring(out.indexOf("circle:") + "circle:".length());
        double resultValue;
        try {
            resultValue = Double.parseDouble(resultString.trim());
        } catch (Exception e) {
            fail("Output the result in following style 'Circumference of the circle: 125.1253'. Your output: '" + resultString + "'.");
            return;
        }

        double result = (Math.PI * 2 * inputValue);
        assertEquals("Circumference of the circle with radius " + inputValue +
                " should be " + result + ", you proposed: " +
                resultString.trim(), result, resultValue, 0.001);
    }
}
