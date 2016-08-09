package my.practice.binarysearch;

/**
 * Created by kmishra on 8/8/2016.
 */
public class BinarySearch {

    /**
     *  given a target and a sorted array, find the element that is strictly larger than the target.
     */
    public static int findLarger(int[] a, int t) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            if (lo == hi) {
                if (a[lo] > t) return lo;
                else throw new RuntimeException(t + " not found.");
            }

            if (hi - lo == 1) {
                if (a[lo] > t) return lo;
                if (a[hi] > t) return hi;
                throw new RuntimeException(t + " not found.");
            }

            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] > t) return mid;
            else lo = mid + 1;
        }
        throw new RuntimeException(t + " not found.");
    }

    /**
     * find pivot (min element) in sorted rotated array
     */
    public static int minRotated(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            if (lo == hi) return a[lo];
            if (hi - lo == 1) return Math.min(a[lo], a[hi]);

            //means array is sorted in this part.
            if (a[lo] < a[hi]) return a[lo];

            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] > a[hi]) lo = mid;
            else hi = mid;
        }
        throw new RuntimeException("Error");
    }

    /**
     * Find max element in an array that first increases and then decreases.
     */
    public static int maxIncDec(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            if (lo == hi) return a[lo];
            if (hi - lo == 1) return Math.max(a[lo], a[hi]);

            int mid = lo + ((hi - lo) >> 1);

            if (a[mid] > a[mid -1] && a[mid] > a[mid + 1]) return a[mid];

            //all the numbers are in increasing order.
            if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) lo = mid + 1;
            else hi = mid - 1;
        }
        throw new RuntimeException("error");
    }

    /**
     * count occurrences of a number in a sorted array.
     */
    public static int countOccurrence(int[] a, int n) {
        int lo = 0, hi = a.length - 1;
        int l = -1;
        while (lo <= hi) {
            if (lo == hi) {
                if (a[lo] == n) l = lo;
                break;
            }
            if (hi - lo == 1) {
                if (a[lo] == n) l = lo;
                if (a[hi] == n) l = hi;
                break;
            }

            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] == n && a[mid - 1] != n) {
                l = mid;
                break;
            }
            if (a[mid] < n) lo = mid + 1;
            else hi = mid - 1;
        }

        if (l == -1) throw new RuntimeException("error");

        lo = l; hi = a.length - 1;
        int r = l;
        while (lo <= hi) {
            if (lo == hi) {
                if (a[lo] == n) l = lo;
                break;
            }
            if (hi - lo == 1) {
                if (a[hi] == n) r = hi;
                if (a[lo] == n) r = lo;
                break;
            }
            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] == n && a[mid + 1] != n) {
                r = mid;
                break;
            }
            if (a[mid] > n) hi = mid - 1;
            else lo = mid + 1;
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        System.err.println(a[findLarger(a, 5)]);
        int[] rotated = {3,4,5,1,2};
        System.err.println(minRotated(rotated));
        int[] incdec = {-1,0,1,2,3,4,10,9,8};
        System.err.println(maxIncDec(incdec));
        int[] dup = {1,2,3,3,3,4};
        System.err.println(countOccurrence(dup, 3));
    }
}
