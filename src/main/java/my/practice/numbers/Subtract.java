package my.practice.numbers;

/**
 * Created by kmishra on 8/23/2016.
 */
public class Subtract {

    public static int[] subtract(int[] a, int[] b) {
        int[] c = new int[a.length > b.length ? a.length : b.length];
        int[] g, s;
        if (a.length > b.length) {
            g = a; s = b;
        } else {
            g = b; s = a;
        }
        int i, j, k;
        int borrow = 0;
        for (i = g.length - 1, j = s.length - 1, k = c.length - 1; j >= 0; j--, i--, k--) {
            int t = g[i];
            int tBorrow = 0;
            if (g[i] < s[j]) {
                t += 10;
                tBorrow = -1;
            }
            c[k] = t - s[j] + borrow;
            borrow = tBorrow;
        }

        while (i >= 0) {
            int t = g[i];
            int tBorrow = 0;
            if (t + borrow < 0) {
                t += 10;
                tBorrow = -1;
            }
            c[k] = t + borrow;
            borrow = tBorrow;
            k--; i--;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {1,2,0};
        int[] b = {2};
        int[] c = subtract(a, b);
        for (int i : c) System.err.print(i + " ");
        System.err.println("");
    }
}
