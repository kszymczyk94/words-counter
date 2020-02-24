package org.example.api;


import org.example.utils.CountInFile;
import org.example.commons.FileCreator;
import org.example.commons.FilePath;

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

    public void waitForEnter() {
        Scanner scWaitForEnter = new Scanner(System.in);
        scWaitForEnter.hasNextLine();

    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 7) {
            try {
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
                System.out.println("Ścieżka poprawna, wciśnij enter aby wrócić do menu.");
                waitForEnter();
                showMenu();

                break;

            case 2:
                System.out.println("|================================================================|");
                System.out.println("|                          WORDS COUNTER                         |");
                System.out.println("|                                                                |");
                System.out.println("|================================================================|");
                System.out.println("|                                                                |");
                System.out.println("|                                                                |");
                System.out.println("|                   [2] Utwórz nowy plik tekstowy                |");
                System.out.println("-----------------------------------------------------------------");
                System.out.println();
                System.out.println();
                System.out.println();
                FileCreator fileCreator = new FileCreator();
                ArrayList<String> textList = new ArrayList<>();
                fileCreator.createFile(fileCreator.setNameWriteText(textList), textList);
                System.out.println("Wciśnij enter aby wrócić do menu.");
                waitForEnter();
                runMenu();


                break;

            case 3:
                if (FilePath.getPath() != null) {
                    System.out.println("|================================================================|");
                    System.out.println("|                          WORDS COUNTER                         |");
                    System.out.println("|                                                                |");
                    System.out.println("|================================================================|");
                    System.out.println("|                                                                |");
                    System.out.println("|                                                                |");
                    System.out.println("|                   [3] Policz ilość słów w pliku                |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Liczba wyrazów w pliku to: " + CountInFile.countAllWords());
                } else {
                    System.out.println("Najpierw stwórz lub wybierz plik.");
                    showMenu();
                }
                System.out.println("Wciśnij enter aby wrócić do menu.");
                waitForEnter();
                runMenu();
                break;

            case 4:
                if (FilePath.getPath() != null) {

                    System.out.println("|================================================================|");
                    System.out.println("|                          WORDS COUNTER                         |");
                    System.out.println("|                                                                |");
                    System.out.println("|================================================================|");
                    System.out.println("|                                                                |");
                    System.out.println("|                                                                |");
                    System.out.println("|     [4] Policz liczbę wystąpień każdego ze słów w tekście      |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    Map<String, Integer> words = new HashMap<>();
                    CountInFile.countEachWord(words);
                    words.entrySet().forEach(stringIntegerEntry -> {
                        System.out.println("Słowo " + "\"" + stringIntegerEntry.getKey() + "\"" + " wystąpiło: " + stringIntegerEntry.getValue());
                    });
                } else {
                    System.out.println("Najpierw stwórz lub wybierz plik.");
                }
                System.out.println("Wciśnij enter aby wrócić do menu.");
                waitForEnter();
                runMenu();

                break;

            case 5:
                if (FilePath.getPath() != null) {

                    System.out.println("|================================================================|");
                    System.out.println("|                          WORDS COUNTER                         |");
                    System.out.println("|                                                                |");
                    System.out.println("|================================================================|");
                    System.out.println("|                                                                |");
                    System.out.println("|                                                                |");
                    System.out.println("|         [5] Policz liczbę wystąpień konkretnego słowa          |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    Map<String, Integer> wordsSel = new HashMap<>();
                    System.out.println("Podaj wyraz który chcesz szukać w pliku.");
                    Scanner scSelectWord = new Scanner(System.in);
                    String selectWord = scSelectWord.nextLine();
                    CountInFile.countSelectWord(wordsSel, selectWord);
                } else {
                    System.out.println("Najpierw stwórz lub wybierz plik.");

                }
                System.out.println("Wciśnij enter aby wrócić do menu.");
                waitForEnter();
                runMenu();

                break;

            case 6:
                if (FilePath.getPath() != null) {

                    System.out.println("|================================================================|");
                    System.out.println("|                          WORDS COUNTER                         |");
                    System.out.println("|                                                                |");
                    System.out.println("|================================================================|");
                    System.out.println("|                                                                |");
                    System.out.println("|                                                                |");
                    System.out.println("|                   [6] Policz liczbę znaków                     |");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Liczba znaków tym pliku to: " + CountInFile.countAllSign());
                } else {
                    System.out.println("Najpierw stwórz lub wybierz plik.");

                }
                System.out.println("Wciśnij enter aby wrócić do menu.");
                waitForEnter();
                runMenu();

                break;

            case 7:
                System.out.println("KONIEC");
                exit = true;
                break;


        }

    }
}
