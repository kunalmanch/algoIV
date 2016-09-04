package my.practice.dp;

/**
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Approach like pallindrome.
 */
public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int l = 1; l <= nums.length; l++) {
            for (int i = 0; i < nums.length - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    int coins = nums[k] * (i - 1 < 0 ? 1 : nums[i - 1]) * (j + 1 > nums.length - 1 ? 1 : nums[j + 1]);
                    coins += k == i ? 0 : dp[i][k - 1];
                    coins += k == j ? 0 : dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[nums.length - 1][nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.err.println(maxCoins(nums));
    }
}
