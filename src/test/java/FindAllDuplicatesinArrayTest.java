import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindAllDuplicatesinArrayTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public Integer[] expectedResult;

  @Test
  public void test() {
    FindAllDuplicatesinArray testTarget = new FindAllDuplicatesinArray();
    List<Integer> actualResult = testTarget.findDuplicates(input);
    assertArrayEquals(expectedResult, actualResult.toArray(new Integer[actualResult.size()]));
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[] {2, 2},
            new Integer[] {2}
        },
        {
            new int[] {1, 2, 4, 5, 3},
            new Integer[] {}
        },
        {
            new int[] {4, 3, 2, 7, 8, 2, 3, 1},
            new Integer[] {2, 3}
        }
    });
  }
}
