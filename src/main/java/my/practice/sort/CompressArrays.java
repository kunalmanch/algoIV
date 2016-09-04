package my.practice.sort;

/**
 * Compress sorted arrays.
 */
public class CompressArrays {

    public static String compress(int[] a) {
        StringBuilder sb = new StringBuilder();
        int prev = a[0];
        int start = a[0];
        int curr;
        for (int i = 1; i < a.length; i++) {
            curr = a[i];
            if (curr - prev != 1) {
                if (start == prev) {
                    sb.append(start);
                    sb.append(',');
                } else {
                    sb.append(start);
                    sb.append('-');
                    sb.append(prev);
                    sb.append(',');
                }
                start = curr;
            }
            prev = curr;
        }
        if (start == prev) {
            sb.append(start);
            sb.append(',');
        } else {
            sb.append(start);
            sb.append('-');
            sb.append(prev);
            sb.append(',');
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,10,25,26,30,31,32,33};
        System.err.println(compress(a));
    }
}
