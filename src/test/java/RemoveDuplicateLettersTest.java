import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveDuplicateLettersTest {
  @Parameterized.Parameter
  public String input;

  @Parameterized.Parameter(1)
  public String expectedResult;

  @Test
  public void test() {
    RemoveDuplicateLetters testTarget = new RemoveDuplicateLetters();
    String actual = testTarget.removeDuplicateLetters(input);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            "a",
            "a"
        },
        {
            "bcabc",
            "abc"
        },
        {
            "cbacdcbc",
            "acdb"
        },
        {
            "cbabc",
            "abc"
        },
    });
  }
}
