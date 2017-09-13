import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IncreasingSubsequencesTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    IncreasingSubsequences testTarget = new IncreasingSubsequences();
    List<List<Integer>> actual = testTarget.findSubsequences(nums);
    assertEquals(expectedResult, actual.size());
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {3, 2, 1, 3, 4},
          9
        },
    });
  }
}
