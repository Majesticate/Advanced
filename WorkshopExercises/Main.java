import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addFirst(15);

        int[] ints = list.toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
