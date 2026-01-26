package FileCollector;

import Planning.Board.Bag;
import Planning.Board.Tile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BagFileCollector implements FileCollector {

    public boolean isFileCorrect(String path){
        boolean isEmpty = false;
        try{
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String currentWord;
            while((currentWord = reader.readLine()) != null){
                isEmpty = true;
                String[] allStrings = currentWord.split(" ");
                if(allStrings.length != 3){
                    return false;
                }
                if(!IntegerChecker.isInteger(allStrings[0]) ||
                        !IntegerChecker.isInteger(allStrings[2])){
                    return false;
                }

                if(allStrings[1].length() != 1 || !Character.isUpperCase(allStrings[1].charAt(0))){
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return isEmpty;
    }

    public static Bag getBagFromFile(String path) {
        BufferedReader reader = null;
        Bag bag = new Bag();
        try {
            reader = new BufferedReader(new java.io.FileReader(path));

            String currentWord;
            while((currentWord = reader.readLine()) != null){
                String[] listOfStrings = currentWord.split(" ");
                if(listOfStrings.length != 3 || listOfStrings[1].length() != 1){
                    System.out.println("File is not a proper bag file");
                    break;
                }
                for(int nTimes = Integer.parseInt(listOfStrings[0]); nTimes >= 0; nTimes--){
                    Tile newTile = new Tile(listOfStrings[1].charAt(0), Integer.parseInt(listOfStrings[2]), false);
                    bag.addToBag(newTile);
                }

            }
            return bag;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
