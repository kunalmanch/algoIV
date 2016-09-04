package my.practice.misc;

/**
 * Created by kmishra on 8/31/2016.
 */
public class OneTwoSequence {

    public static void create(int n) {
        if (n <= 0) return;
        if (n >= 1) {
            System.err.println("1");
            if (n == 1) return;
            n--;
        }
        String s = "11";
        while (n-- > 0) {
            System.err.println(s);
            StringBuilder sb = new StringBuilder();
            char prev = s.charAt(0);
            int freq = 1;
            for (int i = 1; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (curr != prev) {
                    sb.append(freq);
                    sb.append(prev);
                    freq = 0;
                }
                freq++;
                prev = curr;
            }
            sb.append(freq);
            sb.append(prev);
            s = sb.toString();
        }
    }


    public static void main(String[] args) {
        create(5);
    }
}
