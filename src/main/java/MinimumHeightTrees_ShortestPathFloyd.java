import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees_ShortestPathFloyd {
  private final int unreachable_dist = -100;
  private final int no_middle_point = -1;

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    int[][] dist = new int[n][n];
    int[][] midPoint = new int[n][n];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        }
        else {
          dist[i][j] = unreachable_dist;
        }
        midPoint[i][j] = no_middle_point;
      }

    for(int[] edge : edges) {
      dist[edge[0]][edge[1]] = 1;
      dist[edge[1]][edge[0]] = 1;
    }

    for(int k = 0; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
          if (dist[i][k] != unreachable_dist &&
              dist[k][j] != unreachable_dist &&
              (dist[i][j] == unreachable_dist || dist[i][k] + dist[k][j] < dist[i][j])) {
            dist[i][j] = dist[i][k] + dist[k][j];
            midPoint[i][j] = k;
          }
        }

    int longestDist = 0;
    int longestStart = 0, longestEnd = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++){
        if (dist[i][j] != unreachable_dist) {
          if (dist[i][j] > longestDist) {
            longestDist = dist[i][j];
            longestStart = i;
            longestEnd = j;
          }
        }
      }

    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      if (dist[longestStart][i] == longestDist / 2               && dist[i][longestEnd] == longestDist - longestDist / 2 ||
          dist[longestStart][i] == longestDist - longestDist / 2 && dist[i][longestEnd] == longestDist / 2) {
        set.add(i);
      }
    }

    List<Integer> answer = new ArrayList<>();
    answer.addAll(set);
    return answer;
  }
}