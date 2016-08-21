package my.practice.arrays;

/**
 * Created by kmishra on 8/15/2016.
 */
public class Diff {

    /**
     * Find the max diff between two numbers,
     * here the smaller number occurs before the larger number.
     */
    public static int maxDiff(int[] a) {
        int maxDiff = a[0], minSoFar = a[0];
        for (int i = 1; i < a.length; i++) {
            maxDiff = Math.max(maxDiff, a[i] - minSoFar);
            minSoFar = Math.min(a[i], minSoFar);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {80, 2, 6, 3, 100};
        System.err.println(maxDiff(arr));
    }
}
