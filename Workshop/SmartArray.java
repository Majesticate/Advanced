import java.util.function.Consumer;

public class SmartArray {
    private final static int START_CAPACITY = 4;

    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[START_CAPACITY];
        this.size = 0;
    }

    public void add(int element) {
        if (size == this.elements.length) {
            this.elements = grow();
        }

        this.elements[size] = element;
        size++;
    }

    public int get(int index) {
        isOutOfBounds(index);
        return this.elements[index];
    }

    public int remove(int index) {
        isOutOfBounds(index);
        int removedElement = this.elements[index];

        if (size <= elements.length / 4 && size != START_CAPACITY) {
            shrink();
        }

        for (int i = index; i < size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        size--;
        return removedElement;
    }


    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int element, int index) {
        isOutOfBounds(index);
        if (size == this.elements.length) {
            this.elements = grow();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(elements[i]);
        }
    }

    private int[] grow() {
        int[] newMassive = new int[this.elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newMassive[i] = elements[i];
        }
        return newMassive;
    }

    private void isOutOfBounds(int index) {
        if (index < size || index < 0) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("not valid index");
    }
    private void shrink() {
        int[] newMassive = new int[this.elements.length / 2];
        for (int i = 0; i < size; i++) {
            newMassive[i] = elements[i];
        }
        this.elements = newMassive;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
