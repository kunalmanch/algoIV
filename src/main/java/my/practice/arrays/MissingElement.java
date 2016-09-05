package my.practice.arrays;

/**
 * Given an array that contains 1...n but misses on element, find the missing one
 */
public class MissingElement {

    public static int missing(int[] a, int n) {
        int x = a[0];
        for (int i = 1; i < a.length; i++) {
            x ^= a[i];
        }

        int y = 1;
        for (int i = 2; i <= n; i++) {
            y ^= i;
        }

        return x ^ y;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4};
        System.err.println(missing(a, 4));
    }
}
