package noapplet.assignments.HW2;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public int chooseGameMode() {
        System.out.println("Choose game mode: ");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        return scanner.nextInt();
    }

    public String getPlayerName(int playerNumber) {
        System.out.print("Enter name for player " + playerNumber + ": ");
        return scanner.next();
    }

    public void showBoard(Board board) {
        int size = board.getSize();
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(board.getPieceAt(i, j) + " ");
            }
            System.out.println();
        }
    }


    public int[] getMove(Player player, Board board) {
        System.out.print(player.getName() + ", enter row and column numbers (e.g. 1 2) or -1 to quit: ");
        int row = scanner.nextInt();
        if (row == -1){
            System.exit(0);
        }
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    public void showInvalidMove() {
        System.out.println("Invalid move. Please try again.");
    }

    public void showWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }

    public void showTie() {
        System.out.println("It's a tie!");
    }

    public void GameModeError(){
        System.out.println("Please choose a valid option!");
    }
}
