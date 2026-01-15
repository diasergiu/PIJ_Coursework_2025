package Planning.Board;

import java.util.List;

public class Board {

    List<Player> listPlayers;
    /*
    *   The board of the game. A grid a objects Tile
    *   Number of columns must be between 7 and 26
    *   Number of rows must be between 10 and 99
    *   The board must have at least 192 Tiles
    *   Board can be loaded from a file ( example the defaultBoard.txt)
     */
    Tile[][] board;
    // we have a bag that holds a certain amount of pieces or tiles that the player can draw from to
    // get back to 7 pieces after he played some
    /*
    *
    */
    public Board(int n, int m){
        isBoardLegit(n , m);
        board = new Tile[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = new Tile();
            }
        }
    }

    public Board(String Path){

    }

    private boolean isBoardLegit(int n, int m){
        if(n < 7 || n > 26 || m < 10 || m > 99 || n * m < 192){
            return false;
        }
        return true;
    }

    // when we put pieces on the board we calculate if there are characters between the two piece placed
    // need a way to select pieces that we have on the table
    // we need to place those peices on the board
    // we need an efficient way to veriffie it they formed a word, and any words that might intersect with the word placed by us
    // we need to be able to take back pieces after we place them and take them back after we place a wrong word
    // game ends where there are no more tiles in the tileBag and a player dosent have any more tiles
    // the game can also end if all players pass their turn.
    public void drawBoard(){
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
