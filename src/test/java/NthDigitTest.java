import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NthDigitTest {
  @Parameterized.Parameter
  public int n;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    NthDigit testTarget = new NthDigit();
    int actual = testTarget.findNthDigit(n);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          3, 3
        },
        {
          11, 0
        },
        {
          9999, 7
        },
        {
          Integer.MAX_VALUE,
          2
        }
    });
  }
}
