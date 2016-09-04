package my.practice.strings;

import java.util.*;

/**
 * Group anagrams together.
 */
public class AnagramSet {

    private static class Key {
        private char[] sArr;

        private Key(String s) {
            this.sArr = s.toCharArray();
            Arrays.sort(sArr);
        }

        @Override
        public int hashCode() {
            int hash = 1;
            for (int i = 0; i < sArr.length; i++) {
                hash = 29 * hash + sArr[i];
            }
            return hash;
        }

        @Override
        public boolean equals(Object o){
            if (o == null ||getClass() != o.getClass()) return false;
            Key that = (Key)o;
            if (this.sArr.length != that.sArr.length) return false;
            char[] freq = new char[256];
            for (int i = 0; i < this.sArr.length; i++) {
                freq[this.sArr[i]]++;
                freq[that.sArr[i]]--;
            }

            boolean isEqual = true;
            for (int i = 0; i < this.sArr.length; i++) {
                if (freq[this.sArr[i]] != 0) {
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        }
    }

    public static List<List<String>> groupAnagrams(String[] a) {
        Map<Key, List<String>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Key key = new Key(a[i]);
            List<String> list;
            if ((list = map.get(key)) == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(a[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Key, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc"};
        List<List<String>> result = groupAnagrams(a);
        for (List<String> list : result) {
            for (String s : list) {
                System.err.print(s + " ");
            }
            System.err.println("");
        }
    }
}
