package my.practice.misc;

/**
 * Created by kmishra on 8/14/2016.
 */
public class DateDiff {

    /**
     * difference between two dates.
     * date is represented through an array.
     * 0th idx = month
     * 1st idx = day
     * 2nd idx = year
     */
    public static int diff(int[] date1, int[] date2) {
        return Math.abs(daysSinceBeg(date1) - daysSinceBeg(date2));
    }

    private static int daysSinceBeg(int[] date) {
        int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = date[0];
        int day = date[1];
        int year = date[2];

        int days = 365 * year + day;

        for (int i = 0; i < month - 1; i++)
            days += monthDays[i];

        return days + numberOfLeapYears(year, month);
    }

    private static int numberOfLeapYears(int year, int month) {
        if (month <= 2) {
            year--;
        }
        return year / 4 - year / 100 + year / 400;
    }

    public static void main(String[] args) {
        int[] dt1 = {1, 2, 2000};
        int[] dt2 = {1, 2, 2004};
        System.err.println(diff(dt1, dt2));
    }
}
