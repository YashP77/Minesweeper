public class Board {

    // Attributes
    int size;
    Tile[][] board;
    int difficulty;
    int numOfMines;
    Game game = new Game();

    // Constructor
    public Board(int difficulty) {
        this.difficulty = difficulty;

        if(difficulty == 1){
            this.size = 5;
            this.numOfMines= 5;
        }
        else if(difficulty == 2){
            this.size = 7;
            this.numOfMines= 24;
        }
        else{
            this.size = 9;
            this.numOfMines= 45;
        }
        this.board = new Tile[size][size];
        fillBoard();
        generateMines();
        print();
        nearbyMineUpdate();
    }

    // Methods
    public void generateMines(){

        Tile blankMine = new Tile(true, true);

        for(int i = 0; i < numOfMines; i++){

            int rand1 = (int)(Math.random() * size-1);
            int rand2 = (int)(Math.random() * size-1);

            if (board[rand1][rand2] != blankMine){
                board[rand1][rand2] = new Tile(true,true);
            }
        }
    }

    public void fillBoard(){
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == null){
                    board[i][j] = new Tile(false, true);
                }
            }
        }
    }

    public void print(){

        for(int k = 0; k < size+ 1; k++){

            if(k== 0){
                System.out.print("    ");

            }
            else if(k == size){
                System.out.print("\033[4m" + k + "\033[0m  ");
            }
            else{
                System.out.print("\033[4m" + k + "  ");
            }

        }
        System.out.println();

        for (int i = 0; i < board.length; i++)
        {
            System.out.print( i+1 +"|  ");

            for (int j = 0; j < board[i].length; j++)
            {

                if(!board[i][j].isHidden){

                    if (board[i][j].state.equals("-")){
                        System.out.print(board[i][j].getNumOfMinesNearby() + "  ");
                    }
                    else{
                        System.out.print(board[i][j].state + "  ");
                    }

                }
                else{
                    System.out.print("-" + "  ");
                }

            }

            System.out.println();
        }
    }

    public boolean updateBoard(int row, int col){

        if(board[row][col].getNumOfMinesNearby() == 0 && !board[row][col].getIsFlag()){
            zeroUpdate(row,col);
        }

        board[row][col].setIsHidden(false);
        print();

        if (board[row][col].isMine && !board[row][col].getIsHidden() && !board[row][col].getIsFlag()){
            game.loseGame(1);
            return false;
        }
        return true;
    }

    public void nearbyMineCheck(int r, int c){

        int mines = 0;

        if(r-1 >= 0 && c-1 >= 0){
            if(board[r-1][c-1].isMine){ //NW
                mines++;
            }
        }

        if(r-1 >= 0){
            if(board[r-1][c].isMine){ // N
                mines++;
            }
        }

        if(r-1 >= 0 && c+1 < getSize()){
            if(board[r-1][c+1].isMine){ // NE
                mines++;
            }
        }

        if(c-1 >= 0){
            if(board[r][c-1].isMine){ // W
                mines++;
            }
        }

        if(c+1 < getSize()){
            if(board[r][c+1].isMine){ // E
                mines++;
            }
        }

        if(r+1 < getSize() && c-1 >= 0){
            if(board[r+1][c-1].isMine){ // SW
                mines++;
            }
        }

        if(r + 1 < getSize()){
            if(board[r+1][c].isMine){ // S
                mines++;
            }
        }

        if(r+1 < getSize() && c+1 < getSize()){

            if(board[r+1][c+1].isMine){ // SE
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
                    nearbyMineCheck(i,j);
            }
        }
    }

    public void zeroUpdate(int r, int c){

        if(r-1 >= 0 && c-1 >= 0){
            if(!board[r-1][c-1].isMine){ //NW
                if(board[r-1][c-1].getIsHidden()){
                    board[r-1][c-1].setIsHidden(false);
                    zeroUpdate(r-1,c-1);
                }
            }
        }

        if(r-1 >= 0){
            if(!board[r-1][c].isMine){ // N
                if(board[r-1][c].getIsHidden()){
                    board[r-1][c].setIsHidden(false);
                    zeroUpdate(r-1,c);
                }
            }
        }

        if(r-1 >= 0 && c+1 < getSize()){
            if(!board[r-1][c+1].isMine){ // NE
                if(board[r-1][c+1].getIsHidden()){
                    board[r-1][c+1].setIsHidden(false);
                    zeroUpdate(r-1,c+1);
                }
            }
        }

        if(c-1 >= 0){
            if(!board[r][c-1].isMine){ // W
                if(board[r][c-1].getIsHidden()){
                    board[r][c-1].setIsHidden(false);
                    zeroUpdate(r,c-1);
                }
            }
        }

        if(c+1 < getSize()){
            if(!board[r][c+1].isMine){ // E
                if(board[r][c+1].getIsHidden()){
                    board[r][c+1].setIsHidden(false);
                    zeroUpdate(r,c+1);
                }
            }
        }

        if(r+1 < getSize() && c-1 >= 0){
            if(!board[r+1][c-1].isMine){ // SW
                if(board[r+1][c-1].getIsHidden()){
                    board[r+1][c-1].setIsHidden(false);
                    zeroUpdate(r+1,c-1);
                }
            }
        }

        if(r + 1 < getSize()){
            if(!board[r+1][c].isMine){ // S
                if(board[r+1][c].getIsHidden()){
                    board[r+1][c].setIsHidden(false);
                    zeroUpdate(r+1,c);
                }
            }
        }

        if(r+1 < getSize() && c+1 < getSize()){

            if(!board[r+1][c+1].isMine){ // SE
                if(board[r+1][c+1].getIsHidden()){
                    board[r+1][c+1].setIsHidden(false);
                    zeroUpdate(r+1,c+1);
                }
            }
        }

    }

    public boolean placeFlag(int r, int c){

        board[r][c].setIsFlag(true);
        board[r][c].setState("F");

        if(board[r][c].getIsMine()){
            game.setCorrectFlags(game.getCorrectFlags() + 1);
        }
        else{
            game.incorrectFlags++;
        }

        updateBoard(r,c);
        if(game.getCorrectFlags()== getNumOfMines()){
            game.winGame();
            return false;
        }

        if(game.incorrectFlags > 0){
            game.loseGame(2);
            return false;
        }

        return true;

    }

    public int getNumOfMines() {
        return numOfMines;
    }

    public int getSize(){
        return size;
    }
}