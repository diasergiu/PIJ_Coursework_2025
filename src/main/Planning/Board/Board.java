package Planning.Board;

import java.util.List;

public class Board {

    List<Player> listPlayers;
    Tile[][] board;
    // we have a bag that holds a certain amount of pieces or tiles that the player can draw from to
    // get back to 7 pieces after he played some
    int[] tileBag;


    // when we put pieces on the board we calculate if there are characters between the two piece placed
    // need a way to select pieces that we have on the table
    // we need to place those peices on the board
    // we need an efficient way to veriffie it they formed a word, and any words that might intersect with the word placed by us
    // we need to be able to take back pieces after we place them and take them back after we place a wrong word
    // game ends where there are no more tiles in the tileBag and a player dosent have any more tiles
    // the game can also end if all players pass their turn.
}
