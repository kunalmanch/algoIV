package my.practice.sort;

/**
 * Given a sorted number stream as string, print the frequency of each number
 */
public class Frequency {

    public static void print(String s) {
        s = s.trim();
        String[] a = s.split(" ");
        int prev = Integer.parseInt(a[0]);
        int freq = 1;
        for (int i = 1; i < a.length; i++) {
            int curr = Integer.parseInt(a[i]);
            if (prev != curr) {
                System.err.println(prev + ":" + freq);
                freq = 0;
            }
            freq++;
            prev = curr;
        }
        System.err.println(prev + ":" + freq);
    }

    public static void main(String[] args) {
        String s = "1 1 2 3";
        print(s);
    }
}
