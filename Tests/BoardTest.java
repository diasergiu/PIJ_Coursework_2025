import Planning.Board.Board;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testDrawEmpty(){
        Board emptyBoard = new Board(7,8);
        emptyBoard.drawBoard();
    }

    @Test
    public void testDrawWithCharacter(){

    }

    @Test
    public void testDrawPremiumTile(){}

    @Test
    public void testDrawPremiumWord(){}
    @Test
    public void testReadTileValueLowerThenAllowed(){}

    @Test
    public void testReadTileValueHigherThanAllowed(){}

    @Test
    public void testReadIllegalCharacter(){}


}
