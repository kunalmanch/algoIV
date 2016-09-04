package my.practice.strings;

/**
 * Given a sub-string, eliminate it from the original string.
 * Also count the number of occurrences of the sub-string.
 */
public class EliminateSubString {

    public static int eliminate(String s, String e) {
        char[] sArr = s.toCharArray();
        char[] eArr = e.toCharArray();
        int count = 0;
        int k = 0;
        for (int i = 0; i < sArr.length; i++, k++) {
            boolean flag = false;
            if (sArr[i] == eArr[0]) {
                int prevI = i;
                for (int j = 0; j < eArr.length && i < sArr.length; j++, i++) {
                    flag = false;
                    if (sArr[i] != eArr[j]) break;
                    flag = true;
                }
                if (flag) count++;
                else i = prevI;
            }
            if (i == sArr.length) break;
            sArr[k] = sArr[i];
        }
        System.err.println(new String(sArr, 0, k));
        return count;
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.err.println(eliminate("abcdfcdf", "cd"));
    }
}
