package patterns.LL;

import utilites.ListNode;

/***
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some ListNode in the list that can be reached again
 * by continuously following the next pointer.
 * Return the length of the linked list
 *
 * Approach : Using slow and fast pointers.
 *            -> if the fast and slow pointers meet at any point , there is a cycle
 *
 */

public class LLCycleLength {

    public int hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                int len = 0 ;
                slow = slow.next;
                while(slow != fast){
                    slow = slow.next;
                }
                return len;
            }
        }
        return 0;
    }


}
