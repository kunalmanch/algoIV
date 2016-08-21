package my.practice.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/13/2016.
 */
public class Disjoint {

    public static boolean isDisjoint(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isDisjoint("abc", "dde"));
    }
}
