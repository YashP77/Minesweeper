public class Tile {

    // Attributes
    String state;
    boolean isFlag;
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
            setState("-");
        }

        if(isMine){
            setState("*");
        }

        if(isFlag){
            setState("F");
        }
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean getIsMine() {
        return isMine;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean getIsFlag(){
        return isFlag;
    }

    public void setIsFlag(boolean isFlag){
        this.isFlag = isFlag;
    }

    public int getNumOfMinesNearby() {
        return numOfMinesNearby;
    }

    public void setNumOfMinesNearby(int numOfMinesNearby) {
        this.numOfMinesNearby = numOfMinesNearby;
    }


}
