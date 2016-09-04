package my.practice.dp;

/**
 * Created by kmishra on 8/26/2016.
 */
public class WiggleSubSequence {

    public static int wiggleSubSequence(int[] a) {
        int delta = a[1] - a[0];
        int max = delta == 0 ? 1 : 2;
        for (int i = 2; i < a.length; i++) {
            int newDelta = a[i] - a[i - 1];
            if (newDelta != 0 && newDelta * delta < 0) {
                delta = newDelta;
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.err.println(wiggleSubSequence(a));
        System.err.println("c".compareTo("b"));
    }
}
