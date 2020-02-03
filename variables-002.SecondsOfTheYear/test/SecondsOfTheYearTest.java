import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import org.junit.Before;

@Points("variables-2")
public class SecondsOfTheYearTest {

    private String out;

    @Rule
    public MockStdio io = new MockStdio();

    @Before
    public void capturePrint() {
        SecondsOfTheYear.main(new String[0]);
        out = io.getSysOut();
    }


    @Test
    public void test() {
        assertTrue("You didn't print anything!", out.trim().length()>0);
        assertTrue("Incorrect printed result", out.contains("31536000"));
    }

}
