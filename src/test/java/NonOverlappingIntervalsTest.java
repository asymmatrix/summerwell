import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NonOverlappingIntervalsTest {
  @Parameterized.Parameter
  public Interval[] intervals;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    NonOverlappingIntervals testTarget = new NonOverlappingIntervals();
    int actual = testTarget.eraseOverlapIntervals(intervals);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        /*
        {
            new Interval[] {new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)},
            1
        },
        {
            new Interval[] {new Interval(1, 2), new Interval(2, 3)},
            0
        },*/
        {
            new Interval[] {
                new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3),
                new Interval(3, 4), new Interval(1, 4)},
            3
        },
    });
  }
}
