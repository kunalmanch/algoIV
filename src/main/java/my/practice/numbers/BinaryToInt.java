package my.practice.numbers;

/**
 * Created by kmishra on 8/17/2016.
 */
public class BinaryToInt {

    public static int binaryToInt(String b) {
        int num = 0;
        for (int i = b.length() - 1, j = 0; i >= 0; i--, j++) {
            num += (int)Math.pow(2, j) * (b.charAt(i) - '0');
        }
        return num;
    }

    public static String intToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.err.println(binaryToInt("10"));
        System.err.println(intToBinary(4));
    }
}

