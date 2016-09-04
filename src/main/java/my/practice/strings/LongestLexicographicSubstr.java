package my.practice.strings;

/**
 * sub > str
 */
public class LongestLexicographicSubstr {

    static void printLongestSubstringLexBigger(String str) {
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; i + j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i + j)) {
                    i += j;
                    break;
                } else if (str.charAt(j) < str.charAt(i + j)) {
                    System.err.println(str.substring(j));
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        printLongestSubstringLexBigger("dcbdcbx");
        System.err.println("dcbdcbx".compareTo("dcbx"));
    }
}
