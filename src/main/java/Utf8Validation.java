/**
 * https://leetcode.com/problems/utf-8-validation/
 */
public class Utf8Validation {
  public boolean validUtf8(int[] data) {
    if (data == null) return false;
    if (data.length == 0) return true;

    int currentPos = 0;
    while (currentPos < data.length) {
      int charLen = validLeadingByteAndGetCharLength(data[currentPos]);
      if (charLen <= 0) {
        return false;
      }

      if (!validFollowingBytes(data, currentPos + 1, charLen - 1)) {
        return false;
      }
      currentPos += charLen;
    }

    return true;
  }

  private int validLeadingByteAndGetCharLength(int leadingByte) {
    if (!isBitOn(leadingByte, 7)) {
      return 1;
    }

    int highestZeroBitPos = -1;
    for (int i = 6; i >=3; i--) {
      if (!isBitOn(leadingByte, i)) {
        highestZeroBitPos = i;
        break;
      }
    }

    if (highestZeroBitPos <= 5 && highestZeroBitPos >= 3) {
      return 7 - highestZeroBitPos;
    }

    return -1;
  }

  private boolean validFollowingBytes(int[] data, int start, int length) {
    if (length == 0) {
      return true;
    }

    if (start + length > data.length) {
      return false;
    }

    for (int i = start; i < start + length; i++) {
      if (!isFollowingByte(data[i])) {
        return false;
      }
    }
    return true;
  }

  private boolean isFollowingByte(int data) {
    return isBitOn(data, 7) && !isBitOn(data, 6);
  }

  private boolean isBitOn(int data, int bit) {
    return (data & (1 << bit)) == (1 << bit);
  }
}
