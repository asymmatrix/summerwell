import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BestTimeBuySellStockIIITest {
  @Parameterized.Parameter
  public int[] prices;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    BestTimeBuySellStockIII testTarget = new BestTimeBuySellStockIII();
    int actual = testTarget.maxProfit(prices);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {3, 3, 5, 0, 0, 3, 1, 4},
          6
        },
        {
            new int[] {1, 2},
            1
        },
        {
          new int[] {104, 30, 34, 6, 10, 5, 3, 12, 45, 90},
          91
        }
    });
  }
}
