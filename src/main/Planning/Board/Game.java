package Planning.Board;

import java.util.HashSet;

import FileCollector.LanguageFileCollector;

// game must have human or computer players
// game can be open or closed (you can see the tiles that the other player can have)
public class Game {

    private Board board;
    private Player[] listPlayers;
    private Bag[] gameBag;
    //Both players have a rack of up to 7 tiles which is refilled from a tile
    // bag after every move. Each tile has a letter and a numerical value.
    private int[] bagsWithCharacters;
    private HashSet<String> AcceptableCharacters;

    private static final int ALPHABEt_CHARACTERS = 27;
    public Game(int tilesPerCharacter){
        String path = "resources/WordsInVocabulary/wordlist.txt";
        bagsWithCharacters = new int[ALPHABEt_CHARACTERS];
        for(int i = 0; i < bagsWithCharacters.length; i++){
            bagsWithCharacters[i] = tilesPerCharacter;
        }
        this.AcceptableCharacters = LanguageFileCollector.getLanguageFromFile(path);
    }
    /*
        The boards needs to have rows between 7 and 26
        column between 10 and 99
        and total amount os space needs to be bigger or equal to 192
    */


}
