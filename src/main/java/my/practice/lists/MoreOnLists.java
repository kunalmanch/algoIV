package my.practice.lists;

/**
 * Created by kmishra on 8/14/2016.
 */
public class MoreOnLists {

    public static int findNFromEnd(ListNode l, int n) {
        ListNode slow = l, fast = l;

        while (fast != null && n-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.err.println(findNFromEnd(l, 2));
    }
}
