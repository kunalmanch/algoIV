package my.practice.search;

import static my.practice.search.Selection.swap;

/**
 * Created by kmishra on 8/9/2016.
 */
public class QuickSort {

    /**
     * ascending order
     */
    public static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);
            quickSort(a, lo, pivot - 1);
            quickSort(a, pivot + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        for (int j = lo; j <= hi; j++) {
            if (a[j] < a[hi]) {
                swap(a, lo, j);
                lo++;
            }
        }
        swap(a, lo, hi);
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {5,6,4,2,1,3};
        quickSort(a, 0, a.length - 1);
        for (int i : a) System.err.println(i);
    }
}
