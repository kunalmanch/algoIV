package my.practice.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Class to shuffle a set of numbers.
 */
public class Shuffle {

    private int[] numCopy;
    private int[] nums;
    private Random rnd;

    public Shuffle(int[] nums) {
        this.numCopy = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
        this.rnd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = numCopy;
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int pos = rnd.nextInt(nums.length - i);
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.err.print(i + " ");
        }
        System.err.println("");
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        Shuffle s = new Shuffle(a);
        print(s.shuffle());
        print(s.shuffle());
        print(s.reset());
        print(s.shuffle());
        print(s.shuffle());
    }
}
