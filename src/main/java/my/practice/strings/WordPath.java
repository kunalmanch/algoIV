package my.practice.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length).
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists,
 * such that adjacent words in the chain only differ by one character
 * and each word in the chain is a valid word i.e., it exists in the dictionary.
 * It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 */
public class WordPath {

    public static void printPath(String[] a, String start, String target) {
        Set<String> set = new HashSet<>();
        for (String s : a) set.add(s);
        int pathLen = 1;
        boolean done = false;
        String prev = start;
        String toRemove = null;
        System.err.println(start);
        while (!done) {
            for (String s : set) {
                if (diffOne(prev, s)) {
                    toRemove = s;
                    prev = s;
                    pathLen++;
                    System.err.println(s);
                    break;
                }
            }
            set.remove(toRemove);
            if (prev.equals(target)) break;
        }
        System.err.println("Path length is : " + pathLen);
    }

    /**
     * To see if s1 and s2 differ by just one char.
     */
    private static boolean diffOne(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String[] a = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
        String start = "TOON";
        String target = "PLEA";
        printPath(a, start, target);
    }
}
