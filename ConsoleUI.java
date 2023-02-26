package noapplet.assignments.HW2;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
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

    public Coordinate getMove(Player player, Board board) {
        Coordinate move = null;
        if (player instanceof HumanPlayer) {
            int m = chooseMove();
            if(m == 1){
                System.out.print(player.getName() + ", enter row and column numbers (e.g. 1 2) or -1 to quit: ");
                int x = scanner.nextInt();
                if (x == -1) {
                    System.exit(0);
                }
                int y = scanner.nextInt();
                move = new Coordinate(x, y);
            }else{
                move = board.getSuggestion(player.getSymbol());
                System.out.println(player.getName() + " played at " + move.toString());
            }
        } else {
            move = ((ComputerPlayer) player).makeMove(board);       
            System.out.println(player.getName() + " played at " + move.toString());
        }
        return move;
    }

    public int chooseMove(){
        System.out.println("Please choose one of the following");
        System.out.println("1. Choose Row and Column");
        System.out.println("2. Enable CheatMode");
        return scanner.nextInt();
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
