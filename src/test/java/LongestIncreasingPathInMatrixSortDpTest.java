import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestIncreasingPathInMatrixSortDpTest {
  @Parameterized.Parameter
  public int[][] matrix ;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test_SortDp() {
    LongestIncreasingPathInMatrix_SortDp testTarget = new LongestIncreasingPathInMatrix_SortDp();
    int actual = testTarget.longestIncreasingPath(matrix);
    assertEquals(expectedResult, actual);
  }

  @Test
  public void test_DfsDp() {
    LongestIncreasingPathInMatrix_DfsDp testTarget = new LongestIncreasingPathInMatrix_DfsDp();
    int actual = testTarget.longestIncreasingPath(matrix);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[][] {{9,9,4}, {6,6,8} , {2,1,1}},
          4
        },
    });
  }
}
