package my.practice.misc;

import java.util.Arrays;

/**
 * Given a list of weights, find minimum number of canoes needed to fit all the persons.
 * A canoe can carry max 2 persons of 150 lbs.
 */
public class TwoInCanoe {

    public static int min(int[] weights) {
        Arrays.sort(weights);
        int i = 0, j = weights.length - 1;
        int min = 0;
        while (i < j) {

            if (weights[i] >= 150) {
                return min;
            }

            if (weights[i] + weights[j] <= 150) {
                i++;
            }
            if (weights[j] <= 150) {
                min++;
            }
            j--;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {50,70,50,100};
        System.err.println(min(a));
        int[] b = {50,70,50,100,120,160};
        System.err.println(min(b));
    }
}
