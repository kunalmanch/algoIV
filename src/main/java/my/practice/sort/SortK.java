package my.practice.sort;

/**
 * Sort an array as much as possible by moving an index at most k places to its left.
 * However, an element can travel as much as possible to its right.
 */
public class SortK {

    /**
     * Use bubble sort logic.
     */
    public static void sortK(int[] a, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,1,2};
        sortK(a, 2);
        for (int i : a) System.err.print(i + " ");
        System.err.println("");
        sortK(a, a.length - 2);
        for (int i : a) System.err.print(i + " ");
    }
}
