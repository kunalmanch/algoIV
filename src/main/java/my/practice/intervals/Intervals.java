package my.practice.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kmishra on 8/8/2016.
 */
public class Intervals {
    private static class Interval {
        int start;
        int end;

        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    /**
     * Merge intervals.
     */
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end);
        List<Interval> result = new ArrayList<>();

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end < curr.start) {
                result.add(prev);
            } else {
                curr = new Interval(prev.start, Math.max(prev.end, curr.end));
            }
            prev = curr;
        }
        result.add(prev);
        return result;
    }

    /**
     * Add interval into a sorted list of intervals.
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     */
    public static List<Interval> add(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end >= newInterval.start) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }

    /**
     * Interval Scheduling/ Activity Selection. Find max number of activities that can happen in an exclusive manner.
     */
    public static int countEvents(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> i1.end - i2.end);
        Interval prev = intervals.get(0);
        int count = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end <= curr.start) {
                count++;
                prev = curr;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Interval intervals[] = new Interval[5];
        int idx = 0;
        intervals[idx++] = new Interval(1,5);
        intervals[idx++] = new Interval(2,6);
        intervals[idx++] = new Interval(2,9);
        intervals[idx++] = new Interval(9,10);
        intervals[idx++] = new Interval(11,12);
        List<Interval> intervalList = Arrays.asList(intervals);
        List<Interval> mergedList = merge(intervalList);
        for (Interval interval : mergedList) System.err.println(interval);

        idx = 0;
        intervals[idx++] = new Interval(1,2);
        intervals[idx++] = new Interval(3,5);
        intervals[idx++] = new Interval(6,7);
        intervals[idx++] = new Interval(8,10);
        intervals[idx++] = new Interval(12,16);
        mergedList = add(Arrays.asList(intervals), new Interval(4,9));
        for (Interval interval : mergedList) System.err.println(interval);

        //activity selection
        intervals = new Interval[6];
        idx = 0;
        intervals[idx++] = new Interval(1,2);
        intervals[idx++] = new Interval(3,4);
        intervals[idx++] = new Interval(0,6);
        intervals[idx++] = new Interval(5,7);
        intervals[idx++] = new Interval(8,9);
        intervals[idx++] = new Interval(5,9);

        System.err.println(countEvents(Arrays.asList(intervals)));
    }
}
