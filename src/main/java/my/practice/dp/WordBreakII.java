package my.practice.dp;

import java.util.*;

/**
 * Created by kmishra on 8/22/2016.
 */
public class WordBreakII {

    private static class Container {
        private String s;
        private int prev;

        private Container(String s, int prev) {
            this.s = s;
            this.prev = prev;
        }
    }

    public static List<String> wordBreakII(String s, Set<String> dict) {
        List[] arr = new List[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (dict.contains(sub)) {
                    if (arr[j] == null) {
                        arr[j] = new ArrayList();
                    }
                    arr[j].add(new Container(sub, i));
                }
            }
        }
        List<String> list = new ArrayList<>();
        dfs(arr, list, "", arr.length - 1);
        return list;
    }

    private static void dfs(List[] arr, List<String> list, String s, int i) {
        if (i == 0) {
            list.add(s);
        } else if (i > 0) {
            for (Object o : arr[i]) {
                Container c = (Container)o;
                dfs(arr, list, c.s + " " + s, c.prev);
            }
        }
    }

    public static void main(String[] args) {
        String[] dArr = {"cat", "cats", "and", "sand", "dog"};
        Set<String> dict = new HashSet<>();
        for (String s : dArr) dict.add(s);
        List<String> list = wordBreakII("catsanddog", dict);
        for (String s : list) System.err.println(s);
    }
}
