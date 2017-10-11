import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MedianOfTwoSortedArraysTest {
  @Parameterized.Parameter
  public int[] num1;

  @Parameterized.Parameter(1)
  public int[] num2;

  @Parameterized.Parameter(2)
  public int expectedResult;

  @Test
  public void test() {
    MedianOfTwoSortedArrays testTarget = new MedianOfTwoSortedArrays();
    int actual = testTarget.findKth(num1, num2, 5);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {1, 3, 5, 7},
          new int[] {2, 4, 6, 8, 10},
          5
        },
    });
  }
}
