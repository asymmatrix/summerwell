import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StrangePrinterTest {
  @Parameterized.Parameter
  public String input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    StrangePrinter testTarget = new StrangePrinter();
    int actual = testTarget.strangePrinter(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          "aaabbb",
           2
        }
    });
  }
}
