import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximalRectangleTest {
    @Parameter
    public char[][] inputMatrix;

    @Parameter(1)
    public int expectedResult;

    @Test
    public void test() {
        MaximalRectangle testTarget = new MaximalRectangle();
        int actualResult = testTarget.maximalRectangle(inputMatrix);
        assertEquals(expectedResult, actualResult);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {
                new char[][] {
                    {'0'},
                },
                0
            },
            {
                new char[][] {
                    {'1'},
                },
                1
            },
            {
                new char[][] {
                    {'1'},
                    {'1'}
                },
                2
            },
            {
                new char[][] {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'},
                },
                6
            },
            {
                new char[][] {
                    {'1', '1', '1', '0', '0'},
                    {'0', '1', '1', '0', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                },
                10
            },
            {
                new char[][] {
                    {'1', '0', '0', '0', '0'},
                    {'0', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '1', '0', '0'},
                },
                8
            },
            {
                new char[][] {
                    {'0', '1', '0', '0', '0'},
                    {'0', '1', '0', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '0', '0', '0'},
                },
                5
            },
            {
                new char[][] {
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                },
                20
            },
        });
    }
}
