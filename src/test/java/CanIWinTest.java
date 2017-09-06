import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CanIWinTest {
  @Parameterized.Parameter
  public int maxChhosableInteger;

  @Parameterized.Parameter(1)
  public int desiredTotal;

  @Parameterized.Parameter(2)
  public boolean expectedResult;

  @Test
  public void test() {
    CanIWin testTarget = new CanIWin();
    boolean actual = testTarget.canIWin(maxChhosableInteger, desiredTotal);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          10,
          40,
          false
        },
        {
            8, 25,
            false
        },
        {
          10, 11,
          false
        },
    });
  }
}

