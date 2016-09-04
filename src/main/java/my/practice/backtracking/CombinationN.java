package my.practice.backtracking;

/**
 * Given a set, print all combinations of N.
 */
public class CombinationN {

    public static void combinations(int[] set, int[] a, int idx) {
        if (idx == a.length) {
            for (int i : a) System.err.print(i + " ");
            System.err.println("");
        } else if (idx < a.length) {
            for (int i = 0; i < set.length; i++) {
                a[idx] = set[i];
                combinations(set, a, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] set = {2,3,4};
        combinations(set, new int[2], 0);
    }
}
