package Planning.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    public List<Piece> bag;

    public Bag(){
        bag = new ArrayList<Piece>();
    }
    public void addToBag(Piece newTile){
        bag.add(newTile);
    }
    public Piece RemoveFromBag(int index){
        Piece send = bag.get(index);
        int lastIndex = bag.size() - 1;
        bag.set(index, bag.get(lastIndex));
        bag.remove(lastIndex);
        return send;
    }

    public int size(){
        return this.bag.size();
    }

}
