import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws  IOException{

        String pathOfWords = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        BufferedReader readOfWords = new BufferedReader(new FileReader(pathOfWords));

        String[] allWords = readOfWords.readLine().split("\\s+");
        String[] listOfWordsToLowerCase = Arrays.stream(allWords).map(String::toLowerCase).toArray(String[]::new);
        Set<String> allWordsToCheck = Set.of(allWords);

        String pathOfText = "C:\\Users\\Ivan\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        BufferedReader readOfText = new BufferedReader(new FileReader(pathOfText));

        FileWriter fileWriter = new FileWriter("wordCount.txt");

        BufferedWriter writer = new BufferedWriter(new PrintWriter(fileWriter));

        PrintWriter printWriter = new PrintWriter(writer);

        Map<String , Integer> map = new HashMap<>();


        String line = readOfText.readLine();

        while (line != null){
            String[] allWordsOfText = line.split("\\s+");
            Arrays.stream(allWordsOfText).forEach(e -> {
                if (allWordsToCheck.contains(e)){
                    map.putIfAbsent(e, 0);
                    map.put(e , map.get(e) + 1);
                }
            });

            line =  readOfText.readLine();
        }

        StringBuilder stringBuilder = new StringBuilder();
        map.entrySet().stream().sorted((e2, e1) -> e1.getValue().compareTo(e2.getValue())).forEach(e -> {
            stringBuilder.append(e.getKey()).append(" - ").append(e.getValue());
            stringBuilder.append(System.lineSeparator());
        });

        printWriter.write(stringBuilder.toString());
        printWriter.close();
        writer.close();

    }
}
