import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IpoTest {
  @Parameterized.Parameter
  public int k;

  @Parameterized.Parameter(1)
  public int w;

  @Parameterized.Parameter(2)
  public int[] profits;

  @Parameterized.Parameter(3)
  public int[] capital;

  @Parameterized.Parameter(4)
  public int expectedResult;

  @Test
  public void test() {
    Ipo testTarget = new Ipo ();
    int actual = testTarget.findMaximizedCapital(k, w, profits, capital);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          2, 0,
          new int[] {1 ,2, 3},
            new int[] {0 ,1, 1},
            4
        },
    });
  }
}
