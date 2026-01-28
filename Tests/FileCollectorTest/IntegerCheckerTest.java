package FileCollectorTest;

import FileCollector.IntegerChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerCheckerTest {

    @Test
    public void testLowerCaseLetter(){
        String test = "13c";
        Assertions.assertTrue(IntegerChecker.isLowerCaseChar(test.substring(test.length() - 1)));
    }
}
