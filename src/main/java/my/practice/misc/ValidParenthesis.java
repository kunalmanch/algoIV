package my.practice.misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kmishra on 8/18/2016.
 */
public class ValidParenthesis {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isValid("()()"));
    }
}
