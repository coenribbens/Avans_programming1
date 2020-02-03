
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import org.junit.*;
import static org.junit.Assert.*;

@Points("if-3")
public class AgeCheckTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void goodAgeAccepted() {
        int[] ages = {0, 1, 10, 85, 120};
        for (int age : ages) {
            testPossableAge(age);    
        }       
    }

    @Test
    public void badAgeNotAccepted() {
        int[] ages = {-100, -1, 121, 1000};
        for (int age : ages) {
            testImpossiableAge(age);    
        }       
    }    
    
    private void testPossableAge(int age) {
        int oldOut = io.getSysOut().length(); 
        io.setSysIn(age+"\n");
        callMain(AgeCheck.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("You should print something", out.length() > 0);
        assertTrue("With the input "+age+" you should print \"OK\", you printed " + out, out.toLowerCase().contains("ok"));        
        assertTrue("With the input "+age+" you should print \"OK\", you printed " + out, !out.toLowerCase().contains("mpos"));
    }
    
    private void testImpossiableAge(int age) {
        int oldOut = io.getSysOut().length(); 
        io.setSysIn(age+"\n");
        callMain(AgeCheck.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("You didn't ", out.length() > 0);
        assertTrue("With the input "+age+" you should print \"Impossible\", you printed " + out, out.toLowerCase().contains("mpos"));
        assertTrue("With the input "+age+" you should print \"Impossible\", you printed " + out, !out.toLowerCase().contains("ok"));
    }    

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail("Something unexpected happened, more info "+e);
        }
    }
}
