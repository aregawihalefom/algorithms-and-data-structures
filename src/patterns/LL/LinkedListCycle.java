package patterns.LL;

import utilites.ListNode;
import utilites.Node;

/***
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Approach : Using slow and fast pointers.
 *            -> if the fast and slow pointers meet at any point , there is a cycle
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

}
