package noapplet.assignments.HW2;

public abstract class Player {
    protected String name;
    protected char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public char getSymbol(){
        return symbol;
    }

    public abstract int[] makeMove(Board board);
}
