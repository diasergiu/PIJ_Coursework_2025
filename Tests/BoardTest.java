import Planning.Board.Board;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void TestDrawEmpty(){
        Board emptyBoard = new Board(7,8);
        emptyBoard.drawBoard();
    }

    @Test
    public void TestDrawFromFile(){

    }
}
