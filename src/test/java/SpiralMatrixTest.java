import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SpiralMatrixTest {
  @Parameterized.Parameter
  public int[][] matrix;

  @Parameterized.Parameter(1)
  public int[] expectedResult;

  @Test
  public void test() {
    SpiralMatrix testTarget = new SpiralMatrix();
    List<Integer> actual = testTarget.spiralOrder(matrix);

    int[] actualArray = actual.stream().mapToInt(i->i).toArray();
    assertArrayEquals(expectedResult, actualArray);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          new int[][] {{1,2,3}, {4,5,6}, {7,8,9}},
          new int[] {1,2,3,6,9,8,7,4,5}
        },
    });
  }
}
