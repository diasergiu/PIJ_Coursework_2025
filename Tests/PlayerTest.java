import FileCollector.BagFileCollector;
import Planning.Board.Bag;
import Planning.Board.Piece;
import Planning.Board.Player;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PlayerTest {

    private static final String BAG_FILE = "Tests/TestResources/BagTest/TestNormalFile";
    @Test
    public void testDraw(){
        Player player = new Player();
        Bag bag = BagFileCollector.getBagFromFile(BAG_FILE);

        for(int indexPiecePlayer = 0; indexPiecePlayer < 7; indexPiecePlayer++){
            Random rand = new Random();
            int pieceToRemove = rand.nextInt(bag.size());
            Piece piece = bag.RemoveFromBag(pieceToRemove);
            player.setPieceAtIndex(piece, indexPiecePlayer);
        }

        player.printPieces();
    }
}
