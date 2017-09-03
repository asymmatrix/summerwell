import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PacificAtlanticWaterFlowTest {
  @Parameterized.Parameter
  public int[][] matrix;

  @Parameterized.Parameter(1)
  public List<int[]> expectedResult;

  @Test
  public void test() {
    PacificAtlanticWaterFlow testTarget = new PacificAtlanticWaterFlow();
    List<int[]> actual = testTarget.pacificAtlantic(matrix);
    assertArrayEquals(expectedResult.toArray(), actual.toArray());
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[][] {{1,1}, {1, 1}, {1, 1}},
            Arrays.asList(new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}})
        },
        {
          new int[][] {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}},
          Arrays.asList(new int[][] {{0, 4}, {1, 3}, {1, 4}, {2, 2}, {3, 0}, {3, 1}, {4, 0}})
        },
    });
  }
}
