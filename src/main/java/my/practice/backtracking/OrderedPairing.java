package my.practice.backtracking;

/**
 * Created by kmishra on 8/25/2016.
 */
public class OrderedPairing {

    public static void orderedPairs(String s, String out) {
        System.err.println(out + '(' + s + ')');
        for (int i = 1; i < s.length(); i++) {
            String pre = out + '(' + s.substring(0, i) + ')';
            orderedPairs(s.substring(i, s.length()), pre);
        }
    }

    public static void main(String[] args) {
        String s = "1234";
        orderedPairs(s, "");
    }
}
