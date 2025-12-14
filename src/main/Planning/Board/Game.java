package Planning.Board;

import java.util.HashSet;
import WordsCollectorDir.WordsCollector;

public class Game {

    private Board board;
    private int[] bagsWithCharacters;
    private HashSet<String> AcceptableCharacters;

    private static final int ALPHABEt_CHARACTERS = 26;
    public Game(int tilesPerCharacter){
        String path = "resources/wordlist.txt";
        bagsWithCharacters = new int[ALPHABEt_CHARACTERS];
        for(int i = 0; i < bagsWithCharacters.length; i++){
            bagsWithCharacters[i] = tilesPerCharacter;
        }
        this.AcceptableCharacters = WordsCollector.getAllCharactersFromFile(path);
    }

}
