package my.practice.backtracking;

/**
 * Created by kmishra on 8/23/2016.
 */
public class InterleaveStrings {

    public static void  interleaves(String a, String b, int i, int j, char[] arr, int idx) {
        if (idx == arr.length) {
            System.err.println(new String(arr));
        } else if (idx < arr.length) {
            if (i < a.length()) {
                arr[idx] = a.charAt(i);
                interleaves(a, b, i + 1, j, arr, idx + 1);
            }
            if (j < b.length()) {
                arr[idx] = b.charAt(j);
                interleaves(a, b, i, j + 1, arr, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        interleaves("ab", "cd", 0, 0, new char[4], 0);
    }
}
