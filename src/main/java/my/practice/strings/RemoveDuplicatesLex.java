package my.practice.strings;

import java.util.*;

/**
 * Remove duplicates to form lexicographically shortest string.
 */
public class RemoveDuplicatesLex {

    public static String shortest(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] result = new char[map.size()];
        TreeMap<Character, Integer> treeMap = new TreeMap<>(new MyComp(map));
        treeMap.putAll(map);
        int l = 0, k = 0;
        while (!treeMap.isEmpty()) {
            char c = treeMap.firstKey();
            int r = map.get(c);
            char minChar = Character.MAX_VALUE;
            int minIdx = -1;
            for (int i = l; i <= r; i++) {
                if (!map.containsKey(s.charAt(i))) continue;
                if (minChar > s.charAt(i)) {
                    minChar = s.charAt(i);
                    minIdx = i;
                }
            }
            result[k++] = minChar;
            l = minIdx + 1;
            treeMap.remove(minChar);
            map.remove(minChar);
        }
        return new String(result);
    }

    private static class MyComp implements Comparator<Character> {

        private Map<Character, Integer> map;

        private MyComp(Map<Character, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Character c1, Character c2) {
            return map.get(c1) - map.get(c2);
        }
    }

    public static void main(String[] args) {
        System.err.println(shortest("cbacdcbc"));
        System.err.println(shortest("acabb"));
    }
 }
