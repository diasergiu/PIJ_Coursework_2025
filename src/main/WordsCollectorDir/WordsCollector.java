package WordsCollectorDir;

import Planning.Board.Board;
import Planning.Board.Game;
import Planning.Board.Tile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class WordsCollector {

    public static HashSet<String> getVocabularyFromFile(String path){
//        String path = "resources/wordlist.txt";
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

    public void getBagFromFile(String path){

    }

//    public static boolean isGameFileFunctional(String path){
//        try{
//            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static Tile[][] getGameFromFile(String path){
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String currentWord;
            int currentRow = 0;
            int col = Integer.parseInt(reader.readLine());
            int row = Integer.parseInt(reader.readLine());
            Tile[][] board = new Tile[row][col];
            while((currentWord = reader.readLine()) != null){
                String[] allTiles = currentWord.split(" ");
                for(int i = 0; i < allTiles.length; i++){
                    int left = 0, right = allTiles[i].length() - 1;
                    boolean isPremiumWord = false;
                    int valueMultiplyer = 1;
                    char character = allTiles[i].charAt(right);
                    right--;
                    if(allTiles[i].charAt(left) == '!'){
                        isPremiumWord = true;
                        left++;
                    }
                    if(allTiles[i].charAt(left) == '-'){
                        valueMultiplyer *= -1;
                        left++;
                    }
                    if(left <= right){
                        int multiplayer = Integer.parseInt(allTiles[i].substring(left, right + 1));
                        valueMultiplyer *= multiplayer;
                    }
                    board[currentRow][i] = new Tile(character, valueMultiplyer, isPremiumWord);
                }
                currentRow++;
            }
            return board;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
