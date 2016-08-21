package my.practice.search;

/**
 * Created by kmishra on 8/9/2016.
 */
public class Selection {

    public static void selectMax(int[] a, int lo, int hi, int k) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);
            if (pivot == k) return;
            if (pivot > k) selectMax(a, lo, pivot - 1, k);
            else selectMax(a, pivot + 1, hi, k);
        }
    }

    public static int partition(int[] a, int lo, int hi) {
        for (int j = lo; j <= hi; j++) {
            if (a[j] > a[hi]) {
                swap(a, j, lo);
                lo++;
            }
        }
        swap(a, lo, hi);
        return lo;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2,1,3};
        int k = a.length - 1;
        selectMax(a, 0, a.length - 1, k);
        for (int i = 0; i <= a.length - 1; i++) System.err.println(a[i]);
    }
}
