package noapplet.assignments.HW2;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    @Override
    public int[] makeMove(Board board) {
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (!board.isCellEmpty(row, col));
        return new int[]{row, col};
    }
}
