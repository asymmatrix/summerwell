import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */
public class RandomizedCollection {
  ArrayList<Integer> array = new ArrayList<>();
  HashMap<Integer, Set<Integer>> index = new HashMap<>();
  java.util.Random rand = new java.util.Random();

  /** Initialize your data structure here. */
  public RandomizedCollection() {
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    boolean hasIndex = index.containsKey(val);
    array.add(val);
    if (!hasIndex) {
      index.put(val, new LinkedHashSet<>());
    }
    index.get(val).add(array.size() - 1);
    return !hasIndex;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!index.containsKey(val) || index.get(val).size() == 0) {
      return false;
    }

    int indexToRemove = index.get(val).iterator().next();
    index.get(val).remove(indexToRemove);

    int lastIndex = array.size() - 1;

    if (indexToRemove != lastIndex) {
      int lastVal = array.get(lastIndex);
      index.get(lastVal).remove(lastIndex);
      index.get(lastVal).add(indexToRemove);
      array.set(indexToRemove, lastVal);
    }

    array.remove(lastIndex);

    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    int i = rand.nextInt(array.size());
    return array.get(i);
  }
}
