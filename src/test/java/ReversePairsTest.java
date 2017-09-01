import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReversePairsTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    ReversePairs testTarget = new ReversePairs();
    int actual = testTarget.reversePairs(nums);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {4, 3, 2, 1},
          2
        },
        {
          new int[] {1, 2, 3, 4, 3, 2, 1},
          3
        },
        {
          new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647},
            0
        }
    });
  }
}
