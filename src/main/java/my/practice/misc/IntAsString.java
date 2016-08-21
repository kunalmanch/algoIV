package my.practice.misc;

import java.util.Collections;

/**
 * Created by kmishra on 8/15/2016.
 */
public class IntAsString {

    private static String[] ones = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static String[] tens = {
            "",//0
            "",//ten
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    public static String intAsString(int n) {
        if (n == 0) return "zero";

        if (n < 20) {
            return ones[n];
        } else if (n < 100) {
            return tens[n / 10] + (n % 10 == 0 ? "" : " " + ones[n % 10]);
        } else if (n < 1000) {
            return intAsString(n / 100) + " hundred" + (n % 100 == 0 ? "" : " " + intAsString(n % 100));
        } else if (n < 1000000) {
            return intAsString(n / 1000) + " thousand" + (n % 1000 == 0 ? "" : " " + intAsString(n % 1000));
        } else if (n < 1000000000) {
                return intAsString(n / 1000000) + " million" + (n % 1000000 == 0 ? "" : " " + intAsString(n % 1000000));
        }
        return intAsString(n / 1000000000) + " billion" + (n % 1000000000 == 0 ? "" : " " + intAsString(n % 1000000000));
    }

    public static void main(String[] args) {
        System.err.println(intAsString(1231234));
    }
}
