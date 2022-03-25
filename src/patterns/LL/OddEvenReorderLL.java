package patterns.LL;

import utilites.ListNode;

import java.util.List;

/**
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by
 * the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 */

public class OddEvenReorderLL {

    public  static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode evenHead = head.next;

        ListNode oddPtr = head;
        ListNode evenPtr = evenHead;


        while(oddPtr.next != null && evenPtr.next != null){
            oddPtr.next = oddPtr.next.next;
            evenPtr.next = evenPtr.next.next;

            // Move pointers
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;
        }

        // When odd - odd will be on the last element - append
        // When even elements even will be on the last - replace last of odd
        oddPtr.next = evenHead;

        return  head;
    }

    public static void main(String[] args) {


        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);

        // link lists
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        ListNode fourth = new ListNode(4);
        thirdNode.next = fourth;

        ListNode fifth = new ListNode(5);
        fourth.next = fifth;

        ListNode six = new ListNode(6);
        fifth.next = six;

        ListNode seven = new ListNode(7);
        six.next = seven;

        System.out.println(firstNode);
        System.out.println( oddEvenList(firstNode));;

    }


}
