import Planning.Board.Tile;
import WordsCollectorDir.WordsCollector;
import org.junit.jupiter.api.Test;

public class TestMakeGameBoard {

    private final static String defaultFile = "Tests/TestResources/Board/defaultBoard.txt";
    @Test
    public void testMakeNormalGame(){
        Tile[][] board = WordsCollector.getGameFromFile(defaultFile);
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
}
