package FileCollector;

import Planning.Board.Bag;
import Planning.Board.Tile;

import java.io.BufferedReader;
import java.io.IOException;

public class BagFileCollector {

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
