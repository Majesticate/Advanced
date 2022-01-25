import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);

        BufferedWriter writer = new BufferedWriter(new PrintWriter("getFolderSize.txt"));

        PrintWriter printWriter = new PrintWriter(writer);


        long folderSize = 0;

        File[] files = file.listFiles();
        for (File file1 : files) {
            folderSize += file1.length();
        }
        System.out.println(folderSize);
        printWriter.println(folderSize);
        writer.flush();
        writer.close();
        printWriter.close();

    }
}
