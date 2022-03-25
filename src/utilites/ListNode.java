package utilites;

/***
 *
 *  This class is created for the purpose of leetcode questions
 *
 *
 */
public class ListNode {

     public int val ;
     public ListNode next;

    public ListNode() {
    }

    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {

        System.out.println("Printing LinkedList (head --> last) ");
        ListNode current = this;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null ]");
        return sb.toString();
    }
}
