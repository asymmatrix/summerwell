import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EliminationGameTest {

  @Parameterized.Parameter
  public int input;

  @Parameterized.Parameter(1)
  public int expectedResult;

  @Test
  public void test() {
    EliminationGame testTarget = new EliminationGame();
    int actual = testTarget.lastRemaining(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            1, 1
        },
        {
            2, 2
        },
        {
            3, 2
        },
        {
            4, 2
        },
        {
            5, 2
        },
        {
            6, 4
        },
        {
            7, 4
        },
        {
            8, 6
        },
        {
            9, 6
        },
    });
  }
}
