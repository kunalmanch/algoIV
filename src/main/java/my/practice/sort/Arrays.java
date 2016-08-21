package my.practice.sort;

/**
 * Created by kmishra on 8/13/2016.
 */
public class Arrays {

    /**
     * given a sorted array, remove duplicates in place and return length of the array.
     */
    public static int removeDuplicate(int[] a) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
        return i + 1;
    }

    /**
     * find duplicates in two sorted arrays
     * e.g. {1,2,3} and {3,4,5} => {3, 3} so countLand 1.
     */
    public static int findDuplicates(int[] a, int[] b) {
        int i = 0, j = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) count++;
            if (a[i] < b[j]) i++;
            else j++;
        }
        return count;
    }

    /**
     * most frequent element in a sorted array.
     */
    public static int maxOccuring(int[] a) {
        int prev = a[0];
        int maxElement = prev;
        int maxOcc = Integer.MIN_VALUE;
        int firstOccIdx = 0, i;
        for (i = 1; i < a.length; i++) {
            int curr = a[i];
            if (prev != a[i]) {
                if (i - firstOccIdx > maxOcc) {
                    maxOcc = i - firstOccIdx;
                    maxElement = prev;
                }
                firstOccIdx = i;
            }
            prev = curr;
        }
        if (i - firstOccIdx > maxOcc) {
            maxElement = prev;
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {1,2,3,3};
        int[] c = {1,1,1};
        System.err.println(removeDuplicate(a));
        System.err.println(removeDuplicate(b));
        System.err.println(removeDuplicate(c));
        a = new int[]{1,2,3};
        b = new int[]{3,3,5};
        System.err.println(findDuplicates(a, b));

        a = new int[]{1,2,3,3,3,4,4,4,4};
        System.err.println(maxOccuring(a));
    }
}
