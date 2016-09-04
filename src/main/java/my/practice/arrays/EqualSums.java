package my.practice.arrays;

/**
 * Find indexes where sum(left) == sum(right)
 */
public class EqualSums {

    public static void equal(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        int leftSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum - a[i] - leftSum == leftSum) System.err.println(i + " : " + a[i]);
            leftSum += a[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 3, -4, 5, 1, -6, 2, 1};
        equal(a);
    }
}
