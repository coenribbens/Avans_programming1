
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("bit_operations-1")
public class CountingBitsTest {
    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testNumbers() {
        int[] numbers = new int[] { 429, 0, 12345 };
        int[] ones = new int[] { 6, 0, 6 };
        int[] zeroes  = new int[] { 26, 32, 26 };

        for(int i = 0; i < numbers.length; i++)
        {
            io.disable();
            io.enable();
            ReflectionUtils.newInstanceOfClass(CountingBits.class);
            io.setSysIn(numbers[i] + "\n");
            CountingBits.main(new String[0]);

            String out = io.getSysOut();

            assertTrue("You did not ask anything!", out.trim().length() > 0);
           
            String[] lines = out.split("\n");
            assertTrue("You should print out 3 lines", lines.length == 2);

            assertTrue("The number of zeroes for " + numbers[i] + " is not correct, expected '" + zeroes[i] + " bits', but got " + lines[0], lines[0].contains(zeroes[i] + " bits"));
            assertTrue("The number of ones for " + numbers[i] + " is not correct, expected '" + ones[i] + " bits', but got " + lines[1], lines[1].contains(ones[i] + " bits"));
        }

    }

        
        
}
