import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/perfect-rectangle/description/
 */
public class PerfectRectangle {
  private static final int iBLX = 0;
  private static final int iBLY = 1;
  private static final int iTRX = 2;
  private static final int iTRY = 3;

  private static final int iX[] = {iBLX, iTRX};
  private static final int iY[] = {iBLY, iTRY};


  public boolean isRectangleCover(int[][] rectangles) {
    int BLX_min = rectangles[0][iBLX];
    int BLY_min = rectangles[0][iBLY];
    int TRX_max = rectangles[0][iTRX];
    int TRY_max = rectangles[0][iTRY];

    Set<String> set = new HashSet<>();
    long totalArea = 0;

    for(int[] rect : rectangles) {
      BLX_min = Math.min(BLX_min, rect[iBLX]);
      BLY_min = Math.min(BLY_min, rect[iBLY]);
      TRX_max = Math.max(TRX_max, rect[iTRX]);
      TRY_max = Math.max(TRY_max, rect[iTRY]);

      totalArea += area(rect);

      for (int x: iX) {
        for (int y: iY) {
          String pointEncoding = encodePoint(rect[x], rect[y]);
          if (!set.add(pointEncoding)) set.remove(pointEncoding);
        }
      }
    }

    int[] boundingBox = new int[] {BLX_min, BLY_min, TRX_max, TRY_max};

    if (area(boundingBox) != totalArea) {
      return false;
    }

    for (int x: iX) {
      for (int y: iY) {
        String pointEncoding = encodePoint(boundingBox[x], boundingBox[y]);
        if (!set.contains(pointEncoding)) {
          return false;
        }
      }
    }

    return set.size() == 4;
  }

  private long area(int[] rect) {
    return (rect[iTRX] - rect[iBLX]) * (rect[iTRY] - rect[iBLY]);
  }

  private String encodePoint(Integer x, Integer y) {
    return x.toString() + ":" + y.toString();
  }
}
