import java.util.Scanner;

public class PawnWars {

    public static int whiteRow;
    public static int whiteColl;
    public static int blackRow;
    public static int blackColl;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j];
                if (input[j] == 'w') {
                    whiteRow = i;
                    whiteColl = j;
                } else if (input[j] == 'b') {
                    blackRow = i;
                    blackColl = j;
                }
            }

        }
        boolean gameEnd = false;

        while (!gameEnd) {
            if (whiteRow == blackRow + 1 && (blackColl == whiteColl - 1 || blackColl == whiteColl + 1)) {
                System.out.printf("Game over! White capture on %c%d.",(char) 97 + blackColl, matrix.length - blackRow);
                gameEnd = true;
            }
            whiteRow--;
            matrix[whiteRow][whiteColl] = 'w';
            matrix[whiteRow+1][whiteColl] = '-';
            if (blackRow == whiteRow - 1 && (blackColl == whiteColl - 1 || blackColl == whiteColl + 1)) {
                System.out.printf("Game over! Black capture on %c%d.",(char) 97 + whiteColl, matrix.length - whiteRow);
                gameEnd = true;
            }
            blackRow++;
            matrix[blackRow][blackColl] = 'w';
            matrix[blackRow-1][blackColl] = '-';
            if (whiteRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %c8.", (char) 97+ whiteColl);
                gameEnd = true;
            } else if (blackRow == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %c1.", (char) 97+ blackColl);
                gameEnd = true;
            }
        }
    }
}
