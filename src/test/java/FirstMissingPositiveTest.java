import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FirstMissingPositiveTest {
  @Parameterized.Parameter
  public int[] nums;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    FirstMissingPositive testTarget = new FirstMissingPositive();
    int actual = testTarget.firstMissingPositive(nums);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {1, 1},
            2
        },
        {
            new int[] {},
            1
        },
        {
          new int[] {1, 2, 0},
          3
        },
        {
          new int[] {-1, 1, 0, -2, 9, 3, 2, 10},
          4
        },
        {
          new int[] {1, 2, 3, 4, 5},
          6
        },
    });
  }
}
