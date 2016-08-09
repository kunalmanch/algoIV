package my.practice.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/8/2016.
 */
public class Sum {

    public static void twoSum(int[] a, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            if (set.contains(sum - i)) {
                System.err.println(i + " and " + (sum - i));
            } else {
                set.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {10,2,3,12};
        twoSum(a, 5);
    }
}
