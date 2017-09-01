import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveBoxesTest {
  @Parameterized.Parameter
  public int[] boxes;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    RemoveBoxes testTarget = new RemoveBoxes();
    int actual = testTarget.removeBoxes(boxes);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[] {1,3,2,2,2,3,4,3,1},
          23
        },
    });
  }
}
