
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("while-loop-9")
public class LowerLimitAndUpperLimitTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        int[][] lukuparit = {{1, 1}, {12, 8}, {50, 100}, {-2, 2}};
        for (int[] lukupari : lukuparit) {
            test(lukupari);
        }
    }

    private void test(int[] numbers) {
        io.setSysIn(numbers[0] + "\n" + numbers[1] + "\n");
        int len = io.getSysOut().length();

        ReflectionUtils.newInstanceOfClass(LowerLimitAndUpperLimit.class);
        LowerLimitAndUpperLimit.main(new String[0]);
        String output = io.getSysOut().substring(len);

        output = output.replaceAll("[^-\\d]+", " ").trim();
        String[] strings = output.split("\\s+");
        int stringLength = (strings.length == 1 && strings[0].isEmpty()) ? 0 : strings.length;

        int numberOfRows;
        if (numbers[1] < numbers[0]) {
            numberOfRows = 0;
        } else {
            numberOfRows = numbers[1] - numbers[0] + 1;
        }

        if (numberOfRows != stringLength) {
            String numeroLkm = (numberOfRows == 1) ? "number" : "numbers";
            fail("With input " + numbers[0] + ", " + numbers[1] + " oupput shold have " + numberOfRows + " " + numeroLkm + ", now there was " + stringLength);

        }

        if (numberOfRows == 0) {
            return;
        }

        int ekaLuku = Integer.parseInt(strings[0]);
        if (ekaLuku != numbers[0]) {
            fail("With input " + numbers[0] + ", " + numbers[1] + " first printed number should be " + numbers[0] + ", now it was " + ekaLuku);
        }

        int faultNumber = takeStringEnd(output);
        if (faultNumber != numbers[1]) {
            fail("With input " + numbers[0] + ", " + numbers[1] + " last printed number should be " + numbers[1] + ", now it was " + faultNumber);
        }
    }

    private static int takeStringEnd(String inputStr) {
        String patternStr = "(?s).*?(-?\\d+)\\s*$";
        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);
        assertTrue("You should print numbers only!", matcher.find());

        int number = Integer.parseInt(matcher.group(1));
        return number;
    }
}
