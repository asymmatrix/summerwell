import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveInvalidParenthesesTest {

  @Parameterized.Parameter
  public String input;

  @Parameterized.Parameter(1)
  public List<String> expectedResult;

  @Test
  public void testDP() {
    RemoveInvalidParenthesesDp testTarget = new RemoveInvalidParenthesesDp();
    List<String> actual = testTarget.removeInvalidParentheses(input);
    actual.sort(null);
    expectedResult.sort(null);
    assertEquals(expectedResult, actual);
  }

  @Test
  public void test() {
    RemoveInvalidParentheses testTarget = new RemoveInvalidParentheses();
    List<String> actual = testTarget.removeInvalidParentheses(input);
    actual.sort(null);
    expectedResult.sort(null);
    assertEquals(expectedResult, actual);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
          ")()(",
          Arrays.asList("()")
        },
        {
            ")f(",
            Arrays.asList("f")
        },
        {
            ")()())A)",
            Arrays.asList("()()A", "(())A", "(()A)", "()(A)")
        },
        {
            "(r(()()(",
            Arrays.asList("r()()","r(())","(r)()","(r())")
        },
        {
            ")(",
            Arrays.asList("")
        },
        {
            "x(",
            Arrays.asList("x"),
        },
        {
          "()())()",
          Arrays.asList("()()()", "(())()"),
        },
        {
          "(a)())()",
          Arrays.asList("(a)()()", "(a())()")
        },
        {
            ")))))))))))))",
            Arrays.asList("")
        },
        {
          "n",
          Arrays.asList("n")
        }
    });
  }
}
