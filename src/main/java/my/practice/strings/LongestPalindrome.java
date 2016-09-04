package my.practice.strings;

/**
 * Find longest palindrome formed by removing or shuffling chars from string
 */
public class LongestPalindrome {

    private static String longestPalindrome(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        char mid = '\0';
        char i = 'a';
        while (i <= 'z') {
            if (freq[i] == 0) {
                i++;
                continue;
            }
            if ((freq[i] & 1) == 1) {
                mid = i;
                freq[i]--;
            } else {
                int f = freq[i];
                for (int j = 0; j < f / 2; j++) {
                    sb.append(i);
                }
                i++;
            }
        }
        return sb.toString() + mid + sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "abbaccd";
        System.err.println(longestPalindrome(str));
        System.err.println(longestPalindrome("gggaaa"));
    }
}
