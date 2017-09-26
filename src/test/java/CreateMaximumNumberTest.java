import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CreateMaximumNumberTest {
  @Parameterized.Parameter
  public int[] nums1;

  @Parameterized.Parameter(1)
  public int[] nums2;

  @Parameterized.Parameter(2)
  public int k;

  @Parameterized.Parameter(3)
  public int[] expectedResult;

  @Test
  public void test() {
    CreateMaximumNumber testTarget = new CreateMaximumNumber();
    int[] actual = testTarget.maxNumber(nums1, nums2, k);
    assertArrayEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{

        {
            new int [] {6, 7},
            new int [] {6, 0 ,4},
            5,
            new int[] {6,7,6,0,4}
        },

        {
          new int [] {3,4,6,5},
          new int [] {9,1,2,5,8,3},
          5,
          new int[] {9,8,6,5,3}
        },
    });
  }
}
