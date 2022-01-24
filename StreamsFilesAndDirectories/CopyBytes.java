import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        FileOutputStream out = new FileOutputStream("CopyBytes.txt");

        PrintStream printStream = new PrintStream(out);

        int value = fileInputStream.read();

        while (value > 0) {
            if (value != 32 && value != 10) {
                printStream.print(value);
            } else {
                printStream.print((char) value);
            }

            value = fileInputStream.read();
        }
    }
}
