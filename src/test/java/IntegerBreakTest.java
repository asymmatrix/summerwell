import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IntegerBreakTest {
  @Parameterized.Parameter
  public int input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    IntegerBreak testTarget = new IntegerBreak();
    int actual = testTarget.integerBreak(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        { 2, 1 },
        { 10, 36},
    });
  }
}
