package FileCollectorTest;

import FileCollector.LanguageFileCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


public class LanguageCollectorTest {

    private final static String PATH_TO_TEST = "Tests/TestResources/Language/TestNormal.txt";
    private final static String PATH_TO_ORIGINALFILE = "resources/WordsInVocabulary/wordlist.txt";
    @Test
    public void TestCanLoadAllWords(){
        HashSet<String> actual = LanguageFileCollector.getLanguageFromFile(PATH_TO_TEST);
        HashSet<String> expected = getExpected();
        Assertions.assertEquals(actual.size(), expected.size());
    }

    @Test
    public void TestWordsAreInList(){
        HashSet<String> actual = LanguageFileCollector.getLanguageFromFile(PATH_TO_ORIGINALFILE);
        HashSet<String> expected = getExpected();
        for(String word : expected){
            Assertions.assertTrue(actual.contains(word));
        }
    }

    private HashSet<String> getExpected(){
        HashSet<String> set = new HashSet<>();
        set.add("aa");
        set.add("aah");
        set.add("aahed");
        set.add("aahing");
        set.add("aahs");
        set.add("aal");
        set.add("aalii");
        set.add("aaliis");
        set.add("aals");
        set.add("aardvark");
        set.add("aardvarks");
        set.add("aardwolf");
        set.add("aardwolves");
        return set;
    }

    // Test is the File is correctly selected
    private final static String EMPTY_FILE = "Tests/TestResources/Language/TestEmpty.txt";
    private final static String NORMAL_FILE = "Tests/TestResources/Language/TestNormal.txt";
    private final static String NUMBERS_FILE = "Tests/TestResources/Language/TestNumber.txt";
    private final static String ODD_CHARACTER = "Tests/TestResources/Language/TestOddCharacter.txt";
    private final static String TOW_WORDS = "Tests/TestResources/Language/TestTowWords.txt";
    private final static String UPPARCASE_lETTER = "Tests/TestResources/Language/TestUpparcaseLetter.txt";

    @Test
    public void testEmptyFile(){
        Assertions.assertFalse(LanguageFileCollector.isFileCorrect(EMPTY_FILE));
    }
    @Test
    public void testNormalFile(){
        Assertions.assertTrue(LanguageFileCollector.isFileCorrect(NORMAL_FILE));
    }
    @Test
    public void testNumberFile(){
        Assertions.assertFalse(LanguageFileCollector.isFileCorrect(NUMBERS_FILE));
    }
    @Test
    public void testOddCharacter(){
        Assertions.assertFalse(LanguageFileCollector.isFileCorrect(ODD_CHARACTER));
    }
    @Test
    public void testTowWords(){
        Assertions.assertFalse(LanguageFileCollector.isFileCorrect(TOW_WORDS));
    }
    @Test
    public void testUpparcaseLetter(){
        Assertions.assertFalse(LanguageFileCollector.isFileCorrect(UPPARCASE_lETTER));
    }

}
