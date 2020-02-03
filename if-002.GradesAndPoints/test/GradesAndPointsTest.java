
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("if-2")
public class GradesAndPointsTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testGradeInputFail() {
        io.setSysIn("10\n");
        callMain(GradesAndPoints.class);
        String out = io.getSysOut();

        assertTrue("You didn't print anything", out.length() > 0);

        assertTrue("10 should be a fail, you printed " + out, out.toLowerCase().contains("fail"));

        int[] vaarat = {1, 2, 3, 4, 5};
        for (int vaara : vaarat) {
            assertTrue("10 should be a fail, you printed " + out, !out.toLowerCase().contains("" + vaara));
        }
    }

    @Test
    public void testGradeInput2() {
        io.setSysIn("29\n");
        callMain(GradesAndPoints.class);
        String out = io.getSysOut();

        assertTrue("29 should be a fail, you printed " + out, out.toLowerCase().contains("fail"));

        int[] vaarat = {1, 2, 3, 4, 5};
        for (int vaara : vaarat) {
            assertTrue("29 should be a fail, you printed " + out, !out.toLowerCase().contains("" + vaara));
        }
    }

   @Test
    public void testGrade1() {
        int pist = 30;
        int arvos = 1;

        testGrade(pist, arvos);
    }

    @Test
    public void testGrade2() {
        int pist = 34;
        int arvos = 1;

        testGrade(pist, arvos);
    }

    @Test
    public void kakkonen1() {
        int pist = 35;
        int arvos = 2;

        testGrade(pist, arvos);
    }

    @Test
    public void kakkonen2() {
        int pist = 39;
        int arvos = 2;

        testGrade(pist, arvos);
    }

    @Test
    public void kolmonen1() {
        int pist = 40;
        int arvos = 3;

        testGrade(pist, arvos);
    }

    @Test
    public void kolmonen2() {
        int pist = 44;
        int arvos = 3;

        testGrade(pist, arvos);
    }

    @Test
    public void nelonen1() {
        int pist = 45;
        int arvos = 4;

        testGrade(pist, arvos);
    }

    @Test
    public void nelonen2() {
        int pist = 49;
        int arvos = 4;

        testGrade(pist, arvos);
    }

    @Test
    public void vitonen1() {
        int pist = 50;
        int arvos = 5;

        testGrade(pist, arvos);
    }

    @Test
    public void vitonen2() {
        int points = 53;
        int grade = 5;

        testGrade(points, grade);
    }

    private void testGrade(int points, int grade) {
        io.setSysIn(points + "\n");
        callMain(GradesAndPoints.class);
        String out = io.getSysOut();

        assertTrue("You did not print anything", out.length() > 0);

        assertTrue("With " + points + " points grade should be " + grade + ", you printed: " + out, out.toLowerCase().contains("" + grade));

        assertTrue("With " + points + " points grade should be " + grade + ", you printed:  " + out, !out.toLowerCase().contains("fail"));

        int[] gradeList = {1, 2, 3, 4, 5};
        for (int gradeL : gradeList) {
            if ( grade == gradeL ) continue;
            assertTrue("With " + points + " points grade should be " + grade + ", you printed:  " + out, !out.toLowerCase().contains("" + gradeL));
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail("something unexpected happened, more info "+e);
        }
    }
}
