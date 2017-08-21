import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HIndexIITest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    HIndexII testTarget = new HIndexII();
    int actual = testTarget.hIndex(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {
        new int[] {0},
        0
      },
      {
        new int[] {10},
        1
      },
      {
        new int[] {10, 20},
        2
      },
      {
        new int[] {0, 1, 2, 3, 4, 5},
        3
      },
      {
        new int[] {10, 11, 12, 13, 14, 15},
        6
      },
    });
  }
}
