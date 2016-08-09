package my.practice.expressions;

import java.util.*;

/**
 * Created by kmishra on 8/7/2016.
 */
public class Expressions {

    static Set<String> operators = new HashSet<>();

    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public static int evaluatePostFix(String[] post) {
        Deque<String> opStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        for (String s : post) {
            if (operators.contains(s)) {
                opStack.push(s);
            } else {
                numStack.push(Integer.valueOf(s));
            }
            if (!opStack.isEmpty()) {
                int result = operate(opStack.pop(), numStack.pop(), numStack.pop());
                numStack.push(result);
            }
        }
        return numStack.pop();
    }

    private static int operate(String op, int r, int l) {
        switch (op) {
            case "+" :
                return l + r;
            case "-" :
                return l - r;
            case "*" :
                return l * r;
            case "/" :
                return l / r;
        }
        throw new RuntimeException("op " + op + " not supported.");
    }

    private static String[] infixToPostFix(String[] infix) {
        String[] postfix = new String[infix.length];
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        for (String s : infix) {
            if (operators.contains(s)) {
                while (!stack.isEmpty() && compare(s, stack.peek()) < 0) {
                    postfix[idx++] = stack.pop();
                }
                stack.push(s);
            } else {
                postfix[idx++] = s;
            }
        }
        while (!stack.isEmpty()) {
            postfix[idx++] = stack.pop();
        }
        return postfix;
    }

    private static int compare(String op1, String op2) {
        if ("/".equals(op1)) return 1;
        if ("*".equals(op1)) {
            if ("/".equals(op2)) return -1;
            else return 1;
        }
        if ("+".equals(op1)) {
            if ("-".equals(op2)) return 1;
            else return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.err.println(evaluatePostFix(tokens));
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.err.println(evaluatePostFix(tokens2));
        String[] infix = {"1", "+", "6", "/", "2"};
        String[] postfix = infixToPostFix(infix);
        for (String s: postfix) System.err.print(s + " ");
        System.err.println("");
        System.err.println(evaluatePostFix(postfix));
    }
}
