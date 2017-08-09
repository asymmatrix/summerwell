import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PerfectSquaresTest {
  @Parameterized.Parameter
  public int input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    PerfectSquares testTarget = new PerfectSquares();
    int actual = testTarget.numSquares(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {12, 3},
        {13, 2},
        {48, 3},
        {1000, 2},
        {9999, 4},
        {99999, 4},
        {999999, 4},
    });
  }
}
