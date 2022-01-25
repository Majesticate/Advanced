import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        FileWriter fileWriter = new FileWriter("output.txt");

        BufferedWriter writer = new BufferedWriter(fileWriter);

        int current = reader.read();

        while (current > 0){
            if (Character.isAlphabetic(current)){
                writer.write(Character.toUpperCase(current));
            }else {
                writer.write(current);
            }

            current = reader.read();
        }

        writer.close();
        reader.close();
    }
}
