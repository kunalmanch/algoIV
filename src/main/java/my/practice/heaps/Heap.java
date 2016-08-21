package my.practice.heaps;


import java.util.Arrays;

/**
 * Created by kmishra on 8/18/2016.
 */
public class Heap {

    private int n;
    private int[] a;

    public Heap(int[] a) {
        this.a = Arrays.copyOf(a, a.length);
        n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;

        if (l < n && a[l] < a[min]) {
            min = l;
        }

        if (r < n && a[r] < a[min]) {
            min = r;
        }

        if (min != i) {
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            heapify(min);
        }
    }

    public void add(int i) {
        a[n++] = i;
        int curr = n - 1;

        while (curr > 0 && a[curr] < a[curr / 2]) {
            int temp = a[curr];
            a[curr] = a[curr / 2];
            a[curr / 2] = temp;
            curr /= 2;
        }
    }

    public int poll() {
        if (n == 0) {
            System.err.println("error");
            return -1;
        }
        int min = a[0];
        int temp = a[0];
        a[0] = a[n - 1];
        a[n - 1] = temp;
        n--;
        heapify(0);
        return min;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,4};
        Heap heap = new Heap(a);
        System.err.println(heap.poll());
        System.err.println(heap.poll());
        System.err.println(heap.poll());
        heap.add(1);
        System.err.println(heap.poll());
    }
}
