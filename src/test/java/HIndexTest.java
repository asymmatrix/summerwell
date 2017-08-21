import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HIndexTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    HIndex testTarget = new HIndex();
    int actual = testTarget.hIndex(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {8, 0, 1, 0, 3, 0, 6, 1, 7, 10, 6, 1, 5},
            5
        },
        {
            new int[] {0, 100, 1, 88, 0, 77, 66, 4},
            4
        },
        {
            new int[] {3},
            1
        },
        {
            new int[] {0},
            0
        },
        {
            new int[] {3, 0, 6, 1, 5},
            3
        },
        {
            new int[] {9, 8, 7, 6, 5},
            5
        },
    });
  }
}
