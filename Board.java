package noapplet.assignments.HW2;

public class Board {
    private char[][] board;
    private int size;
    
    public Board(int size){
        this.size = size;
        this.board = new char[size][size];
    }

    public void initializeBoard(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = '-';
            }
        }
    }

    public int getSize(){
        return size;
    }
    
    public boolean makeMove(int row, int col, char piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != '\u0000') {
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public char getPieceAt(int row, int col){
        return board[row][col];
    }

    public boolean isFull(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board[i][j] == '\u0000'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char playerSymbol) {
        // Check rows
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < size; col++) {
                if (board[row][col] == playerSymbol) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    return true;
                }
            }
        }

        // Check columns
        for (int col = 0; col < size; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
                if (board[row][col] == playerSymbol) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    return true;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < 5; i++) {
                    if (row + i < size && col + i < size && board[row + i][col + i] == playerSymbol) {
                        count1++;
                    }
                    if (row + i < size && col - i >= 0 && board[row + i][col - i] == playerSymbol) {
                        count2++;
                    }
                }
                if (count1 == 5 || count2 == 5) {
                    return true;
                }
            }
        }

        return false;
    }




}
