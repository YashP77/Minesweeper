import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void checkState() {

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
        Assert.assertEquals("Tile is the correct state", "*", result);
        Assert.assertEquals("Tile is the correct state", "-", result2);
        Assert.assertEquals("Tile is the correct state", "F", result3);

    }

    @Test
    void setState() {

        // Arrange
        Tile tile = new Tile(false,false);

        // Act
        tile.setState("*");

        // Assert
        Assert.assertEquals("Tile is set to the correct state", "*", tile.state);

    }

    @Test
    void getIsMine() {

        // Arrange
        Tile tile = new Tile(true,false);

        // Act
        boolean result = tile.getIsMine();


        // Assert
        Assert.assertEquals("Tile returns right value", true, result);

    }

    @Test
    void getIsHidden() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        boolean result = tile.getIsHidden();

        // Assert
        Assert.assertEquals("Tile returns right value", true, result);

    }

    @Test
    void setIsHidden() {

        // Arrange
        Tile tile = new Tile(false,false);

        // Act
        tile.setIsHidden(true);

        // Assert
        Assert.assertEquals("Tile is set to the correct state", true, tile.getIsHidden());


    }

    @Test
    void getIsFlag() {

        // Arrange
        Tile tile = new Tile(false,true);
        tile.setIsFlag(true);


        // Act
        boolean result = tile.getIsFlag();

        // Assert
        Assert.assertEquals("Tile returns right value", true, result);

    }

    @Test
    void setIsFlag() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        tile.setIsFlag(true);

        // Assert
        Assert.assertEquals("Tile returns right value", true, tile.getIsFlag());


    }

    @Test
    void getNumOfMinesNearby() {

        // Arrange
        Tile tile = new Tile(false,true);
        tile.setNumOfMinesNearby(3);


        // Act
        int result = tile.getNumOfMinesNearby();

        // Assert
        Assert.assertEquals("Tile returns right value", 3, result);

    }

    @Test
    void setNumOfMinesNearby() {

        // Arrange
        Tile tile = new Tile(false,true);


        // Act
        tile.setNumOfMinesNearby(5);

        // Assert
        Assert.assertEquals("Tile returns right value", 5, tile.getNumOfMinesNearby());

    }
}