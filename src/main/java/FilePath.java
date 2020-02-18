

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;


public class FilePath {
    private static String path;

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        FilePath.path = path;
    }

    public void takePath(int selection) {
        //boolean fileExist = false;


        if (selection == 1) {
            path = "null";
            while ((isFileExist(path) != true) && !(path.equals("Q"))) {
                path = null;
                System.out.println("Podaj ścięzkę do pliku: " + "(przykład: C:\\Users\\hooli\\Desktop\\słowa.txt)");
                Scanner scanner = new Scanner(System.in);
                path = scanner.nextLine();

                if (isFileExist(path)) {
                    CountInFile.setFilePath(Paths.get(path).toString());
                } else {
                    System.out.println(path);
                    System.out.println("Plik nie istnieje lub podana ścieżka jest nie prawidłowa. Spróbuj ponownie lub wciśnij shift + Q aby powrócić do menu.");
                }
            }
        } else {
            if (isFileExist(path)) {
                //System.out.println("Tutaj jestem");
                CountInFile.setFilePath(Paths.get(path).toString());
            } else {
                System.out.println(path);
                System.out.println("Plik nie istnieje lub podana ścieżka jest nieprawidłowa. Spróbuj ponownie lub wciśnij shift + Q aby powrócić do menu.");
            }

        }
    }

    public boolean isFileExist(String path) {
        File file = new File(path);
        boolean fileExist = file.exists();
        return fileExist;
    }
}

