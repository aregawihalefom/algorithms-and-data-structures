package utilites;

public class SinglyLinkedList<T> {

    private Node<T> head;

    private int size =0;

    public boolean isEmpty(){
        return head == null;
    }


    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     *  Adds an element to the end of the linkedlist
     * @param data - generic type
     */
    public void add(T data){

        Node<T> newNode = new Node<>(data);
        if(head == null) head = newNode;
        else{

            Node<T> current = head;

            // add at the end
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean remove(T data){

        Node<T> prev = new Node<>();
        prev.next = head;

        // next node
        Node<T> next = head.next;

        // traversal node
        Node<T> current = head;

        // check if the node to be removed is the head
        if(head.data == data){
            head = head.next.next;
        }

        // otherwise, find the array element in the linkedlist
        while(current.next !=null){

            if(String.valueOf(data).equals(String.valueOf(current.data))){
                // skip the current and put the next of previous to next
                prev.next = current.next;
                size--;
                return  true;
            }
            prev = current;
            current = current.next;
        }

        // if so far not deleted that means its the last node
        if(String.valueOf(data).equals(String.valueOf(current.data))){
            prev.next = null;
            return true;
        }
        return false;
    }

    public void insertRec(int val , int index){

    }

    @Override
    public String toString() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current);
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public Node<T> getHead() {
        return head;
    }
}
