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

    public static String encode(String s) {
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            int code;
            if (map.containsKey(s.charAt(j))) {
                code = map.get(s.charAt(j));
            } else {
                code = i;
                map.put(s.charAt(j), i++);
            }
            sb.append(code);
        }
        return sb.toString();
    }

    public static void allIsomorphic(String[] a, String p) {
        String encodedP = encode(p);
        for (String s : a) {
            if (encode(s).equals(encodedP)) {
                System.err.println(s);
            }
        }
    }

    public static void main(String[] args) {
        String a = "foo";
        String b = "app";
        System.err.println(isomorphic(a, b));
        String[] arr = {"abb", "abc", "xyz", "xyy"};
        allIsomorphic(arr, "foo");
    }
}
