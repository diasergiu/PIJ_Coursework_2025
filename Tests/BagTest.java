import Planning.Board.Bag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagTest {
    private static final String EMPTY_FILE = "Tests/TestResources/BagTest/EmptyFile.txt";
    private static final String NOT_A_FILE = "";
    @Test
    public void testEmptyFile(){
        Bag bag = new Bag();
        bag.setNewBag(EMPTY_FILE);
    }

    @Test
    public void testFileNotFound(){
        Bag bag = new Bag();
        bag.setNewBag(NOT_A_FILE);

    }

    @Test
    public void testReadIncorectFile(){

    }

    @Test
    public void testReadFileCorrectly(){

    }

    @Test
    public void testReadDefaultFile(){
        Bag bag = new Bag();
        int a = 2 + 3;
    }
}
