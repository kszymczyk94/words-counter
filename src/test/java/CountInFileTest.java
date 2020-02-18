import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountInFileTest {


    Map<String, Integer> words = new HashMap<>();
    String path = "test.txt";
    FilePath filePath = new FilePath();

    @Test
    void countEachWord() throws FileNotFoundException {
        Map<String, Integer> test1 = new HashMap<String, Integer>() {{
            put("jedynie", 1);
            put("wtedy", 1);
            put("coś", 1);
            put("waży", 1);
            put("fraszka", 1);
            put("gdy", 1);
            put("jest", 1);
            put("zarazem", 1);
            put("lekka", 1);
            put("i", 1);
            put("ważka", 1);
            put("leopold", 1);
            put("lewin", 1);

        }};
        CountInFile.setFilePath(path);
        CountInFile.countEachWord(words);
        assertEquals(words, test1);

    }

    @Test
    void countAllWords() throws FileNotFoundException {
        CountInFile.setFilePath(path);
        assertEquals(CountInFile.countAllWords(), 13);
    }

    @Test
    void countAllSign() throws IOException {
        CountInFile.setFilePath(path);
        assertEquals(CountInFile.countAllSign(), 75);
    }

    @Test
    void countSelectWord() throws FileNotFoundException {
        CountInFile.setFilePath(path);
        assertEquals(CountInFile.countSelectWord(words, "fraszka"), 1);
    }
}