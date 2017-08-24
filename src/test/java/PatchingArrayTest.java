import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PatchingArrayTest {
  @Parameterized.Parameter
  public int[] nums ;

  @Parameterized.Parameter(1)
  public int n;

  @Parameterized.Parameter(2)
  public int expectedResult;

  @Test
  public void test() {
    PatchingArray testTarget = new PatchingArray();
    int actual = testTarget.minPatches(nums, n);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {
        new int[] {1, 2, 31, 33},
        2147483647,
        28
      },
      {
          new int[] {},
          7,
          3
      },
      {
        new int[] {1, 3},
        6,
        1
      },
      {
        new int[] {1, 5, 10},
        20,
        2
      },
      {
        new int[] {1, 2, 2},
        5,
        0
      },
    });
  }
}
