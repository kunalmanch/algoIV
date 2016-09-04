package my.practice.arrays;

/**
 * Given an array of length n and elements in the range [1,n],
 * find the duplicate element.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] a) {
        for (int i : a) {
            if (a[Math.abs(i)] < 0) {
                return Math.abs(i);
            }
            a[Math.abs(i)] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,2};
        System.err.println(findDuplicate(a));
    }

}
