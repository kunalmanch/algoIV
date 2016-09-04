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

    public static void threeSum(int[] a, int t) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                int sum  = a[i] + a[j] + a[k];
                if (sum == t) {
                    System.err.println(t + " = " + a[i] + " + " + a[j] + " + " + a[k]);
                }
                if (sum < t) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        twoSum(a, 5);
        System.err.println(closesTwoSum(a, 6));
        int[] b = {2, 3, 1, -2, -1, 0, 2, -3, 0};
        threeSum(b, 0);
    }
}
