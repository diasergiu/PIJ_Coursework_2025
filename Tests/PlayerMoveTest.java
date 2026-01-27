import Planning.Board.PlayerMove;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PlayerMoveTest {

    private final Scanner scanner;

    public PlayerMoveTest(Scanner scanner) {
        this.scanner = scanner;
    }

    @Test
    public void playerMoveTestOk(){
        PlayerMove move = new PlayerMove();
        Assertions.assertTrue(move.setCoordinates("12m"));
    }
    @Test
    public void playerMoveTestmultipleString(){
        PlayerMove move = new PlayerMove();
        Assertions.assertFalse(move.setCoordinates("12mn"));
    }

    @Test
    public void playerMoveTestNoNumber(){
        PlayerMove move = new PlayerMove();
        Assertions.assertFalse(move.setCoordinates("nn"));
    }
    @Test
    public void playerMoveTestNoNumberOneVariable(){
        PlayerMove move = new PlayerMove();
        Assertions.assertFalse(move.setCoordinates("n"));
    }

    @Test
    public void playerMoveTestNoAnswer(){
        PlayerMove move = new PlayerMove();
        Assertions.assertFalse(move.setCoordinates(""));
    }

    @Test
    public void playerMoveTestNoAnswerEmptyChar(){
        PlayerMove move = new PlayerMove();
        Assertions.assertFalse(move.setCoordinates(" "));
    }

    @Test
    public void playerMoveTestCorrectColCoordinates(){
        PlayerMove move = new PlayerMove();
        Assertions.assertTrue(move.setCoordinates("1c"));
        int expected = 3;
        Assertions.assertEquals(expected, move.col);
    }
}
