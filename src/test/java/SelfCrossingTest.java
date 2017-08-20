import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SelfCrossingTest {
  @Parameterized.Parameter
  public int[] steps;

  @Parameterized.Parameter(1)
  public boolean expectedResult;

  @Test
  public void test() {
    SelfCrossing testTarget = new SelfCrossing();
    boolean actual = testTarget.isSelfCrossing(steps);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {2, 1, 1, 2},
            true
        },
        {
            new int[] {1, 2, 3, 4},
            false
        },
        {
            new int[] {1, 1, 1, 1},
            true
        },
        {
            new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            false
        },
        {
            new int[] {10, 9, 8, 7, 6, 5, 4 ,3, 2, 1},
            false
        },
        {
            new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 10, 9, 8, 7, 6, 5, 4 ,3, 2, 1},
            false
        }
    });
  }
}
