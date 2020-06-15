import org.junit.Assert;
import org.junit.Test;
import wordfrequency.WordsFrequency;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequencyTest {

    @Test
    public void areHashMapEquals() {
        final String string = "a midnight dreary a";
        Map<String, Long> expected = new HashMap();
        expected.put("a", 2L);
        expected.put("midnight", 1L);
        expected.put("dreary", 1L);
        Map<String, Long> result = WordsFrequency.calculateWordsFrequency(string);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void areHashMapExpected() {
        final String string = "a,     ,3333 midnight dreary a";
        Map<String, Long> expected = new HashMap();
        expected.put("a", 2L);
        expected.put("midnight", 1L);
        expected.put("dreary", 1L);
        Map<String, Long> result = WordsFrequency.calculateWordsFrequency(string);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void areHashMapStringExpected() {
        Map<String, Long> hashMap = new HashMap();
        hashMap.put("a", 2L);
        hashMap.put("midnight", 1L);
        hashMap.put("dreary", 1L);

        String expected = "a 2\nmidnight 1\ndreary 1";

        String result = WordsFrequency.mapToString(hashMap);
        Assert.assertEquals(expected, result);
    }

}
