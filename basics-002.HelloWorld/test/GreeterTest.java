import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import nl.avans.testhelper.AvansUtils;

@Points("basics-2")
public class GreeterTest {

    @Rule
    public MockStdio io = new MockStdio();

    public String[] expectedOutput =
    {"Hello world!",
     "(And all the people of the world)"};

    @Test
    public void test() {
        Greeter.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("You did not print anything!",out.length()>0);

        String[] lines = out.split("\n");

        assertEquals("Your program should print 2 lines, "
                + "so it should have 2 System.out.println() commands.",
                     expectedOutput.length, lines.length);

        assertEquals("First line is wrong", expectedOutput[0], AvansUtils.trimEnd(lines[0]));
        assertEquals("Second line is wrong", expectedOutput[1], AvansUtils.trimEnd(lines[1]));
    }

}
