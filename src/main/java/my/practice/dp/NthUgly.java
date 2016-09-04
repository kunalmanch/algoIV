package my.practice.dp;

/**
 * Find Nth super ugly number.
 */
public class NthUgly {

    public static int nthUgly(int[] primes, int n) {
        int[] dp = new int[n + 1];
        int[] indexes = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
           int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(dp[indexes[j]] * primes[j], min);
            }

            for (int j = 0; j < primes.length; j++) {
                if (min % primes[j] == 0) {
                    indexes[j]++;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] primes = {2,3};
        System.err.println(nthUgly(primes, 6));
    }
}
