import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    //head first
    //tail last

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        if (isEmpty()) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
            size++;
        }
    }

    public int removeFirst() {
        Node firstNode = this.head;
        this.head = this.head.next;
        this.head.previous = null;
        size--;
        return firstNode.value;
    }

    public int removeLast(){
        Node lastNode = this.tail;
        this.tail = this.tail.previous;
        this.tail.next = null;
        size--;
        return lastNode.value;
    }

    public int get(int index) {
        isInRange(index);
        Node currentNode = null;
        if (size / 2 > index) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode.value;
    }

    public void forEach(Consumer<Integer> consumer){
        Node currentNode = this.head;
        for (int i = 0; i < size; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node currentNode = this.head;
        int count = 0;

        while (currentNode != null){
            array[count++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    private void isInRange(int index) {
        if (size - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("no such element");
        }
    }


    private boolean isEmpty() {
        return size == 0;
    }

}
