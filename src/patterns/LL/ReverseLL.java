package patterns.LL;

import utilites.ListNode;

/***
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * https://leetcode.com/problems/reverse-linked-list/
 *
 */

public class ReverseLL {

    public  static ListNode reverseIterative(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;

        ListNode next = null;

        while(current!= null){

             next = current.next;
             current.next = prev;

             prev = current;
             current = next;

        }
        return prev; // because previous will be the head now

    }

    public static ListNode reverseRecursive(ListNode head){

        // base case
        if(head == null || head.next == null) return head;

        ListNode rest = reverseRecursive(head.next);

        // The rest will be reversed by it self. we need to modify our current head
        head.next.next = head;
        head.next = null;
        return rest;
    }


    public static void main(String[] args) {

        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);

        // link lists
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        ListNode reverse = reverseIterative(firstNode);

        while(reverse!= null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }



        // recursive
        System.out.println("Result from recursive calls");
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        // link lists
        fourth.next = fifth;
        fifth.next = sixth;
        ListNode reverseTwo = reverseIterative(fourth);

        while(reverseTwo!= null){
            System.out.println(reverseTwo.val);
            reverseTwo = reverseTwo.next;
        }
    }
}
