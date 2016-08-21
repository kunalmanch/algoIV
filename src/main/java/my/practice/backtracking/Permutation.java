package my.practice.backtracking;

/**
 * Created by kmishra on 8/8/2016.
 */
public class Permutation {

    public static void printPermutations(char[] a, int lo, int hi) {
        if (lo == hi) {
            for (char i : a) System.err.print(i + " ");
            System.err.println("");
        } else {
            for (int i = lo; i <= hi; i++) {
                swap(a, lo, i);
                printPermutations(a, lo + 1, hi);
                swap(a, lo, i);
            }
        }
    }
    private static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        char[] a = "abc".toCharArray();
        printPermutations(a, 0, a.length - 1);
    }
}
