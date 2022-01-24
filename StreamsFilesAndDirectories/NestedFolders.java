import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {

        String stringPath = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(stringPath);

        Deque<File> deque = new ArrayDeque<>();
        deque.offer(file);

        BufferedWriter out = new BufferedWriter(new FileWriter("NestedFolders.txt"));

        int count = 0;

        while (!deque.isEmpty()) {
            File current = deque.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    deque.offer(nestedFile);
                }
            }
            count++;
            out.write(current.getName());
            out.write(System.lineSeparator());
        }

        out.write(count + " folders");
        out.close();
    }
}
