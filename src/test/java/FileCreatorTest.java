import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileCreatorTest {
    FileCreator fileCreator = new FileCreator();


    @Test
    void createFile() throws IOException {
        ArrayList<String> textList = new ArrayList<>();
        fileCreator.createFile("testowy1.txt", textList);
        File file1 = new File("testowy1.txt");
        assertTrue(file1.exists());
        file1.delete();


    }
}