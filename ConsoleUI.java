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
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board.getPieceAt(i, j) + " ");
            }
            System.out.println();
        }
    }


    public int[] getMove(Player player, Board board) {
        int[] move = new int[2];
        if (player instanceof HumanPlayer){
            System.out.print(player.getName() + ", enter row and column numbers (e.g. 1 2) or -1 to quit: ");
            move[0] = scanner.nextInt();
            if (move[0] == -1){
                System.exit(0);
            }
            move[1] = scanner.nextInt();
        }else {
            move = ((ComputerPlayer) player).makeMove(board);
            System.out.println(player.getName() + " played at row " + (move[0]) + " column " + (move[1] ));
        }
        return move;   
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
