package my.practice.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kmishra on 8/8/2016.
 */
public class Isomorphic {

    public static boolean isomorphic(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = a.charAt(i);
            if (map.containsKey(ca)) {
                if (cb != map.get(ca)) return false;
            } else {
                if (set.contains(cb)) return false;
                map.put(ca, cb);
                set.add(cb);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "foo";
        String b = "app";
        System.err.println(isomorphic(a, b));
    }
}
