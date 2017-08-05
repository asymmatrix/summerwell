import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Utf8ValidationTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public boolean expectedResult;

  @Test
  public void test() {
    Utf8Validation testTarget = new Utf8Validation();
    boolean actual = testTarget.validUtf8(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {230, 136, 145},
          true
        },
        {
            new int[] {'a'},
            true
        },
        {
            new int[] {197, 130, 1},
            true
        },
        {
            new int[] {235, 140, 4},
            false
        },
    });
  }
}
