import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        String value = "_________";
        int counter = 2;
        boolean shouldContinue = true;


        printFirstBoard(board, value);

        while (shouldContinue) {
            checkingForErrors(scanner, board, counter, intList, arrayList);
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
        System.out.println("Hello!");
        System.out.println("In front of you is a Tic-Tac-Toe Game!");
        System.out.println("Press the appropriately assigned number from 1 to 9 into the box where you want to insert an X.");
        System.out.println("Then the computer makes the move, and so on and so forth! Enjoy the game!");
        System.out.println();
        System.out.println("---------");
        System.out.println("|" + " 1 2 3 " + "|");
        System.out.println("|" + " 4 5 6 " + "|");
        System.out.println("|" + " 7 8 9 " + "|");
        System.out.println("---------");

        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = value.charAt(counter);
                counter++;
            }
        }

    }

    public static void checkingForErrors(Scanner scanner, char[][] board, int counter, ArrayList<Integer> intList, ArrayList<Integer> arrayList) {

        int coordinate;
        boolean loop = true;
        boolean shouldContinue = true;

        char user;
        for (int i = 1; i < 10; i++) {
            intList.add(i);
        }

        Random random = new Random();

        do {
            try {
                if (counter % 2 == 0) {
                    user = 'X';

                    System.out.println("YOUR MOVE!");
                    coordinate = scanner.nextInt();
                    arrayList.add(coordinate);
                } else {
                    Thread.sleep(1000);
                    user = 'O';
                    do {
                        int index = random.nextInt(0, 9) + 1;
                        coordinate = index;
                        if (!arrayList.contains(coordinate)) {
                            System.out.println("PC MOVE!");
                            arrayList.add(index);
                            shouldContinue = false;
                        }
                    } while (shouldContinue);
                }
                if (!intList.contains(coordinate)){
                    System.out.println("You should enter numbers from 1 to 9!");
                }else
                switch (coordinate) {
                    case 1 -> {
                        if (board[0][0] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[0][0] = user;
                            loop = false;
                        }
                    }
                    case 2 -> {
                        if (board[0][1] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[0][1] = user;
                            loop = false;
                        }
                    }
                    case 3 -> {
                        if (board[0][2] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[0][2] = user;
                            loop = false;
                        }
                    }
                    case 4 -> {
                        if (board[1][0] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[1][0] = user;
                            loop = false;
                        }
                    }
                    case 5 -> {
                        if (board[1][1] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[1][1] = user;
                            loop = false;
                        }
                    }
                    case 6 -> {
                        if (board[1][2] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[1][2] = user;
                            loop = false;
                        }
                    }
                    case 7 -> {
                        if (board[2][0] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[2][0] = user;
                            loop = false;
                        }
                    }
                    case 8 -> {
                        if (board[2][1] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[2][1] = user;
                            loop = false;
                        }
                    }
                    case 9 -> {
                        if (board[2][2] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[2][2] = user;
                            loop = false;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter NUMBERS");
                scanner.nextLine();
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

        } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[1][1] == 'X' || board[1][1] == 'O')) {
            System.out.println(board[1][1] + " wins");
            shouldContinue = false;

        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && (board[1][1] == 'X' || board[1][1] == 'O')) {
            System.out.println(board[1][1] + " wins");
            shouldContinue = false;

        } else if (counter == 11) {
            System.out.println("Draw");
            shouldContinue = false;
        }
        return shouldContinue;
    }
}