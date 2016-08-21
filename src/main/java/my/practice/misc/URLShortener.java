package my.practice.misc;

/**
 * Created by kmishra on 8/14/2016.
 */
public class URLShortener {

    private static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static int BASE = ALPHABET.length();

    public static String shorten(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(ALPHABET.charAt(n % BASE));
            n /= BASE;
        }
        return sb.reverse().toString();
    }

    public static int expand(String url) {
        int id = 0;
        for (int i = 0; i < url.length(); i++) {
            id = id * 62 + ALPHABET.indexOf(url.charAt(i));
        }
        return id;
    }

    public static void main(String[] args) {
        System.err.println(shorten(123456));
        System.err.println(expand("Gho"));
    }
}
