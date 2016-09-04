package my.practice.sort;

/**
 * Find kth smallest in two sorted arrays.
 */
public class KthSmallest {

    public static int ksmallest(int[] a, int[] b,
                                int a1, int a2, int b1, int b2,
                                int k) {
        int lena = a2 - a1;
        int lenb = b2 - b1;
        assert (0 <= k && k < (lena + lenb));
        if (lena == 0) {
            return b[b1 + k];
        }
        if (lenb == 0) {
            return a[a1 + k];
        }
        int mida = lena / 2;
        int midb = lenb / 2;
        int ma = a[a1 + mida];
        int mb = b[b1 + midb];
        if ((mida + midb) < k) {
            return (mb < ma) ?
                    ksmallest(a, b, a1, a2, b1 + midb + 1, b2, k - (midb + 1)) :
                    ksmallest(a, b, a1 + mida + 1, a2, b1, b2, k - (mida + 1));
        }
        else {
            return (mb < ma) ?
                    ksmallest(a, b, a1, a1 + mida, b1, b2, k) :
                    ksmallest(a, b, a1, a2, b1, b1 + midb, k);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,8,10};
        int[] b = {3,4,5,6,7,9};

        System.err.println(ksmallest(a, b, 0, a.length, 0, b.length, 4));
    }
}
