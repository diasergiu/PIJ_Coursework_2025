package Planning.Board;

import java.util.HashSet;
import WordsCollectorDir.WordsCollector;

// game must have human or computer players
// game can be open or closed (you can see the tiles that the other player can have)
public class Game {

    private Board board;
    //Both players have a rack of up to 7 tiles which is refilled from a tile
    // bag after every move. Each tile has a letter and a numerical value.
    private int[] bagsWithCharacters;
    private HashSet<String> AcceptableCharacters;

    private static final int ALPHABEt_CHARACTERS = 27;
    public Game(int tilesPerCharacter){
        String path = "resources/wordlist.txt";
        bagsWithCharacters = new int[ALPHABEt_CHARACTERS];
        for(int i = 0; i < bagsWithCharacters.length; i++){
            bagsWithCharacters[i] = tilesPerCharacter;
        }
        this.AcceptableCharacters = WordsCollector.getAllCharactersFromFile(path);
    }

}
