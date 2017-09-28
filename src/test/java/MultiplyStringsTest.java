import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MultiplyStringsTest {
  @Parameterized.Parameter
  public String num1;

  @Parameterized.Parameter(1)
  public String num2;

  @Parameterized.Parameter(2)
  public String expectedResult;

  @Test
  public void test() {
    MultiplyStrings testTarget = new MultiplyStrings();
    String actual = testTarget.multiply(num1, num2);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          "254", "39", "9906"
        },
    });
  }
}
