package FileCollectorTest;

import FileCollector.BagFileCollector;
import Planning.Board.Bag;
import org.junit.jupiter.api.Test;

public class BagFileCollectorTest {
    private static final String EMPTY_FILE = "Tests/TestResources/BagTest/TestEmpty.txt";
    private static final String NOT_A_FILE = "";

    private static final String DEFAULT_FILE = "resources/Bags/DefaultBag";
    @Test
    public void testEmptyFile(){
        Bag bag = BagFileCollector.getBagFromFile(EMPTY_FILE);
    }

    @Test
    public void testFileNotFound(){
        Bag bag = BagFileCollector.getBagFromFile(NOT_A_FILE);

    }

    @Test
    public void testReadIncorectFile(){

    }

    @Test
    public void testReadFileCorrectly(){

    }

    @Test
    public void testReadDefaultFile(){
        Bag bag = BagFileCollector.getBagFromFile(DEFAULT_FILE);
        int a = 2 + 3;
    }
}
