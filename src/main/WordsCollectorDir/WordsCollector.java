package WordsCollectorDir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class WordsCollector {

    public static HashSet<String> getAllCharactersFromFile(String path){
//        String path = "resources/wordlist.txt";
        HashSet<String> allWordsPossible = new HashSet<String>();
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
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
