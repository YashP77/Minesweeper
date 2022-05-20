import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGetCorrectFlags() {

        // Arrange
        Game game = new Game();
        game.setCorrectFlags(3);

        // Act
        game.setCorrectFlags(3);

        // Assert
        assertEquals(3, game.getCorrectFlags(), "Game returns right value");

    }

    @Test
    public void testSetCorrectFlags() {

        // Arrange
        Game game = new Game();

        // Act
        game.setCorrectFlags(3);

        // Assert
        assertEquals(3, game.getCorrectFlags(), "Tile is set to the correct state");
    }

    @Test
    public void testGetGameStatus() {
        // Arrange
        Game game = new Game();

        // Act
        game.setGameStatus(1);

        // Assert
        assertEquals(1, game.getGameStatus(), "Game returns right value");
    }

    @Test
    public void testSetGameStatus() {

        // Arrange
        Game game = new Game();

        // Act
        game.setGameStatus(0);

        // Assert
        assertEquals(0, game.getGameStatus(), "Game returns right value");

    }

    @Test
    void loseGame() {
        // Arrange
        Game game = new Game();

        // Act
        game.loseGame(1);
        game.loseGame(2);

        // Assert
        assertEquals(0, game.getGameStatus(), "Game returns right value");
        assertEquals(0, game.getGameStatus(), "Game returns right value");
    }

    @Test
    void winGame() {
        // Arrange
        Game game = new Game();

        // Act
        game.winGame();

        // Assert
        assertEquals(0, game.getGameStatus(), "Game returns right value");;
    }
}