package patterns.LL;

import utilites.ListNode;

/***
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *  Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Idea : Modification of the question that asks reversing LL in between
 *        - Keep the connections
 *        - connect the latter after finishing operations
 *
 */

public class ReverseKGroup {

    public  static  ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        ListNode prev= null;
        ListNode next = current.next;
        int count = k;

         while(true){

             while (count > 0 && current != null) {
                 current = current.next;
                 System.out.println(current.val);
                 count--;
             }

             if(current == null) break;;
         }

        return head;
    }

    public static void main(String[] args) {

        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);

        // link lists
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        System.out.println("Result from recursive calls");
        ListNode fourth = new ListNode(4);
        fourth.next = new ListNode(5);
        thirdNode.next = fourth;
        System.out.println(firstNode);
       // System.out.println(reverseKGroup(firstNode, 3));;


    }
}
