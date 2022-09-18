import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        String value = "         ";
        int counter = 2;
        boolean shouldContinue = true;

        printFirstBoard(board, value);

        while (shouldContinue) {
            checkingForErrors(scanner, board, counter);
            printBoard(board);
            counter++;
            if (checkingWinner(board, counter) == true) {
                checkingWinner(board, counter);
            } else shouldContinue = false;
        }
    }


    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int x = 0; x < board.length; x++) {
            System.out.print("| ");
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void printFirstBoard(char[][] board, String value) {

        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = value.charAt(counter);
                counter++;
            }
        }

        System.out.println("---------");
        System.out.println("|" + " " + value.charAt(0) + " " + value.charAt(1) + " " + value.charAt(2) + " " + "|");
        System.out.println("|" + " " + value.charAt(3) + " " + value.charAt(4) + " " + value.charAt(5) + " " + "|");
        System.out.println("|" + " " + value.charAt(6) + " " + value.charAt(7) + " " + value.charAt(8) + " " + "|");
        System.out.println("---------");
    }

    public static void checkingForErrors(Scanner scanner, char[][] board, int counter) {
        int coordinate1;
        int coordinate2;
        String[] coordinatesArray;
        String pattern = "[0-9]";
        boolean loop = true;
        char user;

        if (counter % 2 == 0) {
            user = 'X';
        } else user = 'O';

        do {
            String coordinatesString = scanner.nextLine();
            coordinatesArray = coordinatesString.split(" ");


            if (!coordinatesArray[0].matches(pattern) || !coordinatesArray[1].matches(pattern)) {
                System.out.println("You should enter numbers!");
            } else {
                coordinate1 = Integer.parseInt(coordinatesArray[0]);
                coordinate2 = Integer.parseInt(coordinatesArray[1]);
                if (coordinate1 < 1 || coordinate1 > 3 || coordinate2 > 3 || coordinate2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[coordinate1 - 1][coordinate2 - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[coordinate1 - 1][coordinate2 - 1] = user;
                    loop = false;
                }
            }
        } while (loop);
    }

    public static boolean checkingWinner(char[][] board, int counter) {

        boolean shouldContinue = true;


        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            System.out.println(board[0][0] + " wins");
            shouldContinue = false;

        } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')) {
            System.out.println(board[1][0] + " wins");
            shouldContinue = false;

        } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')) {
            System.out.println(board[2][0] + " wins");
            shouldContinue = false;

        } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            System.out.println(board[0][0] + " wins");
            shouldContinue = false;

        } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')) {
            System.out.println(board[0][1] + " wins");
            shouldContinue = false;

        } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')) {
            System.out.println(board[0][2] + " wins");
            shouldContinue = false;

        } else if (board[0][0] == board [1][1] && board[1][1] == board[2][2] && (board[1][1] == 'X' || board[1][1] == 'O')) {
            System.out.println(board[1][1] + " wins");
            shouldContinue =false;

        }else if (board[0][2] == board [1][1] && board[1][1] == board[2][0] && (board[1][1] == 'X' || board[1][1] == 'O')){
            System.out.println(board[1][1] + " wins");
            shouldContinue = false;

        }else if (counter == 11){
            System.out.println("Draw");
            shouldContinue = false;
        }
        return shouldContinue;
    }
}