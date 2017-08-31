import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FreedomTrailTest {
  @Parameterized.Parameter
  public String ring;

  @Parameterized.Parameter(1)
  public String key;

  @Parameterized.Parameter(2)
  public int expectedResult;

  @Test
  public void test() {
    FreedomTrail testTarget = new FreedomTrail();
    int actual = testTarget.findRotateSteps(ring, key);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{

        {
            "godding",
            "gig",
            8
        },

        {
          "godding",
          "gd",
          4
        },
    });
  }
}
