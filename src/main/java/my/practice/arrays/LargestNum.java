package my.practice.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Concatenate nums in an array to form the largest possible number.
 */
public class LargestNum {

    public static class MyComp implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            int i = 0;
            char c1 = ' ';
            char c2 = ' ';
            while (i < Math.max(m, n)) {
                if (i < m) {
                    c1 = s1.charAt(i);
                }
                if (i < n) {
                    c2 = s2.charAt(i);
                }
                i++;
                if (c1 == c2) continue;
                return c1 > c2 ? -1 : 1;
            }
            return 0;
        }
    }

    public static int largestNum(int[] a) {
        String[] arr = new String[a.length];
        int idx = 0;
        for (int i : a) {
            arr[idx++] = String.valueOf(i);
        }

        Arrays.sort(arr, new MyComp());

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.err.println(new MyComp().compare("1", "113"));
        System.err.println(new MyComp().compare("9", "917"));
        int[] a = {1,112,113};
        System.err.println(largestNum(a));
    }
}
