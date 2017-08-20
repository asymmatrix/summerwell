/**
 * https://leetcode.com/problems/self-crossing/
 */
public class SelfCrossing {
  public boolean isSelfCrossing(int[] x) {
    Position pos = new Position(0, 0);
    Boundary boundary = new Boundary();
    Boundary secondBoundary = new Boundary();
    NextMove move = firstMove(x, pos, boundary);
    do {
      if (move.dir == Direction.Inner) {
        move = moveInner(x, move.startIndex, boundary, pos);
      }
      else if (move.dir == Direction.Outer) {
        move = moveOuter(x, move.startIndex, boundary, secondBoundary, pos);
      } else {
        break;
      }
    } while (move.startIndex < x.length);

    return move.dir == Direction.Stopped_Cross;
  }

  private enum Direction {
    Stopped_NoCross,
    Stopped_Cross,
    Outer,
    Inner
  }

  private class Boundary {
    int north, west, south, east;
    Boundary() { this.north = this.west = this.south = this.east = 0; }
    void set (int north, int west, int south, int east) {
      this.north = north;
      this.west = west;
      this.south = south;
      this.east = east;
    }
  }

  private class Position {
    int x, y;
    Position(int x, int y) {this.x = x; this.y = y;}
  }

  private class NextMove {
    Direction dir;
    int startIndex;

    NextMove(Direction dir, int startIndex) {
      this.dir = dir;
      this.startIndex = startIndex;
    }
  }

  private NextMove firstMove(int[] steps, Position position, Boundary boundary) {
    if (steps.length < 4) return new NextMove(Direction.Stopped_NoCross, steps.length);

    position.x = steps[3] - steps[1];
    position.y = steps[0] - steps[2];

    if (steps[2] <= steps[0]) {
      if (steps[3] >= steps[1]) return new NextMove(Direction.Stopped_Cross, steps.length);
      else {
        boundary.set(steps[0], -steps[1], steps[0] - steps[2], steps[3] - steps[1]);
        return new NextMove(Direction.Inner, 4);
      }
    } else {
      if (steps[3] < steps[1]) {
        boundary.set(steps[0], -steps[1], steps[0] - steps[2], steps[3] - steps[1]);
        return new NextMove(Direction.Inner, 4);
      }
      else if (steps[3] > steps[1]) {
        boundary.set(steps[0], -steps[1], steps[0] - steps[2], steps[3] - steps[1]);
        return new NextMove(Direction.Outer, 4);
      }
      else {
        boundary.set(0, -steps[1], steps[0] - steps[2], 0);
        return new NextMove(Direction.Inner, 4);
      }
    }
  }

  private NextMove moveInner(int[] steps, int startStepIndex, Boundary boundary, Position position) {
    for(int i = startStepIndex; i < steps.length; i++) {
      if (i % 4  == 0) {
        // NORTH
        position.y += steps[i];
        if (position.y >= boundary.north) return new NextMove(Direction.Stopped_Cross, i + 1);
        else boundary.north = position.y;
      } else  if (i % 4  == 1) {
        // WEST
        position.x -= steps[i];
        if (position.x <= boundary.west) return new NextMove(Direction.Stopped_Cross, i + 1);
        else boundary.west = position.x;
      } else if (i % 4 == 2) {
        // SOUTH
        position.y -= steps[i];
        if (position.y <= boundary.south) return new NextMove(Direction.Stopped_Cross, i + 1);
        else boundary.south = position.y;
      } else {
        // EAST
        position.x += steps[i];
        if (position.x >= boundary.east) return new NextMove(Direction.Stopped_Cross, i + 1);
        else boundary.east = position.x;
      }
    }

    return new NextMove(Direction.Stopped_NoCross, steps.length);
  }

  private NextMove moveOuter(int[] steps, int startStepIndex, Boundary boundary, Boundary secondBoundary, Position position) {
    for (int i = startStepIndex; i < steps.length; i++) {
      if (i % 4  == 0) {
        // NORTH
        position.y += steps[i];

        if (position.y > boundary.north) {
          secondBoundary.north = boundary.north;
          boundary.north = position.y;
        } else {
          if (position.y >= secondBoundary.south) {
            boundary.set(position.y, secondBoundary.east, boundary.south, boundary.east);
          } else {
            boundary.set(position.y, boundary.west, boundary.south, boundary.east);
          }
          return new NextMove(Direction.Inner, i + 1);
        }

      } else  if (i % 4  == 1) {
        // WEST
        position.x -= steps[i];
        if (position.x < boundary.west) {
          secondBoundary.west = boundary.west;
          boundary.west = position.x;
        } else {
          if (position.x <= secondBoundary.east) {
            boundary.set(boundary.north, position.x, secondBoundary.north, boundary.east);
          } else {
            boundary.set(boundary.north, position.x, boundary.south, boundary.east);
          }
          return new NextMove(Direction.Inner, i + 1);
        }
      } else if (i % 4 == 2) {
        // SOUTH
        position.y -= steps[i];

        if (position.y < boundary.south) {
          secondBoundary.south = boundary.south;
          boundary.south = position.y;
        } else {
          if (position.y <= secondBoundary.north) {
            boundary.set(boundary.north, boundary.west, position.y, secondBoundary.west);
          } else {
            boundary.set(boundary.north, boundary.west, position.y, boundary.east);
          }
          return new NextMove(Direction.Inner, i + 1);
        }
      } else {
        // EAST
        position.x += steps[i];

        if (position.x > boundary.east) {
          secondBoundary.east = boundary.east;
          boundary.east = position.x;
        } else {
          if (position.x >= secondBoundary.west) {
            boundary.set(secondBoundary.south, boundary.west, boundary.south, position.x);
          } else {
            boundary.set(boundary.north, boundary.west, boundary.south, position.x);
          }
          return new NextMove(Direction.Inner, i + 1);
        }
      }
    }

    return new NextMove(Direction.Stopped_NoCross, steps.length);
  }
}
