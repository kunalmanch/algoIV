package my.practice.misc;

/**
 * Created by kmishra on 9/1/2016.
 */
public class EliminationGame {

    public static int lastRemaining(int n) {
        boolean left = true;
        int step = 1;
        int head = 1;
        int remain = n;
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                head += step;
            }

            remain /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        System.err.println(lastRemaining(9));
    }
}
