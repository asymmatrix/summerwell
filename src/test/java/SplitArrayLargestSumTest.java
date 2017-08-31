import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SplitArrayLargestSumTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int m;

  @Parameterized.Parameter(2)
  public int expectedResult;

  @Test
  public void test() {
    SplitArrayLargestSum testTarget = new SplitArrayLargestSum();
    int actual = testTarget.splitArray(nums, m);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[]{1, 2147483647},
          2,
          2147483647
        },
        {
            new int[]{7,2,5,10,8},
            2,
            18
        },
    });
  }
}
