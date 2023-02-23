package noapplet.assignments.HW2;

public class Gomoku {
    private ConsoleUI ui;
    private Board board;
    private Player player1;
    private Player player2;

    public Gomoku() {
        this.ui = new ConsoleUI();
        this.board = new Board(15);
    }

    public void start() {
        int gameMode = ui.chooseGameMode();
        while (gameMode > 2 ){
            ui.GameModeError();
            gameMode = ui.chooseGameMode();
        }
        if (gameMode == 1) {
            player1 = new HumanPlayer(ui.getPlayerName(1), 'X');
            player2 = new HumanPlayer(ui.getPlayerName(2), 'O');
        } else if (gameMode == 2) {
            player1 = new HumanPlayer(ui.getPlayerName(1), 'X');
            // player2 = new ComputerPlayer("Computer", 'O');
        }

        board.initializeBoard();
        Player currentPlayer = player1;
        ui.showBoard(board);

        while (true) {
            int[] move = ui.getMove(currentPlayer, board);
            if (!board.makeMove(move[0], move[1], currentPlayer.getSymbol())) {
                ui.showInvalidMove();
                continue;
            }
            ui.showBoard(board);
            if (board.hasWinner(move[0], move[1])) {
                ui.showWinner(currentPlayer);
                break;
            }
            if (board.isFull()) {
                ui.showTie();
                break;
            }
            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
    }

    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        game.start();
    }
}

