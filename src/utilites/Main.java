package utilites;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

    }
}
