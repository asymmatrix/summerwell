import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FrogJumpTest {
  @Parameterized.Parameter
  public int[] stones;

  @Parameterized.Parameter(1)
  public boolean expectedResult;

  @Test
  public void test() {
    FrogJump testTarget = new FrogJump();
    boolean actual = testTarget.canCross(stones);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {0,1,3,5,6,8,12,17},
            true
        },
        {
            new int[] {0,1,2,3,4,8,9,11},
            false
        },

    });
  }
}
