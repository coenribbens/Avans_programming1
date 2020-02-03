import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("while-loop-4")
public class SumOfManyNumbersTest {
    
    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        int[][] inputs = {
            {3, 6, 9, 12, 15, 0},
            {1, 0},
            {9, 0},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0}
        };

        for (int[] input : inputs) {
            check(input);
        }
    }

    private void check(int[] numbers) {
        int oldOut = io.getSysOut().length();
        String strings = "";
        int sum = 0;
        for (int number : numbers) {
            sum += number;
            strings += number + "\n";
        }

        io.setSysIn(strings);
        callMain(SumOfManyNumbers.class);
        String out = io.getSysOut().substring(oldOut);

        int answer = otaLukuLopusta(out);

        strings = strings.replaceAll("\n", " ").trim();
        strings = strings.replaceAll(" ", " + ").trim();
        String assertString = "sum of " + strings + " should be " + sum +", you printed \"" + answer + "\"";
        assertTrue("you should print something", out.length() > 0);
        assertEquals(assertString, sum, answer);
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        }  catch (NoSuchElementException e) {
            fail("use Integer.parseInt( reader.nextline() ) to read the numbers");
        } catch (Throwable e) {
            fail("something unexpected happened "+e);
        }
    }

    private static int otaLukuLopusta(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";
        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("The last line of the output should be of the form \" Sum in the end: 10\"", matcher.find());

        int luku = Integer.parseInt(matcher.group(1));
        return luku;
    }
}
