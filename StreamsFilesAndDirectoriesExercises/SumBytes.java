import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();


        int sumOfAllLines= 0;
        while (line != null) {
            char[] toStringArray = line.toCharArray();
            int countCurrentLineSum = 0;
            for (char c : toStringArray) {
                countCurrentLineSum += (c);
            }

            sumOfAllLines += countCurrentLineSum;
            line = bufferedReader.readLine();
        }
        System.out.println(sumOfAllLines);
    }
}
