package patterns.LL;

import utilites.ListNode;

/***
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * // [ 1, 2 , 3, 4, 5]
 *
 *
 */

public class ReverseLL2 {


    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode current = head;
        ListNode prev= null;

        // go until the left
        while(left - 1  > 0){
            prev = current;
            current = current.next;
            left--;
            right--;
        }

        // Now keep references
        ListNode savePrevious = prev , newEnd = current;
        ListNode next = current.next;

        // Now start reversing
        while( right > 0 && current!= null){

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            right--;
        }
        if(savePrevious!= null){
            savePrevious.next = prev; // connect with the reversed
        }else
            head = prev; // That means left was the first node

        // connect the last as well
        newEnd.next = current;

        return head;
    }

    public static  ListNode reverseLL(ListNode head , int count){

        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current!= null && count >= 0){

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }
        //if(current.next != null) current.next = null;
        return prev;
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

        System.out.println( reverseBetween(firstNode, 2, 4));;


    }
}
