package my.practice.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/13/2016.
 */
public class LongestUniqueSubstring {

    public static int lus(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(c);
                j++;
                max = Math.max(max, j - i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abccdacb";
        System.err.println(lus(s));
    }
}
