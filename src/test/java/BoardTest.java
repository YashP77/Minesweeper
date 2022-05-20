import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testConstructor(){

        // Arrange
        Board board = new Board(1);

        // Assert
        assertEquals(5, board.getSize(), "Board initializes correctly");
    }

    @Test
    public void testFillBoard() {

        // Arrange
        Board board = new Board(1);

        assertNotNull(board.board[4][4], "Board filled correctly");

    }

    @Test
    public void testUpdateBoard() {

        // Arrange
        Board board = new Board(1);

        boolean result = false;

        int r = 0;
        int c = 0;
        if(!board.board[0][0].isMine){
            result = board.updateBoard(0,0);
        }
        else{
            r++;
            c++;
        }

        assertTrue(result);
    }

//    @Test
//    void nearbyMineCheck() {
//    }
//
//    @Test
//    void nearbyMineUpdate() {
//    }
//
//    @Test
//    void zeroUpdate() {
//    }
//
//    @Test
//    void placeFlag() {
//    }
//
//    @Test
//    void getNumOfMines() {
//    }
//
//    @Test
//    void getSize() {
//    }
}