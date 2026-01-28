package Planning.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    public List<Piece> bag;

    public Bag(){
        bag = new ArrayList<Piece>();
    }
    public void addToBag(Piece newTile){
        bag.add(newTile);
    }
    public Piece RemoveFromBagRandom(){
        Random rand = new Random();
        int index = rand.nextInt(this.bag.size());
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
