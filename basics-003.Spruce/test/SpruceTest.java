
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import nl.avans.testhelper.AvansUtils;

@Points("basics-3")
public class SpruceTest {

    @Rule
    public MockStdio io = new MockStdio();
    public String[] shouldContains = 
       {"    *",
        "   ***",
        "  *****",
        " *******",
        "*********",
        "    *"};

    @Test
    public void test() {
        Spruce.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("You didn't print any stars!", out.contains("*"));

        String[] lines = out.split("\n");

        assertEquals("Your program should print 6 lines, "
                + "so it should have 6 System.out.println() commands.",
                shouldContains.length, lines.length);

        assertEquals("First line is wrong",  shouldContains[0], AvansUtils.trimEnd(lines[0]));
        assertEquals("Second line is wrong", shouldContains[1], AvansUtils.trimEnd(lines[1]));
        assertEquals("Third line is wrong",  shouldContains[2], AvansUtils.trimEnd(lines[2]));
        assertEquals("Fourth line is wrong", shouldContains[3], AvansUtils.trimEnd(lines[3]));
        assertEquals("Fifth line is wrong",  shouldContains[4], AvansUtils.trimEnd(lines[4]));
        assertEquals("Sixth line is wrong",  shouldContains[5], AvansUtils.trimEnd(lines[5]));

    }
    
}
