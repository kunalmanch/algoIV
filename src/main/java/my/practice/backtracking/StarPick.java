package my.practice.backtracking;

/**
 * Created by kmishra on 8/21/2016.
 */
public class StarPick {

    public static void starPick(char[] a, boolean[] b, int idx) {
        if (idx == a.length) {
            for (int i = 0; i < a.length; i++) {
                char c = b[i] ? a[i] : '*';
                System.err.print(c + " ");
            }
            System.err.println("");
        } else if (idx < a.length) {
            b[idx] = false;
            starPick(a, b, idx + 1);
            b[idx] = true;
            starPick(a, b, idx + 1);
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        starPick(a, new boolean[3], 0);
    }
}
