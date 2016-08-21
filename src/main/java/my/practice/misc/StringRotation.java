package my.practice.misc;

/**
 * Created by kmishra on 8/15/2016.
 */
public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        String temp = s1 + s1;
        return temp.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "ABACD";
        String s2 = "CDABA";
        System.err.println(isRotation(s1, s2));
    }
}
