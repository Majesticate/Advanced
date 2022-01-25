import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String path1 = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";

        String path2 = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        BufferedReader readerPath1 = new BufferedReader(new FileReader(path1));

        List<String> listOfAllElementsInPath1 = Files.readAllLines(Path.of(path2));

        BufferedReader readerPath2 = new BufferedReader(new FileReader(path2));

        BufferedWriter writer = new BufferedWriter(new PrintWriter("mergeTwoFiles.txt"));


        int read = readerPath1.read();
        int read2 = readerPath2.read();

        Deque<Integer> deque = new ArrayDeque<>();

        while (read > 0) {
            String value = String.valueOf(read);
            if (listOfAllElementsInPath1.contains(value)) {
                writer.write(read);
            } else {
                writer.write(read);
                deque.offer(read2);
                writer.flush();
            }
            read2 = readerPath2.read();
            read = readerPath1.read();
        }
        writer.write(System.lineSeparator());
        while (!deque.isEmpty()) {
            writer.write(deque.poll());
        }
        writer.close();
    }
}
