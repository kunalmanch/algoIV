package my.practice.lists;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/13/2016.
 */
public class DuplicateList {

    public static ListNode removeDuplicate(ListNode l) {
        Set<Integer> set = new HashSet<>();
        ListNode helper = new ListNode(0);
        helper.next = l;
        ListNode prev = helper, curr = l;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(4);
        l = removeDuplicate(l);
        while (l != null) {
            System.err.println(l.val);
            l = l.next;
        }
    }
}
