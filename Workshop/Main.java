import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Stack<Integer> arrayDeque = new Stack<>();

        arrayDeque.push(13);
        arrayDeque.push(42);
        arrayDeque.push(69);

        while (!arrayDeque.isEmpty()){
            System.out.println(arrayDeque.pop());
        }

    }
}
