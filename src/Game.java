import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.currentPlayer = playerX;
    }

    public void start() {
        System.out.println("Welcome to Tic Tac Toe Game!");
        Scanner scanner = new Scanner(System.in);
        while (!board.isGameOver()) {
            board.print();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row[1-3] and column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    return;
                }
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        board.print();
        System.out.println("It's a draw!");
    }
}