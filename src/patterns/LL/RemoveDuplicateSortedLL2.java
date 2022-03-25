package patterns.LL;


import utilites.Node;
import utilites.SinglyLinkedList;

import java.util.Objects;

/***
 *
 * Given the head of a sorted linked list,
 * Delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 *
 *  Top point  - Sentinel Header
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
 *
 *
 */

public class RemoveDuplicateSortedLL2 {

    public Node<Integer> deleteDuplicates(Node<Integer> head) {

        Node<Integer> dummyHead = new Node<Integer>(0, head);
        Node<Integer> test = dummyHead;

        Node<Integer> predecessor = dummyHead;

        while (head != null) {

            // if current has duplicates , remove them all
            if (head.next != null && Objects.equals(head.data, head.next.data)) {
                while (head.next != null && Objects.equals(head.data, head.next.data)) {
                    head = head.next;
                }
                predecessor.next = head.next;
            }else {
                predecessor = predecessor.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        RemoveDuplicateSortedLL2 removeDuplicateSortedLL2 = new RemoveDuplicateSortedLL2();
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.add(1);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);

         Node<Integer> result = removeDuplicateSortedLL2.deleteDuplicates(ll.getHead());

         while(result!= null){
             System.out.println(result);
             result = result.next;
         }
    }
}

