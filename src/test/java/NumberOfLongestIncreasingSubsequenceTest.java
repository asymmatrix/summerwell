import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberOfLongestIncreasingSubsequenceTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    NumberOfLongestIncreasingSubsequence testTarget = new NumberOfLongestIncreasingSubsequence();
    int actual = testTarget.findNumberOfLIS(nums);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {1,2,4,3,5,4,7,2},
          3
        },
        {
          new int[] {1,3,5,4,7},
          2
        },
    });
  }
}
