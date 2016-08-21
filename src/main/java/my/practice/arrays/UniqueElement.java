package my.practice.arrays;

/**
 * Created by kmishra on 8/13/2016.
 */
public class UniqueElement {

    public static int unique(int[] a) {
        int x = a[0];
        for (int i = 1; i < a.length; i++) {
            x ^= a[i];
        }
        return x;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,3};
        System.err.println(unique(a));
    }
}
