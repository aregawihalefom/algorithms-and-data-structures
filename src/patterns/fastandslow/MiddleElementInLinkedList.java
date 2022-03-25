package patterns.fastandslow;


import utilites.Node;
import utilites.SinglyLinkedList;

/****
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 *
 */

public class MiddleElementInLinkedList {

    public static Node<Integer> middleNode(Node<Integer> head) {

        if(head == null) return null;
        Node<Integer> fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> testCase1  = new SinglyLinkedList<>();
        testCase1.add(1);testCase1.add(2);testCase1.add(3);testCase1.add(4);testCase1.add(5);
        System.out.println(middleNode(testCase1.getHead()));
    }
}
