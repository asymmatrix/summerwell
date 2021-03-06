import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DecodeStringTest {
  @Parameterized.Parameter
  public String input;

  @Parameterized.Parameter(1)
  public String expectedResult;

  @Test
  public void test() {
    DecodeString testTarget = new DecodeString();
    String actual = testTarget.decodeString(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            "3[a]2[bc]",
            "aaabcbc"
        },
        {
            "3[a2[c]]",
            "accaccacc"
        },
        {
          "2[abc]3[cd]ef",
          "abcabccdcdcdef"
        }
    });
  }
}
