package my.practice.ds;

import java.util.*;

/**
 * Created by kmishra on 8/16/2016.
 */
public class RandomizedCollection {

    private Random rnd;
    private List<Integer> dataList;
    private Map<Integer, HashSet<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        rnd = new Random();
        dataList = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = false;
        HashSet<Integer> idxSet;
        if ((idxSet = map.get(val)) == null) {
            idxSet = new HashSet<>();
            map.put(val, idxSet);
            ret = true;
        }
        idxSet.add(dataList.size());
        dataList.add(val);
        return ret;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        HashSet<Integer> idxSet = map.get(val);
        int pos = idxSet.iterator().next();
        idxSet.remove(pos);
        if (idxSet.isEmpty()) map.remove(val);
        int last = dataList.get(dataList.size() - 1);
        dataList.set(pos, last);
        idxSet = map.get(last);
        if (idxSet != null) {
            idxSet.remove(dataList.size() - 1);
            idxSet.add(pos);
        }
        dataList.remove(dataList.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return dataList.get(rnd.nextInt(dataList.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.err.println(rc.insert(1));
        System.err.println(rc.remove(1));
        System.err.println(rc.insert(1));
    }
}
