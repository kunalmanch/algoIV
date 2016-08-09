package my.practice.misc;

import java.util.Arrays;

/**
 * Created by kmishra on 8/7/2016.
 */
public class Triangle {

    public static int[] getTriangle(int[] a) {
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                int s1 = a[i], s2 = a[j], s3 = a[k];
                if (isTriangle(s1, s2, s3)) {
                    System.err.println(s1 + "|" + s2 + "|" + s3);
                    k--;
                } else {
                    j++;
                }
            }
        }
        return null;
    }

    public static int countTriangles(int[] a) {
        Arrays.sort(a);
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                int s1 = a[i], s2 = a[j], s3 = a[k];
                if (isTriangle(s1, s2, s3)) {
                    result += k - j;
                    System.err.println(s1 + " " + s2 + " " + s3);
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    private static boolean isTriangle(int s1, int s2, int biggest) {
        return s1 + s2 > biggest;
    }

    public static void main(String[] args) {
        int[] a = {12, 3, 15, 17, 1, 4};
        getTriangle(a);
        System.err.println(countTriangles(a));
    }
}
