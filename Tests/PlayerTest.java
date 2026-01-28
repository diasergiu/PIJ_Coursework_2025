import FileCollector.BagFileCollector;
import Planning.Board.Bag;
import Planning.Board.Piece;
import Planning.Board.Player;
import Planning.Board.PlayerMove;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Random;

public class PlayerTest {

    private static final String BAG_FILE = "Tests/TestResources/BagTest/TestNormalFile";

    private Player deplayPlayer(){
        Player player = new Player();
        Bag bag = BagFileCollector.getBagFromFile(BAG_FILE);

        for(int indexPiecePlayer = 0; indexPiecePlayer < 7; indexPiecePlayer++){
            Random rand = new Random();
            int pieceToRemove = rand.nextInt(bag.size());
            Piece piece = bag.RemoveFromBagRandom();
            player.setPieceAtIndex(piece, indexPiecePlayer);
        }
        return player;
    }
    @Test
    public void testDraw(){
        Player player = deplayPlayer();
        player.printPieces();
    }

//    @Test
//    public void TestMove(){
//        Player player = deplayPlayer();
//        PlayerMove move = player.makeMove();
//        int[] pieces = move.indexPiecesMoved;
//        Piece[] piece = move.piecesSelected;
//    }

    @Test
    public void testGetDirection() throws NoSuchMethodException {
        Player player = deplayPlayer();
        Method _getDirection = Player.class.getDeclaredMethod("getDirection", Player.class);
        _getDirection.setAccessible(true);
    }

//    @Test
//    public void getDirectionTest(){
//        Player player = deplayPlayer();
//        player.getDirection();
//    }
}
