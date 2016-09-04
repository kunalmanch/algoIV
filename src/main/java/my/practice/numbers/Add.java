package my.practice.numbers;

/**
 * Created by kmishra on 8/22/2016.
 */
public class Add {

    public static int[] add(int[] a, int[] b) {
        int[] c = new int[a.length > b.length ? a.length + 1 : b.length + 1];
        int[] s, g;
        if (a.length > b.length) {
            g = a;
            s = b;
        } else {
            g = b;
            s = a;
        }
        int i, l, j;
        for (j = g.length - 1, i = s.length - 1, l = c.length - 1; i >= 0; i--, l--, j--) {
            int sum = c[l] + s[i] + g[j];
            c[l] = sum % 10;
            c[l - 1] = sum / 10;
        }

        while (j >= 0) {
            int sum = c[l] + g[j];
            c[l] = sum % 10;
            if (sum / 10 != 0) {
                c[l - 1] = sum / 10;
            }
            l--; j--;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {1,5};
        int[] b = {1,5,0,0};
        int[] c = add(a, b);
        for (int i : c) {
            System.err.print(i + " ");
        }
        System.err.println("");
    }
}
