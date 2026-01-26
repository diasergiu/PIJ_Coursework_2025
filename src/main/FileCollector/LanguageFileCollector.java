package FileCollector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class LanguageFileCollector implements FileCollector {

    public boolean isFileCorrect(String path){
        boolean isEmpty = false;
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String currentWord;
            while((currentWord = reader.readLine()) != null){
                isEmpty = true;
                String[] allWords = currentWord.split(" ");
                if(allWords.length > 1){
                    return false;
                }
                if(!isWordCorrect(currentWord)){
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return isEmpty;
    }

    private static boolean isWordCorrect(String word){
        int minAsciiCodeLowerCaseLetter  = 97;
        int maxAsciiCodeLowerCaseLetter= 122;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) < minAsciiCodeLowerCaseLetter ||
                    word.charAt(i) > maxAsciiCodeLowerCaseLetter){
                return false;
            }
        }
        return true;
    }

    public static HashSet<String> getLanguageFromFile(String path){
        HashSet<String> allWordsPossible = new HashSet<String>();
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String currentWord;
            while((currentWord = reader.readLine()) != null){
                allWordsPossible.add(currentWord);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allWordsPossible;
    }
}
