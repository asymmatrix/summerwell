import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ArrayLongestCircleTest {
  @Parameter
  public int[] input;

  @Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    ArrayLongestCircle testTarget = new ArrayLongestCircle();
    int actualResult = testTarget.runWithDisjointSet(input);
    assertEquals(expectedResult, actualResult);
    actualResult = testTarget.runWithVisitedFlag(input);
    assertEquals(expectedResult, actualResult);
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {5, 4, 0, 3, 1, 6, 2},
          4
        },
        {
          new int[] {1, 2, 3, 4, 5, 6, 0},
          7
        },
        {
          new int[] {0, 1, 2, 3, 4, 5, 6},
          1
        },
    });
  }
}
