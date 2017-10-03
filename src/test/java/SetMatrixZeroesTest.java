import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SetMatrixZeroesTest {
  @Parameterized.Parameter
  public int[][] matrix;

  @Parameterized.Parameter(1)
  public int[][] expectedResult;

  @Test
  public void test() {
    SetMatrixZeroes testTarget = new SetMatrixZeroes();
    testTarget.setZeroes(matrix);
    assertArrayEquals(expectedResult, matrix);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            new int[][] {{1,2,3,4}, {5,0,5,2}, {8,9,2,0}, {5,7,2,1}},
            new int[][] {{1,0,3,0}, {0,0,0,0}, {0,0,0,0}, {5,0,2,0}}
        },
        {
          new int[][] {{0,0,0,5}, {4,3,1,4}, {0,1,1,4}, {1,2,1,3}, {0,0,1,1}},
          new int[][] {{0,0,0,0}, {0 ,0 ,0, 4}, {0,0,0,0}, {0,0,0,3}, {0,0,0,0}}
        },
    });
  }
}
