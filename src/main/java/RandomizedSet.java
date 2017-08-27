import java.util.ArrayList;
import java.util.HashMap;


/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {
  private HashMap<Integer, Integer> location = new HashMap<>();
  private ArrayList<Integer> array = new ArrayList<>();
  private java.util.Random rand = new java.util.Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (location.containsKey(val)) return false;
    array.add(val);
    location.put(val, array.size() - 1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!location.containsKey(val)) {
      return false;
    }

    // swap with the last element in the array
    int index = location.get(val);
    int lastIndex = array.size() - 1;
    if (index != lastIndex) {
      int lastValue = array.get(lastIndex);
      location.put(lastValue, index);
      array.set(index, lastValue);
    }

    // remove last element
    array.remove(lastIndex);
    location.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int i = rand.nextInt(array.size());
    return array.get(i);
  }
}
