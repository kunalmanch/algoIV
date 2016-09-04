package my.practice.misc;

/**
 * Created by kmishra on 8/30/2016.
 */
public class PatchingArray {

    public static int minPatches(int[] a, int n) {
        int i = 0;
        int miss = 1;
        int count = 0;
        while (miss <= n) {
            if (i < a.length && a[i] <= miss) {
                miss = miss + a[i];
                i++;
            } else {
                miss += miss;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,3};
        System.err.println(minPatches(a, 6));
    }
}
