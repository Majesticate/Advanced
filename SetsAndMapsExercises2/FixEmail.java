import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , String> map = new LinkedHashMap<>();

        String regex = "^.*(com|us|uk)$";
        Pattern p = Pattern.compile(regex);

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();
            Matcher m = p.matcher(email);
            boolean b = m.matches();
            if (!b){
                map.putIfAbsent(name , email);
            }
            input = scanner.nextLine();
        }
        map.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
