package FileCollectorTest;

import FileCollector.BoardFileCollector;
import Planning.Board.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardFileCollectorTest {

    private final static String TEST_DEFAULT = "Tests/TestResources/Board/defaultBoard";
    private final static String TEST_EMPTY = "Tests/TestResources/Board/TestEmpty";
    private final static String TEST_MORE_LINES = "Tests/TestResources/Board/TestMoreLines";
    private final static String TEST_ODD_CHARACTER = "Tests/TestResources/Board/TestOddCharacter";
    private final static String TEST_ONLY_COL = "Tests/TestResources/Board/TestOnlyCol";
    private final static String TEST_ONLY_GROUP_SIZE = "Tests/TestResources/Board/TestOnlyGropSize";
    private final static String TEST_ONLY_ROW = "Tests/TestResources/Board/TestOnlyRow";

    @Test
    public void testMakeNormalGame(){
        Tile[][] board = FileCollector.BoardFileCollector.getBoardFromFile(TEST_DEFAULT);
        drawBoard(board);
    }

    public void drawBoard(Tile[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                StringBuilder builder = new StringBuilder();
                builder.append(board[i][j].getCharacter());
                int defaultLengthBetweenCharacters = 6;
                if(board[i][j].getValueMultiplayer() != 1){
                    builder.append(board[i][j].getValueMultiplayer());
                }
                if(board[i][j].isPremiumWord()){
                    builder.append('!');
                }
                for(int m = builder.length(); m < defaultLengthBetweenCharacters; m++){
                    builder.append(' ');
                }
                System.out.print(builder);
            }
            System.out.println();
        }
    }

    @Test
    public void testIsboardFileEmpty(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_EMPTY));
    }
    @Test
    public void testIsboardFileLegitMoreLines(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_MORE_LINES));
    }
    @Test
    public void testIsboardFileLegitOddCharacter(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_ODD_CHARACTER));
    }
    @Test
    public void testIsboardFileLegitOnlyCol(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_ONLY_COL));
    }
    @Test
    public void testIsboardFileOnlyGroupSize(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_ONLY_GROUP_SIZE));
    }
    @Test
    public void testIsboardFileLegitOnlyRow(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(TEST_ONLY_ROW));
    }

    @Test
    public void testIsboardFileLegitDefault(){
        BoardFileCollector fileCollector = new BoardFileCollector();
        Assertions.assertTrue(fileCollector.isFileCorrect(TEST_DEFAULT));
    }

}
