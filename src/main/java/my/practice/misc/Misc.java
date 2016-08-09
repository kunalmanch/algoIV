package my.practice.misc;

/**
 * Created by kmishra on 8/7/2016.
 */
public class Misc {

    /**
     * Given an array of numbers ,
     * replace each number with the product of all the numbers
     * divided by the number at that index without using the division operator
     */
    public static void printProducts(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];

        int product = 1;
        for (int i = 0; i < a.length; i++) {
            left[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            right[i] = product;
            product *= a[i];
        }

        for (int i = 0; i < a.length; i++) {
            System.err.println(left[i] * right[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        printProducts(a);
    }
}
