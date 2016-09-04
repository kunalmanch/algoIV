package my.practice.misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kmishra on 8/29/2016.
 */
public class MinParanthesis {

    public static int minRequired(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int required = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' :
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        required++;
                    }
            }
        }
        return required + stack.size();
    }

    public static void main(String[] args) {
        System.err.println(minRequired(")))((("));
        System.err.println(minRequired(")())"));
        System.err.println(minRequired(")()(("));
    }
}
