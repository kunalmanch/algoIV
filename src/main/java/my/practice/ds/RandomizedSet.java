package my.practice.ds;

import java.util.*;
import java.util.Random;

/**
 * Created by kmishra on 8/16/2016.
 */
public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(pos, last);
        map.put(last, pos);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
