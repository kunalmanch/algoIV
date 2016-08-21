package my.practice.dp;

/**
 * Given a set, figure out if a subset adds to given target
 */
public class SubSetSum {

    public static boolean subSetSum(int[] nums, int target) {
        boolean[][] s = new boolean[target + 1][nums.length + 1];

        //for target 0, there is a solution, i.e., empty set.
        for (int i = 0; i <= nums.length; i++) s[0][i] = true;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                s[i][j] = s[i][j - 1];
                if (nums[j - 1] <= i) {
                    s[i][j] = s[i][j] || s[i - nums[j - 1]][j - 1];
                }
            }
        }

        return s[target][nums.length];
    }

    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        System.err.println(subSetSum(a, 9));
    }
}
