package my.practice.backtracking;

/**
 * Created by kmishra on 8/26/2016.
 */
public class BitSet {

    public static void bitset(char[] a, int idx) {
        if (idx == a.length) {
            System.err.println(new String(a));
        } else {
            a[idx] = '0';
            bitset(a, idx + 1);
            a[idx] = '1';
            bitset(a, idx + 1);
        }
    }

    public static void main(String[] args) {
        bitset(new char[3], 0);
    }
}
