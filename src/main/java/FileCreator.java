import jdk.jfr.events.FileWriteEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileCreator {

    public void createFile(String fileName, ArrayList<String> textList) throws IOException {
        FileWriter fileWriter = null;
        String path  = null;
        FilePath filePath = new FilePath();
        if (fileName.contains("\\")) {
            path = Paths.get(fileName).toString();


        }
        System.out.println(textList);

        try {

            fileWriter = new FileWriter(fileName);
            for (int i = 0; i < textList.size(); i++) {
                fileWriter.write(textList.get(i) + "\n");


            }
            if(filePath.isFileExist(fileName)){
                System.out.println("Plik został utworzony.");
            filePath.setPath(path);
            filePath.takePath(2);}

            //fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        }


    }
}
