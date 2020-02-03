
import org.junit.Test;
import org.junit.Rule;

import static org.powermock.api.easymock.PowerMock.*;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import java.util.NoSuchElementException;
import org.junit.Before;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(Graph.class)
public class TemperaturesTest {

    @Rule
    public MockStdio io = new MockStdio();
    public Graph mockGraph;

    @Before
    public void before() {
        mockGraph = createStrictMock(Graph.class);
        Graph.instance = mockGraph;
    }

    void runMain() {
        replayAll();
        try {
            Temperatures.main(new String[0]);
        } catch (NoSuchElementException e) {
            // pass
        }
    }

    void runTest(String message) {
        try {
            runMain();
            verifyAll();
        } catch (AssertionError t) {
            fail(message + " More info: " + t);
        } catch (Throwable t) {
            fail("Something went wrong: "+t);
        }
    }

    @Points("while-loop-2.1")
    @Test
    public void testOne() {
        io.setSysIn("3\n");
        mockGraph.addaNumber(3);
        runTest("Your program did not call Graph.addNumber(3) when input was \"3\".");
    }

    @Points("while-loop-2.1")
    @Test
    public void testMany() {
        io.setSysIn("3\n4\n5\n");

        //String out = io.getSysOut();

        mockGraph.addaNumber(3);
        mockGraph.addaNumber(4);
        mockGraph.addaNumber(5);

        runTest("Your program did not call Graph.addNumber() correctly fot inputs 3, 4 and 5.");
    }

    @Points("while-loop-2.2")
    @Test
    public void testPartTwoToSmall() {
        io.setSysIn("-1000\n");
        runTest("You should not add -1000 to graph.");
    }

    @Points("while-loop-2.2")
    @Test
    public void testPartTwoToBig() {
        io.setSysIn("1000\n");
        runTest("You should not add 1000 to graph.");
    }

    @Points("while-loop-2.2")
    @Test
    public void testAll() {
        io.setSysIn("0\n-31\n-40\n15\n16\n39\n41\n49\n0\n");
        mockGraph.addaNumber(0);
        mockGraph.addaNumber(15);
        mockGraph.addaNumber(16);
        mockGraph.addaNumber(39);
        mockGraph.addaNumber(0);
        runTest("Given the input 0, -31, -40, 15, 16, 39, 41, 49, 0, you should add to graph only values 0, 15, 16, 39, 0.");
    }
}   
   
