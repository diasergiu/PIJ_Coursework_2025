package FileCollector;

import Planning.Board.Tile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BoardFileCollector implements FileCollector {


    public boolean isFileCorrect(String path){
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String col = reader.readLine();
            String row = reader.readLine();
            if(col == null || row == null || col.isEmpty() || !IntegerChecker.isInteger(col) || !IntegerChecker.isInteger(row)){
                return false;
            }
            int _row = Integer.parseInt(row);
            int _col = Integer.parseInt(col);
            if(!isBoardLegit(_col, _row)){
                return false;
            }
            String current;

            while((current = reader.readLine()) != null){
                String[] listOfTiles = current.split(" ");
                if(listOfTiles.length != _col){
                    return false;
                }
                _row--;
                for(String currentTile : listOfTiles){
                    if(!isGoodTile(currentTile)){
                        return false;
                    }
                }
            }
            return _row == 0;
        } catch (IOException e) {
            System.out.println("File not found");
            return false;
        }
    }

    private static boolean isGoodTile(String tile){
         int left = 0, right = tile.length() - 1;
        if(tile.charAt(right) != '.' && ( tile.charAt(right) < 65 || tile.charAt(right) > 90)){// i dont think this works
            return false;
        }
        right--;
        if(tile.charAt(left) == '!'){
            left++;
        }
        if(tile.charAt(left) == '-'){
            left++;
        }
        if(left <= right && !IntegerChecker.isInteger(tile.substring(left, right))){
            return false;
        }
        return true;
    }

    private static boolean isBoardLegit(int col, int row){
        if(col < 7 || col > 26 || row < 10 || row > 99 || col * row <= 192){
            return false;
        }
        return true;
    }

    public static Tile[][] getBoardFromFile(String path){
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
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
