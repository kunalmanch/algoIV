package my.practice.strings;

/**
 * Given a string, find if it contains an anagram of a smaller string.
 */
public class ContainsAnagram {

    public static boolean containsAnagram(String s, String p) {
        int[] needsToFind = new int[256];
        int[] hasFound = new int[256];
        int minP = Integer.MAX_VALUE, maxP = Integer.MIN_VALUE;
        int pSet = 0;
        for (int i = 0; i < p.length(); i++) {
            if (needsToFind[p.charAt(i)] == 0) {
                pSet++;
            }
            needsToFind[p.charAt(i)]++;
            minP = Math.min(p.charAt(i), minP);
            maxP = Math.max(p.charAt(i), maxP);
        }
        for (int begin = 0, end = 0, sSet = 0; end < s.length(); end++) {
            if (hasFound[s.charAt(end)] == 0) {
                sSet++;
            }
            hasFound[s.charAt(end)]++;
            if (sSet == pSet) {
                if (canFormAnagram(needsToFind, hasFound, minP, maxP)) return true;
                while (needsToFind[s.charAt(begin)] == 0 || hasFound[s.charAt(begin)] > needsToFind[s.charAt(begin)]) {
                    if (hasFound[s.charAt(begin)] > needsToFind[s.charAt(begin)]) {
                        hasFound[s.charAt(begin)]--;
                    }
                    if (hasFound[s.charAt(begin)] == 0 && sSet > 0) {
                        sSet--;
                    }
                    begin++;
                }
            }
        }
        return false;
    }

    private static boolean canFormAnagram(int[] needsToFind, int[] hasFound, int minP, int maxP) {
        for (int i = minP; i <= maxP; i++) {
            if (needsToFind[i] != hasFound[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(containsAnagram("abcd", "cbc"));
    }
}
