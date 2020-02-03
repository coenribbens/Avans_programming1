
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("userinpt-1")
public class AdderTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testAdder() {
        summerWorks(6, 2);
    }
    
    @Test
    public void testWithNegative() {
        summerWorks(-10, -5);
    }
    
    @Test
    public void withZeros() {
        summerWorks(0, 0);
    }
    
    private void summerWorks(int firstInput, int secondInput) {
        ReflectionUtils.newInstanceOfClass(Adder.class);
        io.setSysIn(firstInput + "\n" + secondInput + "\n");
        Adder.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("You did not ask anything!", out.trim().length() > 0);
        
        assertTrue("You should output \":\" when prompting user for input. You printed: "+out,
                   out.contains(":"));
        
        assertTrue("You should output text \"Sum of the numbers:\". You printed: "+out,
                   out.contains("numbers:"));

        String outputResult = out.substring(out.indexOf("numbers:") + "numbers:".length());

        int sum = firstInput + secondInput;
        assertTrue( firstInput + " + " + secondInput + " should be " + sum + ", you proposed: " + outputResult, outputResult.contains("" + sum));
    }
}
