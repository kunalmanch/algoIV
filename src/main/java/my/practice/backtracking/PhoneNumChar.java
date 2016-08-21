package my.practice.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Phone number to character mapping
 */
public class PhoneNumChar {

    public static void printCominations(String num) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('1', new char[]{'\0'});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        map.put('0', new char[]{'+'});
        helper(num, 0, map, new StringBuilder());
    }

    private static void helper(String num, int idx, Map<Character, char[]> map, StringBuilder sb) {
        if (idx == num.length()) {
            System.err.println(sb);
        } else if (idx < num.length()) {
            char[] c = map.get(num.charAt(idx));
            for (int i = 0; i < c.length; i++) {
                sb.append(c[i]);
                helper(num, idx + 1, map, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        printCominations("234");
    }
}
