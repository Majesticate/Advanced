import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        FileOutputStream fileOutputStream = new FileOutputStream("writeToFile.txt");

        int currentInt = fileInputStream.read();

        Set<Character> set = Set.of('!' , '?' , '.',',');

        while (currentInt > 0){
            char currentChar = (char) currentInt;
            if (!set.contains(currentChar)){
                fileOutputStream.write(currentChar);
            }
            currentInt = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
