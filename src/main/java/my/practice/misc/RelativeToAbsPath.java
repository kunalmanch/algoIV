package my.practice.misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kmishra on 8/15/2016.
 */
public class RelativeToAbsPath {

    public static String relativeToAbs(String path) {
        String[] a = path.split("\\\\");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : a) {
            if (s.equals(".") || s.isEmpty()) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        String absPath = "";
        while (!stack.isEmpty()) {
            absPath = "\\" + stack.pop() + absPath;
        }
        return absPath;
    }

    public static void main(String[] args) {
        System.err.println(relativeToAbs("\\windows\\abs\\..\\temp\\new\\.."));
    }
}
