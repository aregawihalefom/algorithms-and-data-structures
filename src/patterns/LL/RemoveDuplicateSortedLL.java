package patterns.LL;

import utilites.ListNode;
import utilites.Node;
import utilites.SinglyLinkedList;

import java.util.Objects;

/***
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 *
 *
 *
 */

public class RemoveDuplicateSortedLL {

    public Node<Integer> removeDuplicates(Node<Integer> head){

        // If only two elements
        if(head == null || head.next == null) return head;

        //
        Node<Integer> previous = head;
        Node<Integer> current = head.next;
        while(current != null){
            // compare node
            if(!Objects.equals(current.getData(), previous.getData())){
                previous.next = current;
                previous = current;
            }
            current = current.next;
        }
        previous.next = null;
        return head;
    }


    /**
     *
     *  Using the fact that an element  of LL can at most be two
     *
     * @param head
     */

    public ListNode removeDuplicates(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode current = head;

        while(current.next!= null){
            if(current.val == current.next.val){
                current.next= current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        RemoveDuplicateSortedLL removeDuplicateSortedLL =  new RemoveDuplicateSortedLL();
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.add(1);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);

        Node<Integer> nonDup = removeDuplicateSortedLL.removeDuplicates(ll.getHead());
        Node<Integer> current = nonDup;

        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        while(current != null){
            result.add(current.getData());
            current  = current.next;
        }

        System.out.println(result);
    }

}
