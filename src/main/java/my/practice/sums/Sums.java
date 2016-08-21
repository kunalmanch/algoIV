package my.practice.sums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/18/2016.
 */
public class Sums {

    public static void twoSum(int[] a, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            if (set.contains(sum - i)) {
                System.err.println(sum + " = " + (sum - i) + " + " + i);
                break;
            } else {
                set.add(i);
            }
        }
    }

    public static int closesTwoSum(int[] a, int sum) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0, j = a.length - 1; i < j;) {
            int tSum = a[i] + a[j];
            if (sum == tSum) {
                minSum = tSum;
                break;
            }
            if (Math.abs(sum - tSum) < min) {
                min = Math.abs(sum - tSum);
                minSum = tSum;
            }
            if (tSum > sum) j--;
            else i++;
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        twoSum(a, 5);
        System.err.println(closesTwoSum(a, 6));
    }
}
