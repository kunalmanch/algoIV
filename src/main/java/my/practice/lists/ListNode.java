package my.practice.lists;

/**
 * Doubly Linked List Node.
 */
public class ListNode {

    public ListNode prev, next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
