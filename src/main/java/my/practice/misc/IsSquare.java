package my.practice.misc;

/**
 * Given four coordinates, determine if they form a square.
 */
public class IsSquare {

    public static boolean isSquare(int[][] mat) {
        int[] a = mat[0];
        int[] b = mat[1];
        int[] c = mat[2];
        int[] d = mat[3];

        double ab = dist(a, b);
        double ac = dist(a, c);
        double ad = dist(a, d);

        if (ab == ac && Math.sqrt(ac * ac + ab * ab) == ad) return true;
        if (ab == ad && Math.sqrt(ad * ad + ab * ab) == ac) return true;
        if (ac == ad && Math.sqrt(ac * ac + ad * ad) == ab) return true;
        return false;
    }

    private static double dist(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static void main(String[] args) {
        int[][] a = {
                {0,0},
                {1,1},
                {1,0},
                {0,1}
        };
        System.err.println(isSquare(a));
    }
}
