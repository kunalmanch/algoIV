package my.practice.lists;

/**
 * Double Linked List implementation.
 */
public class DoublyLinkedList {

    private ListNode head = null, last = null, middle = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public ListNode head() {
        return head;
    }

    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        addFirst(node);
    }

    public void addFirst(ListNode node) {
        if (!isEmpty()) {
            node.next = head;
            head.prev = node;
        } else {
            last = node;
            middle = node;
        }
        head = node;
        size++;
        if (size > 1) {
            if (size % 2 != 0) {
                middle = middle.prev;
            }
        }
    }

    public void addLast(int val) {
        ListNode node = new ListNode(val);
        addLast(node);
    }

    public void addLast(ListNode node) {
        if (!isEmpty()) {
            node.prev = last;
            last.next = node;
        } else {
            head = node;
            middle = node;
        }
        last = node;
        size++;
        if (size > 1) {
            if (size % 2 != 0) {
                middle = middle.next;
            }
        }
    }

    public ListNode getMiddle() {
        return middle;
    }

    public void removeFirst() {
        if (isEmpty()) return;
        middle = size % 2 == 0 ? middle.next : middle;
        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;
        middle = size % 2 == 0 ? middle : middle.prev;
        if (last.prev != null) {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
    }

    public void remove(ListNode node) {
        if (isEmpty()) return;
        if (node == head) {
            removeFirst();
            return;
        } else if (node == last) {
            removeLast();
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void removeMiddle() {
        if (middle == null) return;
        ListNode oldMiddle = middle;
        middle = size % 2 == 0 ? middle.next : middle.prev;
        remove(oldMiddle);

    }

    public void reverse( ) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            prev = curr.prev;
            curr.next = prev;
            curr.prev = next;
            curr = next;
        }
        head = prev == null ? head : prev.prev;
    }

    public static String toString(DoublyLinkedList dll) {
        return toString(dll.head);
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node.next != null) {
            sb.append(node.val);
            sb.append("-->");
            node = node.next;
        }
        sb.append(node.val);
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(3);
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.addFirst(2);
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.addFirst(1);
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.addLast(4);
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.addLast(5);
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.removeFirst();
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.removeMiddle();
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));
        dll.reverse();
        System.err.println(dll.getMiddle());
        System.err.println(toString(dll));

    }
}
