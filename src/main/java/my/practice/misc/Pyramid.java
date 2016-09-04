package my.practice.misc;

/**
 * Created by kmishra on 8/21/2016.
 */
public class Pyramid {

    public static void printPyramid(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.err.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.err.print("# ");
            }
            System.err.println("");
        }
    }

    public static void main(String[] args) {
        printPyramid(4);
    }
}
