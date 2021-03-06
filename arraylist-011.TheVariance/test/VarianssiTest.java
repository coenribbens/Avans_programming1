
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.Rule;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import static org.powermock.api.easymock.PowerMock.*;

@Points("arraylist-11")
@PrepareForTest(Variance.class)
//@RunWith(PowerMockRunner.class)
public class VarianssiTest {

    @Rule
    public PowerMockRule p = new PowerMockRule();

    public ArrayList<Integer> a(int... i) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int j : i) {
            al.add(j);
        }
        return al;
    }

    @Test
    public void test1() {
        assertEquals("The variance of list[1,1] not correct",
                0, Variance.variance(a(1, 1)), 0.0001);
        assertEquals("The variance of list[2,2] not correct",
                0, Variance.variance(a(2, 2)), 0.0001);
        assertEquals("The variance of list[1,3] not correct",
                2, Variance.variance(a(1, 3)), 0.0001);
    }

    @Test
    public void test2() {
        assertEquals("The variance of list[1,2,3] not correct",
                1, Variance.variance(a(1, 2, 3)), 0.0001);
        assertEquals("The variance of list[2,2,2,2,2,2,2] not correct",
                0, Variance.variance(a(2, 2, 2, 2, 2, 2, 2)), 0.0001);
        assertEquals("The variance of list[-1,1,-2,2,-3,3] not correct",
                5.6, Variance.variance(a(-1, 1, -2, 2, -3, 3)), 0.0001);
        assertEquals("The variance of list[1,1,1,1,2,2,2] not correct",
                0.29, Variance.variance(a(1, 1, 1, 1, 2, 2, 2)), 0.01);
    }

    @Test
    public void usesMethodAverage1() {
        mockStaticPartial(Variance.class, "average");
        reset(Variance.class);

        ArrayList<Integer> studies = new ArrayList<>();
        studies.add(1);
        studies.add(3);

        Variance.average(studies);
        expectLastCall().andReturn(2);

        replay(Variance.class);       

        try {
            Variance.variance(studies);
            verifyAll();
        } catch (AssertionError e) {
            fail("the metod should use the method average to calculate the average of the parameters. \n"
                    + "The method should be called only once!\n"
                    + "When variance was called with list [1,3] " + e);
        }

    }

    @Test
    public void usesMethodAverage2() {
        mockStaticPartial(Variance.class, "average");
        reset(Variance.class);

        ArrayList<Integer> studies = new ArrayList<>();
        studies.add(2);
        studies.add(9);
        studies.add(1);
        studies.add(3);
        studies.add(5);

        Variance.average(studies);
        expectLastCall().andReturn(4);

        replay(Variance.class);
      
        try {
            Variance.variance(studies);    
            verifyAll();
        } catch (Throwable e) {
            fail("the metod should use the method average to calculate the average of the parameters. \n"
                    + "The method should be called only once!\n"
                    + "When variance was called with list  [2,9,1,3,5] " + e);
        } 

    }
}
