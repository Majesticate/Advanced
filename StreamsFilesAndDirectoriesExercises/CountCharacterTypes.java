import java.io.*;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        FileWriter fileWriter = new FileWriter("CountTypes.txt");

        BufferedWriter writer = new BufferedWriter(new PrintWriter(fileWriter));

        PrintWriter printWriter = new PrintWriter(writer);

        Set<Character> vowels = Set.of('a', 'o', 'u', 'e', 'i');
        int countOfVoWels = 0;

        Set<Character> punctuations = Set.of('!', '.', ',', '?');
        int countOfPunctuations = 0;

        int consonants = 0;

        int read = reader.read();

        while (read > 0) {
            char currentChar = (char) read;
            if (vowels.contains(currentChar)) {
                countOfVoWels++;
            } else if (punctuations.contains(currentChar)) {
                countOfPunctuations++;
            } else {
                if (read != 32 && read != 10 && read != 13){
                    consonants++;
                }
            }
            read = reader.read();
        }

        printWriter.printf("Vowels: %d%n" , countOfVoWels);
        printWriter.printf("Consonants: %d%n" , consonants);
        printWriter.printf("Punctuation: %d" , countOfPunctuations);
        reader.close();
        writer.close();
        printWriter.close();
    }
}
