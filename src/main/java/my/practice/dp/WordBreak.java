package my.practice.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/14/2016.
 */
public class WordBreak {

    public static boolean isPresent(String s, Set<String> dict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String t = s.substring(i, j);
                    if (dict.contains(t)) {
                        sb.append(t);
                        sb.append(' ');
                        dp[j] = i;
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.err.println(sb);
        return dp[s.length()] != -1;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.err.println(isPresent("leetcode", dict));
    }
}
