import ui.UserIO;
import ui.UserIOImpl;

public class Game {

    private UserIO io = new UserIOImpl();

    Board board;

    public Game() {
    }

    public void start(){

        io.print("Welcome to Minesweeper");

        io.print("");

        io.print("What size board would you like to play with?");

        io.readInt("Please input a number between 2 and 50", 2,50);

        io.print("");

        io.print("What  ");



    }

}
