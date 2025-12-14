package Planning.Board;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Game {

    private Board board;
    private int[] bagsWithCharacters;
    private HashSet<String> AcceptableCharacters;

    private static final int ALPHABEt_CHARACTERS = 26;
    public Game(int tilesPerCharacter){
        bagsWithCharacters = new int[ALPHABEt_CHARACTERS];
        for(int i = 0; i < bagsWithCharacters.length; i++){
            bagsWithCharacters[i] = tilesPerCharacter;
        }
        this.AcceptableCharacters = getAllCharactersFromFile();
    }

    private HashSet<String> getAllCharactersFromFile(){
        String path = "resources/wordlist.txt";
        HashSet<String> allWordsPossible = new HashSet<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentWord;
            while((currentWord = reader.readLine()) != null){
                allWordsPossible.add(currentWord);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allWordsPossible;
    }
}
