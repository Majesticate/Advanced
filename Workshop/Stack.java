import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Stack {
    private final static int START_CAPACITY = 4;

    private int[] elements;
    private int size;

    public Stack() {
        this.elements = new int[START_CAPACITY];
        this.size = 0;
    }

    public void push(int element) {
        if (size == this.elements.length) {
            this.elements = grow();
        }

        this.elements[size] = element;
        size++;
    }

    public int peek() {
        isEmptyStack();
        return this.elements[size - 1];
    }

    public int pop() {
        int[] newMassive = new int[size - 1];
        isEmptyStack();
        if (size <= elements.length / 4 && size != START_CAPACITY) {
            shrink();
        }

        for (int i = 0; i < size - 1; i++) {
            newMassive[i] = elements[i];
        }
        elements = newMassive;
        size--;
        if (size == 0){
            return 0;
        }
        return elements[size-1];
    }

    private void isEmptyStack() {
        if (size == -1) {
            throw new NoSuchElementException("0 elements in stack");
        }
    }

    private int[] grow() {
        int[] newMassive = new int[this.elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newMassive[i] = elements[i];
        }
        return newMassive;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void shrink() {
        int[] newMassive = new int[this.elements.length / 2];
        for (int i = 0; i < size; i++) {
            newMassive[i] = elements[i];
        }
        this.elements = newMassive;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(this.elements[i]);
        }
    }
}
