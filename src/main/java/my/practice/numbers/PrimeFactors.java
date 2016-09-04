package my.practice.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime factors of n.
 */
public class PrimeFactors {

    public static List<Integer> primeDividers(int n) {
        if (n < 2) return null;
        int m = (int)Math.sqrt(n);
        boolean[] primes = new boolean[m + 1];
        Arrays.fill(primes, true);
        List<Integer> primesList = new ArrayList<>();
        for (int p = 2; p <= m; p++) {
            if (primes[p]) {
                if (n % p == 0) primesList.add(p);
                for (int i = p + p; i <= m; i += p) {
                    primes[i] = false;
                }
            }
        }
        return primesList;
    }

    public static void primeFactors(int n) {
        if (n % 2 == 0) {
            System.err.println("2");
            n /= 2;
        }
        int m = (int)Math.sqrt(n);
        for (int p = 3; p <= m; p += 2) {
            while (n % p == 0) {
                System.err.println(p);
                n /= p;
            }
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = primeDividers(315);
//        for (int i : list) System.err.println(i);
        primeFactors(315);
    }
}
