package my.practice.misc;

/**
 *  A majority element in an array A[] of size n is an element that appears more than n/2 times.
 */
public class MajorityElement {

    public static int majorityElement(int[] a) {
        int counter = 0;
        int majIdx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[majIdx] == a[i]) {
                counter++;
            } else if (counter == 0){
                majIdx = i;
                counter = 1;
            } else {
                counter--;
            }
        }
        return a[majIdx];
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,3,3};
        System.err.println(majorityElement(a));
    }
}
