package noapplet.assignments.HW2;


public class HumanPlayer extends Player {
        
    public HumanPlayer(String name, char piece) {
        super(name, piece);
    }

    @Override
    public Coordinate makeMove(Board board){
        return new Coordinate(0, 0);
    }
}


