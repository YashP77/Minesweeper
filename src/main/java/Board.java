import java.util.Arrays;

public class Board {

    // Attributes
    int size;
    Tile[][] board;
    int numOfMines;

    // Constructor
    public Board(int size, int numOfMines) {
        this.size = size;
        this.numOfMines = numOfMines;
        this.board = new Tile[size][size];
        fillBoard();
        generateMines();
        nearbyMineUpdate();
    }
    // Methods
    public void generateMines(){

//        for(int i = 0; i < numOfMines; i++){
//
//            int rand1 = (int)(Math.random() * size);
//            int rand2 = (int)(Math.random() * size);
//
//            if (board[rand1][rand2] != new Tile(true, false)){
//                board[rand1][rand2] = new Tile(true,false);
//            }
//        }

        board[0][0] = new Tile(true,false);

    }

    public void fillBoard(){
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == null){
                    board[i][j] = new Tile(false, true); //Whatever value you want to set them to
                }
            }
        }
    }

    public void print(){

        for(int k = 0; k < size+ 1; k++){

            if(k== 0){
                System.out.print("    ");
            }else if(k == 5){
                System.out.print("\033[4m" +k + "\033[0m  ");
            }
            else{
                System.out.print("\033[4m" +k + "  ");
            }
        }
        System.out.println();

        for (int i = 0; i < board.length; i++)
        {
            System.out.print( i+1 +"|  ");
            for (int j = 0; j < board[i].length; j++)
            {
                if(!board[i][j].isHidden){
                    System.out.print(board[i][j].state + "  ");
                }else{
                    System.out.print("-" + "  ");
                }
            }
            System.out.println();
        }
    }

    public void updateBoard(int row, int col){

        board[row][col].setIsHidden(false);
        print();

    }

    public void nearbyMineCheck(int r, int c){

        int mines = 0;

        if(r-1 >= 0 && c-1 >= 0 && r+1 < size && c+1 < size){


            if(board[r-1][c-1].isMine == true){ //NW
                mines++;
            }

            if(board[r-1][c].isMine == true){ // N
                mines++;
            }
            if(board[r-1][c+1].isMine == true){ // NE
                mines++;
            }
            if(board[r][c-1].isMine == true){ // W
                mines++;
            }
            if(board[r][c+1].isMine == true){ // E
                mines++;
            }
            if(board[r+1][c-1].isMine == true){ // SW
                mines++;
            }
            if(board[r+1][c].isMine == true){ // S
                mines++;
            }
            if(board[r+1][c+1].isMine == true){ // SE
                mines++;
            }

        }
        board[r][c].setNumOfMinesNearby(mines);
    }

    public void nearbyMineUpdate(){

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(board[i][j].isMine == false){
                    nearbyMineCheck(i,j);
                }
            }
        }
    }
}
