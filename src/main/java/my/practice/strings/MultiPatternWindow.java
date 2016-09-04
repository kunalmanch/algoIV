package my.practice.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the shortest window that contains three sub strings, t1/t2/t3
 * Solution complexity is O(n*k) where n = s.length and k = # occurrence of the patterns.
 */
public class MultiPatternWindow {

    private String t1, t2, t3;
    private List<Integer> t1Occurences, t2Occurences, t3Occurences;

    public MultiPatternWindow(String t1, String t2, String t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public int shortestWindow(String s) {
        t1Occurences = findOcuurences(s, t1);
        t2Occurences = findOcuurences(s, t2);
        t3Occurences = findOcuurences(s, t3);
        int largestT = Math.max(t1.length(), Math.max(t2.length(), t3.length()));
        int shortest = s.length();
        int minStart = -1 , minEnd = -1;
        for (int end = 0, begin = 0; end < s.length(); end++) {
            if (end - begin + 1 >= largestT) {
                int b = allPatternsContained(s, begin, end);
                if (b != -1) {
                    begin = b;
                    if (end - begin + 1 < shortest) {
                        shortest = end - begin + 1;
                        minStart = begin;
                        minEnd = end;
                    }
                }
            }
        }
        System.err.println("s : " + minStart + " e : " + minEnd);
        return shortest;
    }

    private static List<Integer> findOcuurences(String s, String t) {
        List<Integer> set = new ArrayList<>();
        int prev = 0;
        while (prev < s.length()) {
            int found = s.indexOf(t, prev);
            if (found == - 1) {
                break;
            }
            set.add(found);
            prev = found + t.length();
        }
        return set;
    }

    private int allPatternsContained(String s, int begin, int end) {
        Integer t1Idx = indexInRange(t1Occurences, t1, begin, end);
        Integer t2Idx = indexInRange(t2Occurences, t2, begin, end);
        Integer t3Idx = indexInRange(t3Occurences, t3, begin, end);
        return Math.min(Math.min(t1Idx, t2Idx), t3Idx);
    }

    private int indexInRange(List<Integer> tOccurences, String t, int begin, int end) {
        for (int i : tOccurences) {
            if (begin <= i && i + t.length() - 1 <= end) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "Mississippi";
        MultiPatternWindow obj = new MultiPatternWindow("is", "si", "ssi");
        System.err.println(obj.shortestWindow(s));
    }
}
