import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListFiles {
    public static void main(String[] args) throws IOException {

        String path = ("C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File file = new File(path);
        File[] files = file.listFiles();

        BufferedWriter out = new BufferedWriter(new FileWriter("ListFiles.txt"));

        String illusionPath ="C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\";

        for (File fileName : files) {
            if (fileName.isFile()) {
                Path realPath = Path.of(illusionPath + fileName.getName());
                out.write(fileName.getName() + ": [" + Files.size(realPath)+"]");
                out.write(System.lineSeparator());
            }

        }
        out.flush();
        out.close();
    }
}
