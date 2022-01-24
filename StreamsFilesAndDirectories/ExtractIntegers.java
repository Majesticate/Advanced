import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(fileInputStream);

        FileOutputStream out = new FileOutputStream("ExtractIntegers.txt");

        PrintStream printStream = new PrintStream(out);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                printStream.println(number);
            }
            scanner.next();
        }


    }
}
