package my.practice.backtracking;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParantheses {

    public static void generateParentheses(char[] a, int idx, int left, int right) {
        if (left < right) {
            return;
        }
        if (left == right && right == a.length / 2) {
            System.err.println(new String(a));
        } else if (idx < a.length) {
            if (left < a.length / 2) {
                a[idx] = '(';
                generateParentheses(a, idx + 1, left + 1, right);
            }
            if (right < a.length / 2) {
                a[idx] = ')';
                generateParentheses(a, idx + 1, left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(new char[n * 2], 0, 0, 0);
    }
}
