package my.practice.numbers;

/**
 * Created by kmishra on 8/21/2016.
 */
public class Multiply {

    public static int[] multiply(int[] a, int[] b) {
        int[] c = new int[a.length * b.length];
        for (int i = a.length - 1, k = c.length - 1; i >= 0; i--, k--) {
            int carry = 0;
            int l = k;
            for (int j = b.length - 1; j >= 0; j--, l--) {
                int prod = a[i] * b[j] + c[l] + carry;
                carry = prod / 10;
                c[l] = prod % 10;
            }
            if (carry > 0) {
                c[l] = (c[l] + carry) % 10;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {2,2,3};
        int[] b = {1,5};
        int[] c = multiply(a, b);
        for (int i : c) System.err.print(i + " ");
        System.err.println("");
    }
}
