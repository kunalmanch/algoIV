package my.practice.search;

import java.util.Arrays;

/**
 * Created by kmishra on 8/18/2016.
 */
public class MergeSort {

    public static void mergeSort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(a, tmp, lo, mid);
        mergeSort(a, tmp, mid + 1, hi);
        merge(a, tmp, lo, mid, hi);
    }

    private static void merge(int[] a, int[] tmp, int lo, int mid, int hi) {
        if (lo >= hi) return;
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (a[i] < a[j]) {
                tmp[k] = a[i++];
            } else {
                tmp[k] = a[j++];
            }
            k++;
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= hi) {
            tmp[k++] = a[j++];
        }

        for (i = lo; i <= hi; i++) {
            a[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,5,4};
        int[] tmp = Arrays.copyOf(a, a.length);
        mergeSort(a, tmp, 0, a.length - 1);
        for (int i : a) System.err.println(i);
    }
}
