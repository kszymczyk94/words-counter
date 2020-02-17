import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private boolean exit = false;

    public void runMenu() throws IOException {
        showMenu();
        while (!exit) {
            int choice = getInput();
            performAction(choice);
        }
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 7) {
            try {
                //System.out.println("Wybierz opcję: ");
                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
        return choice;
    }

    private void showMenu() {


        System.out.println("|================================================================|");
        System.out.println("|                          WORDS COUNTER                         |");
        System.out.println("|                              MENU                              |");
        System.out.println("|================================================================|");
        System.out.println();
        System.out.println("Dostępne opcje: ");
        System.out.println();
        System.out.println("[1] Podaj ścieżkę do pliku tekstowego");
        System.out.println("[2] Utwórz nowy plik tekstowy");
        System.out.println("[3] Policz ilość słów w pliku");
        System.out.println("[4] Policz liczbę wystąpień każdego ze słów w tekście");
        System.out.println("[5] Policz liczbę wystąpień konkretnego słowa");
        System.out.println("[6] Policz liczbę znaków");
        System.out.println("[7] Zakończ");
        System.out.println();
        System.out.println("Kliknij klawisz od 1 - 7: ");


    }

    private void performAction(int choice) throws IOException {
        switch (choice) {


            case 1:
                System.out.println("|================================================================|");
                System.out.println("|                          WORDS COUNTER                         |");
                System.out.println("|                                                                |");
                System.out.println("|================================================================|");
                System.out.println("|                                                                |");
                System.out.println("|                                                                |");
                System.out.println("|              [1] Podaj ścieżkę do pliku tekstowego             |");
                System.out.println("-----------------------------------------------------------------");
                System.out.println();
                System.out.println();
                System.out.println();
                FilePath filePath = new FilePath();
                filePath.takePath(1);
                showMenu();
                //System.out.println("[Q] - powrót do menu");

                break;

            case 2:
                System.out.println("[2]");
                FileCreator fileCreator = new FileCreator();;
                ArrayList<String> textList = new ArrayList<>();
                System.out.println("Podaj nazwę pliku (opcjonalnie wraz ze ścieżką: )");
                String fileName;
                do{
                    System.out.println("Nazwa pliku musi zawierać rozszerzenie .txt");
                    Scanner scCreateFileName = new Scanner(System.in);
                    fileName = scCreateFileName.nextLine();

                }while(!fileName.endsWith(".txt"));

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


                fileCreator.createFile(fileName, textList);
                //scTextToFile.close();

                break;

            case 3:
                System.out.println("[3]");
                System.out.println(CountInFile.countAllWords());
                break;

            case 4:
                System.out.println("[4]");
                Map<String, Integer> words = new HashMap<>();
                CountInFile.countEachWord(words);
                words.entrySet().forEach(stringIntegerEntry -> {
                    System.out.println("Słowo " + "\"" + stringIntegerEntry.getKey() + "\"" + " wystąpiło: " + stringIntegerEntry.getValue());
                });

                break;

            case 5:
                System.out.println("[5]");
                Map<String, Integer> wordsSel = new HashMap<>();
                System.out.println("Podaj słowo jakiego chcesz szukać w tekście");
                Scanner scSelectWord = new Scanner(System.in);
                String selectWord = scSelectWord.nextLine();
                CountInFile.countSelectWord(wordsSel, selectWord);

                break;

            case 6:
                System.out.println("[6]");
                System.out.println(CountInFile.countAllSign());


                break;

            case 7:
                exit = true;
                break;


        }

    }
}
