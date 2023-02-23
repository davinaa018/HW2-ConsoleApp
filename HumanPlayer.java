package noapplet.assignments.HW2;

import java.util.Scanner;

public class HumanPlayer extends Player {
        
    public HumanPlayer(String name, char piece) {
        super(name, piece);
    }

    public int[] makeMove(Board board){
        return new int[] {0 ,0};
    }
}


