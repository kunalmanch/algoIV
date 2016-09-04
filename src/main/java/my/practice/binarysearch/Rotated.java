package my.practice.binarysearch;

/**
 * Created by kmishra on 8/30/2016.
 */
public class Rotated {

    public static int findMin(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            if (lo == hi) {
                return a[lo];
            }
            if (lo + 1 == hi) {
                return Math.min(a[lo], a[hi]);
            }

            if (a[lo] < a[hi]) {
                return a[lo];
            }

            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] > a[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,1,2};
        System.err.println(findMin(a));
    }
}
