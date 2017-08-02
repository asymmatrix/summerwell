import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SuperUglyNumberTest {
  @Parameter
  public int n;

  @Parameter(1)
  public int[] primes;

  @Parameter(2)
  public int expectedResult;

  @Test
  public void test() {
    SuperUglyNumber testTarget = new SuperUglyNumber();
    int actual = testTarget.nthSuperUglyNumber(this.n, this.primes);
    assertEquals(this.expectedResult, actual);
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          12,
          new int[] {2, 7, 13, 19},
          32
        },
        {
            1,
            new int[] {2, 7, 13, 19},
            1
        },
        {
            2,
            new int[] {2, 7, 13, 19},
            2
        },
        {
            3,
            new int[] {2, 7, 13, 19},
            4
        },
        {
            4,
            new int[] {2, 7, 13, 19},
            7
        },
        {
            5,
            new int[] {2, 7, 13, 19},
            8
        },
        {
            6,
            new int[] {2, 7, 13, 19},
            13
        },
        {
            7,
            new int[] {2, 7, 13, 19},
            14
        },
    });
  }
}
