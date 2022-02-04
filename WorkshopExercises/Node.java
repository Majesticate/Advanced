public class Node {
    public int value;
    public Node next;
    public Node previous;

    public Node(int currentNode) {
        this.value = currentNode;
    }

    @Override
    public String toString() {
        return String.format("%d", this.value);
    }
}
