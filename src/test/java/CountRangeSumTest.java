import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountRangeSumTest {
  @Parameterized.Parameter
  public int[] nums ;

  @Parameterized.Parameter(1)
  public int lower ;

  @Parameterized.Parameter(2)
  public int upper ;

  @Parameterized.Parameter(3)
  public int expectedResult;

  @Test
  public void test() {
    CountRangeSum testTarget = new CountRangeSum();
    int actual = testTarget.countRangeSum(nums, lower, upper);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {7, 6, 5, 4, 3, 2, 1},
            1,
            7,
            11
        },
        {
          new int[] {-2, 5, -1},
          -2,
          2,
          3
        },
    });
  }
}
