import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileOutputStream fileOutputStream = new FileOutputStream("WriteEveryThirdLine.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        String line = bufferedReader.readLine();

        int count = 1;

        while (line != null){
            if (count % 3 == 0){
                printWriter.write(line);
                printWriter.write(System.lineSeparator());
            }
            line = bufferedReader.readLine();
            count++;
        }
        printWriter.close();

    }
}
