package my.practice.misc;

import my.practice.lists.DoublyLinkedList;
import my.practice.lists.ListNode;

import java.util.*;

/**
 * Created by kmishra on 8/7/2016.
 */
public class Misc {

    /**
     * Given an array of numbers ,
     * replace each number with the product of all the numbers
     * divided by the number at that index without using the division operator
     */
    public static void printProducts(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];

        int product = 1;
        for (int i = 0; i < a.length; i++) {
            left[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            right[i] = product;
            product *= a[i];
        }

        for (int i = 0; i < a.length; i++) {
            System.err.println(left[i] * right[i]);
        }
    }

    public static int firstUnique(int[] a) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Map<Integer, ListNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            if (map.containsKey(node.val)) {
                if (set.contains(node.val)) continue;
                set.add(node.val);
                ListNode toRemove = map.get(node.val);
                dll.remove(toRemove);
                map.remove(node.val);
            } else if (!set.contains(node.val)) {
                map.put(node.val, node);
                dll.addLast(node);
            }
        }
        return dll.head().val;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        printProducts(a);
        int[] b = {0,0,0,1,-1,1,4,2,2,3};
        System.err.println(firstUnique(b));
    }
}
