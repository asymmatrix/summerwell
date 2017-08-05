import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidPerfectSquareTest {
  @Parameterized.Parameter
  public int input;

  @Parameterized.Parameter(1)
  public boolean expectedResult;

  @Test
  public void test() {
    ValidPerfectSquare testTarget = new ValidPerfectSquare();
    boolean actual = testTarget.isPerfectSquare(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            2147483647, false
        },
        {
            -2147483648,
            false
        },
        {
            1, true
        },
        {
            2, false
        },
        {
            3, false
        },
        {
            4, true
        },
        {
            5, false
        },
        {
            6, false
        },
        {
            7, false
        },
        {
            8, false
        },
        {
            9, true
        }
    });
  }
}
