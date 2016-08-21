package my.practice.sort;

import my.practice.lists.ListNode;

/**
 * Created by kmishra on 8/11/2016.
 */
public class Lists {

    public static ListNode mergeUnique(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode root = helper;
        int prevl1 = Integer.MIN_VALUE;
        int prevl2 = Integer.MIN_VALUE;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    if (prevl2 != l1.val) {
                        root.next = l1;
                        root = root.next;
                        prevl1 = root.val;
                    } else {
                        prevl2 = Integer.MIN_VALUE;
                    }
                    l1 = l1.next;
                } else {
                    if (prevl1 != l1.val) {
                        root.next = l2;
                        root = root.next;
                        prevl2 = root.val;
                    } else {
                        prevl1 = Integer.MIN_VALUE;
                    }
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                root.next = l1;
                break;
            } else {
                root.next = l2;
                break;
            }
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(9);

        ListNode root = mergeUnique(l1, l2);
        while (root != null) {
            System.err.println(root.val);
            root = root.next;
        }
    }
}
