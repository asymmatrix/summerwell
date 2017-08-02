import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AdditiveNumberTest {
  @Parameter
  public String num;

  @Parameter(1)
  public boolean expectedResult;

  @Test
  public void test() {
    AdditiveNumber testTarget = new AdditiveNumber();
    boolean actualResult = testTarget.isAdditiveNumber(num);
    assertEquals(expectedResult, actualResult);
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {
        "101",
        true
      },
      {
        "1",
        false
      },
      {
        "11",
        false
      },
      {
        "0235813",
        false
      },
      {
        "1203",
        false
      },
      {
          "123",
          true
      },
      {
          "123581321",
          true
      },
      {
          "199100199",
          true
      },
      {
          "1000000000000000",
          false
      },
    });
  }
}
