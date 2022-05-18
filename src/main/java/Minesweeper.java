import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        Board board = new Board(5, 3);

        Game game = new Game();

        game.start();

    }
}

