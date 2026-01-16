package Planning.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    public List<Tile> bag;

    public Bag(){
        bag = new ArrayList<Tile>();
        String defaultFile = "resources/DefaultBag";
        setBagFromFile(defaultFile);
    }

    public void setNewBag(String path){
        bag = new ArrayList<>();
        setBagFromFile(path);
    }

    private void setBagFromFile(String path) {
        BufferedReader reader = null;
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
                bag.add(newTile);
            }

        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tile RemoveFromBag(int index){
        Tile send = bag.get(index);
        int lastIndex = bag.size() - 1;
        bag.set(index, bag.get(lastIndex));
        bag.remove(lastIndex);
        return send;
    }

}
