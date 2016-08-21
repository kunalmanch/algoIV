package my.practice.strings;

/**
 * Created by kmishra on 8/17/2016.
 */
public class LongestCommonPrefix {

    public static String lcp(String[] a) {
        int minIdx = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() < minLen) {
                minLen = a[i].length();
                minIdx = i;
            }
        }

        int matchEndIdx = a[minIdx].length() - 1;
        int idx = 0;
        while (minIdx == idx) {
            idx++;
        }

        for (int i = 0; i < a[minIdx].length(); i++) {
            if (a[minIdx].charAt(i) != a[idx].charAt(i)) {
                matchEndIdx = i;
                break;
            }
        }

        return a[minIdx].substring(0, matchEndIdx);
    }

    public static void main(String[] args) {
        String[] strings = {"abaa", "abc", "abbaa"};
        System.err.println(lcp(strings));
        int m = (1&0xffffffff);
        int n = (2<<m);
        System.err.println(n);
    }
}
