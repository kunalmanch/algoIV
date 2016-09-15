package my.practice.backtracking;

/**
 * print all subsets that sum up to n
 */
public class SumN {

    public static void nSum(int n, String s) {
        if (n == 0) {
            System.err.println(s);
        } else if (n > 0) {
            for (int j = 1; j <= n; j++) {
                nSum(n - j, s + " " + j);
            }
        }
    }

    public static void main(String[] args) {
        nSum(7, "");
    }
}
