package org.example.commons;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileCreator {

    public String setNameWriteText(List<String> textList) {
        System.out.println("Podaj nazwę pliku (opcjonalnie wraz ze ścieżką: )");
        System.out.println("Uwaga jeżeli plik o podanej nazwie już istnieje zostanie on nadpisany.");
        String fileName;
        do {
            System.out.println("Nazwa pliku musi być zakończona rozszerzeniem .txt i nie może zawierać znaków /, \\, :, *, ?, \", <, > |,");
            Scanner scCreateFileName = new Scanner(System.in);
            fileName = scCreateFileName.nextLine();

        } while (!fileName.endsWith(".txt"));

        Scanner scTextToFile = new Scanner(System.in);
        System.out.println("Podaj ilość wierszy w pliku: ");
        int size = scTextToFile.nextInt();

        System.out.println("Plik będzie miał " + size + " wierszy, wpisz tekst potwierdzając każdą linie klawiszem Enter: ");

        if (scTextToFile.nextLine().isEmpty()) System.out.println("<");
        for (int i = 0; i < size; i++) {
            if (scTextToFile.hasNextLine() && i < size) {
                textList.add(i, scTextToFile.nextLine());
            } else scTextToFile.close();
        }
        return fileName;
    }

    public void createFile(String fileName, List<String> textList) throws IOException {
        FileWriter fileWriter = null;


        FilePath filePath = new FilePath();
        if (fileName.contains("\\")) {
            fileName = Paths.get(fileName).toString();


        }
        System.out.println(textList);

        try {

            fileWriter = new FileWriter(fileName);
            for (int i = 0; i < textList.size(); i++) {
                fileWriter.write(textList.get(i) + "\n");


            }
            if (filePath.isFileExist(fileName)) {
                System.out.println("Plik został utworzony.");
                filePath.setPath(fileName);
                filePath.takePath(2);
            }
            //fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        }


    }
}
