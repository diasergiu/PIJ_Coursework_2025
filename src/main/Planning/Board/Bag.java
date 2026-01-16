package Planning.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    public List<Tile> bag;

    public Bag(){
        bag = new ArrayList<Tile>();
    }
    public void addToBag(Tile newTile){
        bag.add(newTile);
    }
    public Tile RemoveFromBag(int index){
        Tile send = bag.get(index);
        int lastIndex = bag.size() - 1;
        bag.set(index, bag.get(lastIndex));
        bag.remove(lastIndex);
        return send;
    }

}
