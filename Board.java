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
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != '-') {
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
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    
    public boolean hasWinner(int row, int col) {
        char piece = board[row][col];

        // Check for horizontal win
        int count = 0;
        for (int c = 0; c < size; c++) {
            if (board[row][c] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for vertical win
        count = 0;
        for (int r = 0; r < size; r++) {
            if (board[r][col] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for diagonal win (top-left to bottom-right)
        count = 0;
        int r = row;
        int c = col;
        while (r > 0 && c > 0 && board[r-1][c-1] == piece) {
            r--;
            c--;
        }
        while (r < size && c < size && board[r][c] == piece) {
            count++;
            r++;
            c++;
        }
        if (count >= 5) {
            return true;
        }

        // Check for diagonal win (bottom-left to top-right)
        count = 0;
        r = row;
        c = col;
        while (r < size-1 && c > 0 && board[r+1][c-1] == piece) {
            r++;
            c--;
        }
        while (r >= 0 && c < size && board[r][c] == piece) {
            count++;
            r--;
            c++;
        }
        if (count >= 5) {
            return true;
        }

        return false;
    }


    public boolean isCellEmpty(int row, int col){
        return board[row][col] == '-';
    }


}
