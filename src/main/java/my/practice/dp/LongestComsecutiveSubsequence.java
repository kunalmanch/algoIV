package my.practice.dp;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the longest consecutive subsequence in an array.
 */
public class LongestComsecutiveSubsequence {

    int a, b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongestComsecutiveSubsequence that = (LongestComsecutiveSubsequence) o;

        return a == that.a;

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        hash = prime * hash + a;
        hash = prime * hash + b;
        return hash;
    }

    public static int lcs(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);

        int max = 0;
        for (int i : a) {
            int l = i - 1;
            int r = i + 1;
            int count = 1;
            while (set.contains(l)) {
                max = Math.max(max, ++count);
                set.remove(l);
                l--;
            }

            while (set.contains(r)) {
                max = Math.max(max, ++count);
                set.remove(r);
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {2,1,6,3,7,4};
        System.err.println(lcs(a));
    }
}
