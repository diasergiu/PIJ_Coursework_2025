package FileCollectorTest;

import FileCollector.BagFileCollector;
import Planning.Board.Bag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagFileCollectorTest {
    private static final String EMPTY_FILE = "Tests/TestResources/BagTest/TestEmpty";
    private static final String NOT_A_FILE = "";

    private static final String NORMAL_FILE = "Tests/TestResources/BagTest/TestNormalFile";
    private static final String NUMBER_FILE = "Tests/TestResources/BagTest/TestNormalFile";
    private static final String ODD_Character = "Tests/TestResources/BagTest/TestOddCharacters";
    private static final String UNREGULAR_ORDER = "Tests/TestResources/BagTest/TestUnregularOrder";
    private static final String FEWER_COL = "Tests/TestResources/BagTest/TestFewerCol";
    private static final String FEWER_ROWS = "Tests/TestResources/BagTest/TestFewerRows";
//    @Test
//    public void testEmptyFile(){
//        Bag bag = BagFileCollector.getBagFromFile(EMPTY_FILE);
//    }
//
//    @Test
//    public void testFileNotFound(){
//        Bag bag = BagFileCollector.getBagFromFile(NOT_A_FILE);
//
//    }

    @Test
    public void testReadIncorectFile(){

    }

    @Test
    public void testReadFileCorrectly(){

    }

    @Test
    public void testReadDefaultFile(){
        Bag bag = BagFileCollector.getBagFromFile(NORMAL_FILE);
        int a = 2 + 3;
    }

    @Test
    public void testEmptyFileCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(EMPTY_FILE));
    }

    @Test
    public void testFileNotFoundCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(NOT_A_FILE));
    }
    @Test
    public void testNormalFileCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertTrue(fileCollector.isFileCorrect(NORMAL_FILE));
        System.out.println("sada");
    }
    @Test
    public void testNumberFileCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertTrue(fileCollector.isFileCorrect(NUMBER_FILE));
    }
    @Test
    public void testOddFileCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(ODD_Character));
    }
    @Test
    public void testUnregularFileCorrect(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(UNREGULAR_ORDER));
    }

    @Test
    public void testFewerCol(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(FEWER_COL));
    }

    @Test
    public void testFewerRows(){
        BagFileCollector fileCollector = new BagFileCollector();
        Assertions.assertFalse(fileCollector.isFileCorrect(FEWER_ROWS));
    }
}
