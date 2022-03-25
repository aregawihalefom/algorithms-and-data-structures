package patterns.LL;

import utilites.ListNode;

import java.util.List;

/***
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *  L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 *  L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 *  You may not modify the values in the list's nodes. Only nodes themselves may be changed
 *
 *
 *  Idea :  - get the middle element
 *          - reverse the second half of the array
 *          - Shuffle the two halves
 *
 */
public class ListZipping {

    public void reorderList(ListNode head) {

    }

    public ListNode getMiddle(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null || fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;
    }




}