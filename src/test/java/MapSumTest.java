import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class MapSumTest {

  @Test
  public void test() {
    MapSum mapSum = new MapSum();
    mapSum.insert("apple", 3);
    assertEquals(mapSum.sum("ap"), 3);
    mapSum.insert("app", 2);
    assertEquals(mapSum.sum("ap"), 5);
    assertEquals(mapSum.sum(""), 5);
  }
}
