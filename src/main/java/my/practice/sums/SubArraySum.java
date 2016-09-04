package my.practice.sums;

/**
 * Given a target find a sub-array whose sum is equal to target.
 */
public class SubArraySum {

    public static void subArraySum(int[] a, int t) {
        if (a == null || a.length == 0) throw new RuntimeException("empty array");
        int sum = a[0];
        int i = 0, j = 1;
        while (i < a.length) {
            if (sum == t) {
                for (int k = i; k < j; k++) {
                    System.err.print(a[k] + " ");
                }
                System.err.println("");
                return;
            } else if (sum > t && i < j - 1) {
                sum -= a[i++];
            } else {
                if (j == a.length) {
                    break;
                }
                sum += a[j++];
            }
        }
        System.err.println("not found");
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 20, 3, 10, 5};
        subArraySum(a, 33);
        int[] b = {1, 4, 0, 0, 3, 10, 5};
        subArraySum(b, 7);
        int[] c = {1, 4};
        subArraySum(c, 0);
    }
}
