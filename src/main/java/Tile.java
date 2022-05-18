public class Tile {

    // Attributes
    char state;
    boolean isMine;
    boolean isHidden;
    int numOfMinesNearby;

    // Constructor
    public Tile(boolean isMine, boolean isHidden){
        this.isMine = isMine;
        this.isHidden = isHidden;
        checkState();
    }

    // Methods
    public void checkState(){

        if(isHidden){
            setState('-');
        }

        if(isMine){
            setState('*');
        }
        else{
            setState((char)getNumOfMinesNearby());
        }
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getNumOfMinesNearby() {
        return numOfMinesNearby;
    }

    public void setNumOfMinesNearby(int numOfMinesNearby) {
        this.numOfMinesNearby = numOfMinesNearby;
    }


}
