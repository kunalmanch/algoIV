package my.practice.strings;

/**
 * Find a min substring that contains target string.
 */
public class StringWindow {

    public static String minSubstring(String s, String t) {
        char[] needsToFind = new char[256];
        char[] hasToFind = new char[256];

        for (int i = 0; i < t.length(); i++) {
            needsToFind[t.charAt(i)]++;
        }

        int minLen = Integer.MAX_VALUE,
                minBegin = -1,
                minEnd = -1,
                count = 0;
        for (int begin = 0, end = 0; end < s.length(); end++) {
            if (needsToFind[s.charAt(end)] == 0) continue;
            hasToFind[s.charAt(end)]++;
            if (hasToFind[s.charAt(end)] <= needsToFind[s.charAt(end)]) {
                count++;
            }

            if (count == t.length()) {
                while (begin < needsToFind.length &&
                        (needsToFind[s.charAt(begin)] == 0 || hasToFind[s.charAt(begin)] > needsToFind[s.charAt(begin)])) {
                    if (hasToFind[s.charAt(begin)] > needsToFind[s.charAt(begin)]) {
                        hasToFind[s.charAt(begin)]--;
                    }
                    begin++;
                }
                if (begin > end || end - begin + 1 > t.length()) continue;
                if (end - begin + 1 < minLen) {
                    minLen = end - begin + 1;
                    minBegin = begin;
                    minEnd = end;
                }
            }
        }

        return minBegin != -1 ? s.substring(minBegin, minEnd + 1) : null;
    }

    public static void main(String[] args) {
        System.err.println(minSubstring("ADOBECODEBANC", "ABC"));
    }
}
