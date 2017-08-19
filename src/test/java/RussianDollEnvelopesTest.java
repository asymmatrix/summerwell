import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RussianDollEnvelopesTest {
  @Parameterized.Parameter
  public int[][] input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    RussianDollEnvelopes testTarget = new RussianDollEnvelopes();
    int actual = testTarget.maxEnvelopes(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[][] { {5  , 4}, {6, 4}, {6, 7}, {2, 3} },
          3
        },
        {
            new int[][] { {4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1} },
            4
        },
        {
            new int[][] { {2,100}, {3,200}, {4,300}, {5,500}, {5,400}, {5,250}, {6,370}, {6,360}, {7,380} },
            5
        },
    });
  }
}
