package my.practice.backtracking;

import java.util.Map;

/**
 * Given a set of chars and a length k, create all possible letter combinations of length k.
 */
public class StringSetCombination {

    public static void combine(String set, int idx, char[] a) {
        if (idx == a.length) {
            System.err.println(new String(a));
        } else if (idx < a.length) {
            for (int i = 0; i < set.length(); i++) {
                a[idx] = set.charAt(i);
                combine(set, idx + 1, a);
            }
        }
    }

    /**
     * Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', and 'c',
     * where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's
     */
    public static int countStrings(int len, int bFreq, int cFreq, int idx) {
        int sum = 0;
        if (idx == len) {
            return  1;
        } else if (idx < len) {
            if (bFreq > 0) {
                sum += countStrings(len, bFreq - 1, cFreq, idx + 1);
            }
            if (cFreq > 0) {
                sum += countStrings(len, bFreq, cFreq - 1, idx + 1);
            }
            sum += countStrings(len, bFreq, cFreq, idx + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        combine("abc", 0, new char[3]);
        System.err.println(countStrings(3, 1, 2, 0));
    }
}
