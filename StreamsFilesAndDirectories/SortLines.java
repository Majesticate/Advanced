import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> list = Files.readAllLines(path);

        List<String> sortedLines = list.stream().sorted().collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new FileWriter("SortLines.txt"));
        for (String sortedLine : sortedLines) {
            writer.write(sortedLine);
            writer.write(System.lineSeparator());
        }
        writer.close();
    }
}
