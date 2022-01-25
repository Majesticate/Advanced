import java.io.*;

public class LineNumbers {
    public static void main(String[] args)throws IOException
    {
        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        FileWriter fileWriter = new FileWriter("LineNumbers.txt");

        BufferedWriter writer = new BufferedWriter(new PrintWriter(fileWriter));

        PrintWriter printWriter = new PrintWriter(writer);

        String fullLine = reader.readLine();
        int countOfLines = 1;
        while (fullLine != null){
            printWriter.printf("%d. %s%n" , countOfLines ,fullLine);
            countOfLines++;
            fullLine = reader.readLine();
        }
        printWriter.close();
        writer.close();
    }
}
