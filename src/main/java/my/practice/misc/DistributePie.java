package my.practice.misc;

/**
 * Created by kmishra on 8/26/2016.
 */
public class DistributePie {

    public static int maxSlices(int[] pieSlices, int people) {
        int totalSlices = 0;
        for (int i = 0; i < pieSlices.length; i++) {
            totalSlices += pieSlices[i];
        }
        int maxPossible = totalSlices / people;
        int maxSlices = maxPossible;
        int numPeople = 0;
        while (maxSlices > 0) {
            for (int slices : pieSlices) {
                numPeople += slices / maxSlices;
            }
            if (numPeople >= people) {
                return maxSlices;
            }
            maxSlices--;
        }
        return maxSlices;
    }

    public static void main(String[] args) {
        int[] slices = {22,7,8};
        System.err.println(maxSlices(slices, 4));
    }
}
