import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> map = new TreeMap<>();

        while (n-- > 0){
            String name = scanner.nextLine();
            List<Double> graduates = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
            double sum = graduates.stream().mapToDouble(e -> e).sum();
            double average = sum / graduates.size();
            map.putIfAbsent(name , average);
        }

        map.forEach((k ,v) -> {
            String format = new DecimalFormat("#.#############").format(v);
            System.out.println(k + " is graduated with " +v);
        });
    }
}
