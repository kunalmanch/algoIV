package my.practice.arrays;

/**
 * Created by kmishra on 8/12/2016.
 */
public class RotateArray {

    public static void reverse(int[] a, int l, int r) {
        if (l >= r) return;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void rotateLeft(int[] a, int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void rotateRight(int[] a, int d) {
        reverse(a, 0, a.length - 1);
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
    }

    public static void print(int[] a) {
        for (int i : a) System.err.print(i + " ");
        System.err.println("");
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotateLeft(a, 2); // 3 5 4 6 7 1 2
        print(a);
        int[] b = {1,2,3,4,5,6,7};
        rotateRight(b, 2);
        print(b);
    }
}
