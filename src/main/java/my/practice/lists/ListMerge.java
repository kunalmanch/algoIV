package my.practice.lists;

/**
 * Created by kmishra on 8/13/2016.
 */
public class ListMerge {

    public static int mergePoint(ListNode l1, ListNode l2) {
        int l1Length = length(l1);
        int l2Length = length(l2);

        int diff = Math.abs(l1Length - l2Length);
        ListNode greater, smaller;
        if (l1Length > l2Length) {
            greater = l1;
            smaller = l2;
        } else {
            greater = l2;
            smaller = l1;
        }
        while (diff > 0) {
            diff--;
            greater = greater.next;
        }

        while (greater != null && smaller != null) {
            if (greater.val == smaller.val) return smaller.val;
            greater = greater.next;
            smaller = smaller.next;
        }
        return -1;
    }

    public static int length(ListNode l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        System.err.println(mergePoint(l1, l2));
    }
}
