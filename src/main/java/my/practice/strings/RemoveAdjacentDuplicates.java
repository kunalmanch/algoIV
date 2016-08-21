package my.practice.strings;

/**
 * Created by kmishra on 8/13/2016.
 */
public class RemoveAdjacentDuplicates {

    public static String removeAdjacentDuplicate(String s) {
        char[] a = s.toCharArray();
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
        return new String(a, 0, i + 1);
    }

    public static void main(String[] args) {
        System.err.println(removeAdjacentDuplicate("abbcbaa"));
    }
}
