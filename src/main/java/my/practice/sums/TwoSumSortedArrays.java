package my.practice.sums;

/**
 * 2 sum for two sorted arrays.
 * Approach : do a merge while traversing both lists.
 * Start from the largest num's idx and smallest num's idx.
 */
public class TwoSumSortedArrays {

    private static void twoSum(int[] a, int[] b, int t) {
        int i = 0, j = 0, k = a.length - 1, l = b.length - 1;
        boolean moveFront = true;
        boolean moveBack = true;
        int lo = -1, hi = -1;
        while (i <= k && j <= l) {
            if (moveFront) {
                if (a[i] < b[j]) {
                    lo = a[i++];
                } else {
                    lo = b[j++];
                }
            }

            if (moveBack) {
                if (a[k] > b[l]) {
                    hi = a[k--];
                } else {
                    hi = b[l--];
                }
            }

            int sum = hi + lo;
            if (sum == t) {
                System.err.println("found : " + lo + ":" + hi);
                return;
            }
            if (sum > t) {
                moveFront = false;
                moveBack = true;
            } else {
                moveFront = true;
                moveBack = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3,5,8};
        int[] b = {1,7,9};
        twoSum(a, b, 16);
    }
}
