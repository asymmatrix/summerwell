import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindBstLeavesTest {
  @Parameterized.Parameter
  public int[] input;

  @Parameterized.Parameter(1)
  public int[] expectedResult;

  @Test
  public void test() {
    FindBstLeaves testTarget = new FindBstLeaves();
    int[] actualResult = testTarget.findLeavesWithStack(input);
    assertArrayEquals(expectedResult, actualResult);
    actualResult = testTarget.findLeavesRecursively(input);
    assertArrayEquals(expectedResult, actualResult);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            null,
            new int[] {}
        },
        {
            new int[] {},
            new int[] {}
        },
        {
            new int[] {5},
            new int[] {5}
        },
        {
            new int[] {5, 3},
            new int[] {3}
        },
        {
            new int[] {5, 10},
            new int[] {10}
        },
        {
            new int[] {5, 3, 2, 4, 8, 7, 9},
            new int[] {2, 4, 7, 9}
        },
        {
            new int[] {10, 5, 2, 20, 30, 25, 24, 28, 26, 29, 40, 50, 60, 70},
            new int[] {2, 24, 26, 29, 70}
        },
        {
            new int[] {5, 4, 3, 2, 1},
            new int[] {1}
        },
        {
            new int[] {1, 2, 3, 4, 5},
            new int[] {5}
        },
        {
            new int[] {10, 5, 8, 7, 20},
            new int[] {7, 20}
        },
    });
  }
}
