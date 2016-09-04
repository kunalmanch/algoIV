package my.practice.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Find longest sub-string with M distinct characters.
 */
public class LongestSubStringM {

    public static int longest(String s, int m) {
        int maxWindow = 0, maxBegin = 0, maxEnd = 0;
        int[] freq = new int[256];
        Set<Character> set = new HashSet<>();
        for (int begin = 0, end = 0; end < s.length(); end++) {
            set.add(s.charAt(end));
            freq[s.charAt(end)]++;

            while (set.size() > m) {
                if (freq[s.charAt(begin)] > 0) {
                    freq[s.charAt(begin)]--;
                }
                if (freq[s.charAt(begin)] == 0) {
                    set.remove(s.charAt(begin));
                }
                begin++;
            }

            if (set.size() == m && end - begin + 1 > maxWindow) {
                maxBegin = begin;
                maxEnd = end;
                maxWindow = end - begin + 1;
            }
        }
        System.err.println(s.substring(maxBegin, maxEnd + 1));
        return maxWindow;
    }

    /**
     *
     * @param s
     * @param k
     */
    public static int allKSubstrings(String s, int k) {
        int count = 0;
        int[] freq = new int[256];
        Set<Character> set = new HashSet<>();
        for (int begin = 0, end = 0; end < s.length(); end++) {
            set.add(s.charAt(end));
            freq[s.charAt(end)]++;

            while (set.size() > k) {
                if (freq[s.charAt(begin)] > 0) {
                    freq[s.charAt(begin)]--;
                }
                if (freq[s.charAt(begin)] == 0) {
                    set.remove(s.charAt(begin));
                }
                begin++;
            }

            if (set.size() == k) {
                count++;
                System.err.println(s.substring(begin, end + 1));
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int m = 3;
        System.err.println(longest(s, m));
        String t = "abc";
        System.err.println(allKSubstrings(t, 2));
    }
}
