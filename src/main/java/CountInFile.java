import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;


public class CountInFile {

    private static String filePath;

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        CountInFile.filePath = filePath;
    }

    public static void countEachWord(Map<String, Integer> words) throws FileNotFoundException {
        Integer count = 0;
        words.clear();
        Scanner file = new Scanner(new File(filePath));
        while (file.hasNext()) {
            String word = file.next().replaceAll("\\p{Punct}", "").toLowerCase();
            count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);

        }
        file.close();

    }

    public static int countAllWords() throws FileNotFoundException {

        Scanner file = new Scanner(new File(filePath));
        int qty = 0;
        while (file.hasNext()) {
            qty = qty + 1;
            String word = file.next().replaceAll("\\p{Punct}", "").toLowerCase();
        }
        file.close();
        return qty;
    }

    public static int countAllSign() throws FileNotFoundException, IOException {

        Scanner file = new Scanner(new File(filePath));
        int qty;
        return qty = Files.lines(Paths.get(filePath)).mapToInt(String::length).sum();

    }

    public static void countSelectWord(Map<String, Integer> words, String selectWord) throws FileNotFoundException {
        int qtySelect = 0;
        words.clear();
        try {
            Scanner file = new Scanner(new File(filePath));
            Integer count = 0;
            while (file.hasNext()) {
                String word = file.next().replaceAll("\\p{Punct}", "").toLowerCase();
                count = words.get(word);
                if (count != null)
                    count++;
                else
                    count = 1;
                words.put(word, count);

            }
            if (words.containsKey(selectWord)) {
                qtySelect = words.get(selectWord);
                System.out.println("Słowo " + selectWord + " występuje w pliku " + qtySelect + (qtySelect > 1 ? " razy." : " raz."));
            } else {
                System.out.println("W pliku nie występuje słwo: " + selectWord + ".");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie podano ścieżki pliku lub podana ścieżka jest nieprawidłowa.");
        }


    }

}
