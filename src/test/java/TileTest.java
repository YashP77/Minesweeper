import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {

    @Test
    public void testCheckState() {

        // Arrange
        Tile mineHiddenTile = new Tile(true, true);
        Tile hiddenTile = new Tile(false, true);
        Tile flagTile = new Tile(false, true);
        flagTile.setIsFlag(true);

        mineHiddenTile.checkState();
        hiddenTile.checkState();
        flagTile.checkState();


        // Act
        String result = mineHiddenTile.state;
        String result2 = hiddenTile.state;
        String result3 = flagTile.state;

        // Assert
        assertEquals("*", result, "Tile is the correct state");
        assertEquals("-", result2, "Tile is the correct state");
        assertEquals("F", result3, "Tile is the correct state");

    }

    @Test
    public void testSetState() {

        // Arrange
        Tile tile = new Tile(false,false);

        // Act
        tile.setState("*");

        // Assert
        assertEquals("*", tile.state, "Tile is set to the correct state");

    }

    @Test
    public void testGetIsMine() {

        // Arrange
        Tile tile = new Tile(true,false);

        // Act
        boolean result = tile.getIsMine();


        // Assert
        assertEquals(true, result, "Tile returns right value");

    }

    @Test
    public void testGetIsHidden() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        boolean result = tile.getIsHidden();

        // Assert
        assertEquals(true, result, "Tile returns right value");

    }

    @Test
    public void testSetIsHidden() {

        // Arrange
        Tile tile = new Tile(false,false);

        // Act
        tile.setIsHidden(true);

        // Assert
        assertEquals(true, tile.getIsHidden(), "Tile is set to the correct state");


    }

    @Test
    public void testGetIsFlag() {

        // Arrange
        Tile tile = new Tile(false,true);
        tile.setIsFlag(true);


        // Act
        boolean result = tile.getIsFlag();

        // Assert
        assertEquals(true, result, "Tile returns right value");

    }

    @Test
    public void testSetIsFlag() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        tile.setIsFlag(true);

        // Assert
        assertEquals(true, tile.getIsFlag(), "Tile returns right value");


    }

    @Test
    public void testGetNumOfMinesNearby() {

        // Arrange
        Tile tile = new Tile(false,true);
        tile.setNumOfMinesNearby(3);


        // Act
        int result = tile.getNumOfMinesNearby();

        // Assert
        assertEquals(3, result, "Tile returns right value");

    }

    @Test
    public void testSetNumOfMinesNearby() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        tile.setNumOfMinesNearby(5);

        // Assert
        assertEquals(5, tile.getNumOfMinesNearby(),"Tile returns right value");

    }
}