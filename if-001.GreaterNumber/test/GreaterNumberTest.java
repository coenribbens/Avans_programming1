
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("if-1")
public class GreaterNumberTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi1() {
        io.setSysIn("4\n5\n");
        callMain(GreaterNumber.class);
        String out = io.getSysOut();

        assertTrue("You didn't print anything!", out.trim().length() > 0);
        assertTrue("With the inputs 4 and 5, you printed " + out.trim(), out.trim().contains("5"));
        assertTrue("With the inputs 4 an 5, you printed " + out.trim(), !out.trim().contains("4"));

    }

    @Test
    public void testi2() throws Throwable {
        io.setSysIn("1\n-2\n");
        callMain(GreaterNumber.class);
        String out = io.getSysOut();

        assertTrue("You didn't print anything!", out.trim().length() > 0);
        assertTrue("With the inputs 1 and -2, you printed " + out.trim(), out.trim().contains("1"));
        assertTrue("With the inputs 1 and -2, you printed " + out.trim(), !out.trim().contains("-2"));
    }

    @Test
    public void testi3() {
        io.setSysIn("7\n7\n");
        callMain(GreaterNumber.class);       
        String out = io.getSysOut();       

        assertTrue("You didn't print anything!", out.trim().length() > 0);
        assertTrue("With the inputs 7 and 7, you printed " + out.trim(), !out.trim().contains("7"));
        assertTrue("With the inputs 7 and 7, you should print\"The numbers are equal\" " , out.trim().toLowerCase().contains("equal"));
    }
    
    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(GreaterNumber.class);
            String[] t = null;
            Method m = null;
            String x[] = new String[0];
            m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail( "Something unexpected happened, further info " + e);
        }
    }    
}
