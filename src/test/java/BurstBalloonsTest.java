import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurstBalloonsTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    BurstBalloons testTarget = new BurstBalloons();
    int actual = testTarget.maxCoins(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {3, 1, 5, 8},
            167
        },
        {
            new int[] {3},
            3
        },
        {
            new int[] {3, 2},
            9
        },
        {
            new int[] {3, 1, 5},
            35
        },
    });
  }
}
