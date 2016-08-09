package my.practice.strings;

/**
 * Find a min substring that contains target string.
 */
public class StringWindow {

    public static String minSubstring(String s, String t) {
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];

        for (int i = 0; i < t.length(); i++) {
            needToFind[t.charAt(i)]++;
        }
        int count = 0,
                minBegin = -1,
                minEnd = -1,
                minLen = Integer.MAX_VALUE;
        for (int begin = 0, end = 0; end < s.length(); end++) {

            if (needToFind[s.charAt(end)] == 0) continue;
            hasFound[s.charAt(end)]++;
            if (hasFound[s.charAt(end)] <= needToFind[s.charAt(end)]) {
                count++;
            }

            if (count == t.length()) {
                while (needToFind[s.charAt(begin)] == 0 || hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
                    if (hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
                        hasFound[s.charAt(begin)]--;
                    }
                    begin++;
                }

                if (end - begin + 1 < minLen) {
                    minBegin = begin;
                    minEnd = end;
                    minLen = end - begin + 1;
                }
            }
        }
        return minBegin != -1 && minEnd != -1 ? s.substring(minBegin, minEnd + 1) : null;
    }

    public static void main(String[] args) {
        System.err.println(minSubstring("ADOBECODEBANC", "ABC"));
    }
}
