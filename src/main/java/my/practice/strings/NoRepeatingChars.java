package my.practice.strings;

/**
 * Arrange chars in a string such that no char repeats twice.
 */
public class NoRepeatingChars {

    public static String rearrange(String s) {
        int[] freq = new int[26];
        int count = 0;
        int u = 0;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                u++;
            }
            freq[s.charAt(i) - 'a']++;
            if (freq[s.charAt(i) - 'a'] > s.length()/ 2) {
                count++;
                if ((u > 2 && count == 2) || count > 2) throw new RuntimeException("cannot re-arrange");
            }
        }
        char[] sb = new char[s.length()];
        int filled = 0;
        for (int i = 0, j = 0; filled < s.length() && i < freq.length; i++, j++) {
            int prevJ = j;
            while (freq[i] != 0) {
                sb[j] = (char)(i + 'a');
                filled++;
                freq[i]--;
                j += 2;
            }
            if (j >= s.length()) {
                j = prevJ;
            } else {
                j--;
            }
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        System.err.println(rearrange("aaabc"));
        System.err.println(rearrange("aab"));
        System.err.println(rearrange("aaab"));
    }
}
