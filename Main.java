import java.util.*;
public class Main {
    public char player;
    public char[][] board = new char[3][3];
    Scanner sc = new Scanner(System.in);
    Main() {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }
    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }

    public void play() {
        //choosing Player
        choosePlayer();
        boolean gameOver = false;
        while (!gameOver) {
            printBoard();
            System.out.printf("Player [%c] enter move (row col): ", player);
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon()) {
                    printBoard();
                    System.out.printf("Player [%c] has won!\n", player);
                    return;
                }
                if (isDraw()) {
                    printBoard();
                    System.out.println("It's a Draw!");
                    return;
                }
                player = (player == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move, Try again!\n");
            }
        }
    }

    public void choosePlayer() {
        while (true) {
            System.out.println("### Select your Player ###");
            System.out.println("a. X");
            System.out.println("b. O");
            System.out.println("q. Quit");
            System.out.print("Enter choice: ");
            String choice = sc.next().toLowerCase();
            //Handling player selection
            switch (choice) {
                case "a":
                    player = 'X';
                    return;
                case "b":
                    player = 'O';
                    return;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("-> Invalid selection\n");
            }
        }
    }
    //Printing the board
    public void printBoard() {
    System.out.print("  ");
    for (int j = 0; j < 3; j++) {
        System.out.print(j + "   ");
    }
    System.out.println();

    for (int i = 0; i < 3; i++) {
        System.out.print(i + " ");
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " | ");
        }
        System.out.println();
    }
    System.out.println();
}

//Checking winning condition
    public boolean haveWon() {
        // rows
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        // columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
//Checking draw condition
    public boolean isDraw() {
        for (char[] row : board) {
            for (char c : row) {
                if (c == ' ') return false;
            }
        }
        return true;
    }
}
