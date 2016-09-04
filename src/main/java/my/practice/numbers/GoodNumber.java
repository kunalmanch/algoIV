package my.practice.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Let t be a good number if there are at least two ways to write t as sum of two distinct cubes.
 */
public class GoodNumber {

    public static void goodNumber(int n) {
        List<Integer> cubes = new ArrayList<>();
        int next = 2;
        int cube = 1;
        while (cube <= n) {
            cubes.add(cube);
            cube = next * next * next;
            next++;
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < cubes.size(); i++) {
            for (int j = i + 1; j < cubes.size(); j++) {
                int sum = cubes.get(i) + cubes.get(j);
                if (sum < 0 || sum > n) continue;
                dp[sum]++;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] >= 2) System.err.println(i);
        }
    }

    public static void main(String[] args) {
        goodNumber(6000);
    }
}
