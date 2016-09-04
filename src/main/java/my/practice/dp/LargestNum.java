package my.practice.dp;

/**
 * Given two arrays of digits, create a max number of size k.
 * Approach : find the largest num from each array and merge.
 */
public class LargestNum {

    int[] a, b;
    int[][][] dp;

    public LargestNum(int[ ]a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public int max(int k) {
        dp = new int[a.length][b.length][k + 1];
        return maxHelper(0, 0, k);
    }

    private int maxHelper(int i, int j, int k) {
        if (k <= 0) return 0;
        if (i >= a.length) return 0;
        if (j >= b.length) return 0;
        int max;
        int pow = (int)Math.pow(10, k);
        if (a[i] > b[j]) {
            max = Math.max(a[i] * pow + maxHelper(i + 1, j, k - 1), maxHelper(i + 1, j + 1, k));
        } else {
            max = Math.max(a[i] * pow + maxHelper(i, j + 1, k - 1), maxHelper(i + 1, j + 1, k));
        }
        dp[i][j][k] = max;
        return dp[i][j][k];
    }

    public static void main(String[] args) {
        int[] a = {3,4,6,5};
        int[] b = {9,1,2,5,8,3};
        LargestNum obj = new LargestNum(a, b);
        System.err.println(obj.max(5));
    }
}
