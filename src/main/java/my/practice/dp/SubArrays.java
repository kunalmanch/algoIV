package my.practice.dp;

/**
 * Created by kmishra on 8/6/2016.
 */
public class SubArrays {
    /**
     * max contiguous sub-array sum in a array containing negative and positive values.
     */
    public static int maxSum(int[] a) {
        long maxSoFar = Integer.MIN_VALUE, maxHere = Integer.MIN_VALUE;
        for (int x : a) {
            maxHere = Math.max(x, x + maxHere);
            maxSoFar = Math.max(maxHere, maxSoFar);
        }
        return (int)maxSoFar;
    }

    public static int maxProduct(int[] a) {
        int prevMax = a[0], prevMin = a[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            int currMax, currMin;
            if (a[i] > 0) {
                currMax = Math.max(a[i], a[i] * prevMax);
                currMin = Math.min(a[i], a[i] * prevMin);
            } else {
                currMax = Math.max(a[i], a[i] * prevMin);
                currMin = Math.min(a[i], a[i] * prevMax);
            }
            result = Math.max(currMax, result);
            prevMax = currMax;
            prevMin = currMin;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-5,-2,-1,2,9, 2,-2};
        System.err.println(maxSum(a));
        System.err.println(maxProduct(a));
    }
}
