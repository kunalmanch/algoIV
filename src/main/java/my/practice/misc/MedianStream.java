package my.practice.misc;

import java.util.PriorityQueue;

/**
 * Given an unsorted stream, find its median.
 */
public class MedianStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, (i1, i2) -> i2 - i1);

    public void add(int n) {
        if (maxHeap.isEmpty()) {
            minHeap.add(n);
        } else if (n >= minHeap.peek()) {
            minHeap.add(n);
        } else {
            maxHeap.add(n);
        }

        if (maxHeap.size() -  minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    public int median() {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) return -1;
        if (size % 2 == 0) return (minHeap.peek() + maxHeap.peek()) / 2;
        if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianStream ms = new MedianStream();
        ms.add(5);
        ms.add(1);
        System.err.println(ms.median());
        ms.add(2);
        System.err.println(ms.median());
        ms.add(3);
        ms.add(4);
        System.err.println(ms.median());
    }
}
