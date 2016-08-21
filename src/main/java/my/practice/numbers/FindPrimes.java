package my.practice.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kmishra on 8/18/2016.
 */
public class FindPrimes {

    public static List<Integer> primes(int n) {
        if (n < 2) return null;
        List<Integer> primeList = new ArrayList<>();
        if (n == 2) {
            primeList.add(2);
            return primeList;
        }

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p <= n; p++) {
            if (primes[p]) {
                for (int i = p + p; i <= n; i = i + p)
                    primes[i] = false;
            }
        }

        for (int p = 2; p <= n; p++) {
            if (primes[p]) primeList.add(p);
        }

        return primeList;
    }

    public static void printPrimes(List<Integer> primesList) {
        for (int i : primesList) {
            System.err.println(i);
        }
    }

    public static void main(String[] args) {
        printPrimes(primes(10));
    }
}
