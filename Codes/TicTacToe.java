import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
            '1','2','3',
            '4','5','6',
            '7','8','9'
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int moves = 0;
        boolean gameEnded = false;

        while (!gameEnded) {

            printBoard();

            System.out.println("Player " + currentPlayer + ", enter slot number (1-9): ");

            try {
                int choice = sc.nextInt();

                if (choice < 1 || choice > 9) {
                    System.out.println("Invalid slot! Choose between 1-9.");
                    continue;
                }

                if (board[choice - 1] == 'X' || board[choice - 1] == 'O') {
                    System.out.println("Slot already filled! Try again.");
                    continue;
                }

                board[choice - 1] = currentPlayer;
                moves++;

                if (checkWinner()) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine(); // clear buffer
            }
        }

        sc.close();
    }

    public static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public static boolean checkWinner() {

        int[][] winPositions = {
                {0,1,2},{3,4,5},{6,7,8},   // rows
                {0,3,6},{1,4,7},{2,5,8},   // columns
                {0,4,8},{2,4,6}            // diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == currentPlayer &&
                board[pos[1]] == currentPlayer &&
                board[pos[2]] == currentPlayer) {
                return true;
            }
        }

        return false;
    }
}