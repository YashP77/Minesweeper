import ui.UserIO;
import ui.UserIOImpl;

public class Game {

    final UserIO io = new UserIOImpl();

    private int gameStatus;

    private int correctFlags;
    public int incorrectFlags = 0;
    Board board;

    public Game() {
    }

    public int getCorrectFlags() {
        return correctFlags;
    }

    public void setCorrectFlags(int correctFlags) {
        this.correctFlags = correctFlags;
    }

    public int getGameStatus(){
        return gameStatus;
    }

    public void setGameStatus(int gameStatus){
        this.gameStatus = gameStatus;
    }

    public void start(){

        io.print("Welcome to Minesweeper");

        io.print("");

        int difficulty = io.readInt("What difficulty would you like to play on? 1: Beginner, 2:Intermediate or 3:expert", 1,3);

        io.print("");

        board = new Board(difficulty);

        io.print("This board has " + board.getNumOfMines() + " mine/s! Avoid them at all costs!");

        setGameStatus(1);
        io.print("");
        onGoing();
    }

    public void onGoing(){

        System.out.println();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(getGameStatus());
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        while(getGameStatus() == 1){

            io.print("Would you like to place a flag?");
            int in = io.readInt("Please type 1 for yes or 2 for no:", 1,2);

            if(in == 1){

                int fr = io.readInt("Input the row number of the tile you would like to place a flag on", 1, board.getSize()) -1;
                int fc = io.readInt("Input the column number of the tile you would like to place a flag on", 1, board.getSize()) -1;
                boolean status = board.placeFlag(fr, fc);
                if(!status){
                    setGameStatus(0);
                }

            }
            else{
                io.print("Which tile would you like to unveil?");
                int r = io.readInt("Input the row number of the tile you would like to unveil", 1, board.getSize()) -1;
                int c = io.readInt("Input the column number of the tile you would like to unveil", 1, board.getSize()) -1;
                boolean status = board.updateBoard(r,c);

                if(!status){
                    setGameStatus(0);
                }


            }
        }
    }

    public void loseGame(int reason){

        switch (reason){
            case 1:
                io.print("Oh no, you have found the bomb");
                io.print("You are a LOSER");
                break;
            case 2:
                io.print("Oh no, you have flagged an incorrect tile");
                io.print("You are a LOSER");
                break;
        }
    }

    public void winGame(){
        System.out.println(getGameStatus());
        io.print("You're the BOMB");
    }

}
