import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SlidingWindowMedianTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int k;

  @Parameterized.Parameter(2)
  public double[] expectedResult;

  @Test
  public void test() {
    SlidingWindowMedian testTarget = new SlidingWindowMedian();
    double[] actual = testTarget.medianSlidingWindow(nums, k);
    assertArrayEquals(expectedResult, actual, 0.0000000001);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {1,3,-1,-3,5,3,6,7},
            3,
            new double [] {1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}
        },
    });
  }
}
