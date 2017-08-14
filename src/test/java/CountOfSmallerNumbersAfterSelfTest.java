import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountOfSmallerNumbersAfterSelfTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public List<Integer> expectedResult;

  @Test
  public void test() {
    CountOfSmallerNumbersAfterSelf testTarget = new CountOfSmallerNumbersAfterSelf();
    List<Integer> actual = testTarget.countSmaller(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {5,4,8,1,0,3,5},
            Arrays.asList(4,3,4,1,0,0,0)
        }
    });
  }
}
