package my.practice.strings;

/**
 * Created by kmishra on 8/21/2016.
 */
public class SecondMaxFreq {

    public static char max2ndFreq(String s) {
        char[] freq = new char[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int c1 = ' ', c2 = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] == 0) continue;
            if (freq[i] > max) {
                secondMax = max;
                c2 = c1;
                max = freq[i];
                c1 = i;
            } else if (freq[i] > secondMax) {
                secondMax = freq[i];
                c2 = i;
            }
        }
        return (char)c2;
    }

    public static void main(String[] args) {
        String s = "aaabbcccc";
        System.err.println(max2ndFreq(s));
    }
}
