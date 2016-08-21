package my.practice.lists;

/**
 * Created by kmishra on 8/17/2016.
 */
public class InsertCyclicList {

    public static ListNode insert(ListNode head, ListNode newNode) {
        if (head == null) return newNode;
        //find the last node.
        ListNode curr = head.next;
        while (curr != null && curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
        return head;
    }

    public static void printCylicList(ListNode head) {
        if (head == null) return;
        System.err.println(head.val);
        if (head.next == null) return;
        ListNode curr = head.next;
        while (curr != null && curr.next != head) {
            System.err.println(curr.val);
            curr = curr.next;
        }
        if (curr != null) System.err.println(curr.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;
//        printCylicList(head);
        insert(head, new ListNode(6));
        printCylicList(head);
    }
}
