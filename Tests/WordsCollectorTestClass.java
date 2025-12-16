import WordsCollectorDir.WordsCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


public class WordsCollectorTestClass {

    private final static String PATH_TO_TEST = "TestResources/Test/TestWords.txt";
    private final static String PATH_TO_ORIGINALFILE = "resources/wordlist.txt";
    @Test
    public void TestCanLoadAllWords(){
        HashSet<String> actual = WordsCollector.getAllCharactersFromFile(PATH_TO_TEST);
        HashSet<String> expected = getExpected();
        Assertions.assertEquals(actual.size(), expected.size());
    }

    @Test
    public void TestWordsAreInList(){
        HashSet<String> actual = WordsCollector.getAllCharactersFromFile(PATH_TO_ORIGINALFILE);
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


}
