package noapplet.assignments.HW2;

import java.util.ArrayList;
import java.util.List;

public class Gomoku {
    private ConsoleUI ui;
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;

    public Gomoku() {
        this.ui = new ConsoleUI();
        this.board = new Board(15);
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void start() {
        int gameMode = ui.chooseGameMode();
        if (gameMode == 1) {
            players.add(new HumanPlayer(ui.getPlayerName(1), 'X'));
            players.add(new HumanPlayer(ui.getPlayerName(2), 'O'));
        } else {
            players.add(new HumanPlayer(ui.getPlayerName(1), 'X'));
            players.add(new ComputerPlayer("Computer", 'O'));
        }

        board.initializeBoard();
        Player currentPlayer = players.get(currentPlayerIndex);
        ui.showBoard(board);

        while (true) {
            // instead o using ui use player.makeMOVE AND CHange it fot human
            Coordinate move = ui.getMove(currentPlayer, board);
            if (!board.makeMove(move.getX(), move.getY(), currentPlayer.getSymbol())) {
                ui.showInvalidMove();
                continue;
            }
            ui.showBoard(board);
            if (board.hasWinner(move.getX(), move.getY())) {
                ui.showWinner(currentPlayer);
                break;
            }
            if (board.isFull()) {
                ui.showTie();
                break;
            }
            switchPlayers();
            currentPlayer = players.get(currentPlayerIndex);
        }
    }

    private void switchPlayers() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }


    
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        game.start();
    }
}

