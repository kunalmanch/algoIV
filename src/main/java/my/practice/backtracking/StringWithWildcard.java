package my.practice.backtracking;

/**
 * A string consists of ‘0’, ‘1’ and '?'.
 * The question mark can be either '0' or '1'. Find all possible combinations for a string.
 */
public class StringWithWildcard {

    public static void printAllCombos(String s) {
        helper(s, new char[s.length()], 0);
    }

    private static void helper(String  s, char[] c, int idx) {
        if (idx == s.length()) {
            System.err.println(new String(c));
        } else if (idx < s.length()) {
            if (s.charAt(idx) == '?') {
                c[idx] = '1';
                helper(s, c, idx + 1);
                c[idx] = '0';
                helper(s, c, idx + 1);
            } else {
                c[idx] = s.charAt(idx);
                helper(s, c, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        printAllCombos("01???");
    }
}
