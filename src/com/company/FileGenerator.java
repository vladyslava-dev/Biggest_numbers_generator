package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileGenerator {
    Scanner scanner;
    ArrayList<Integer> initialArray;
    ArrayList<Integer> biggestNumbersArray;
    String fileName;
    BadInputError badInputError;


    FileGenerator(ArrayList<Integer> initialArray, ArrayList<Integer> biggestNumbersArray) {
        this.initialArray = initialArray;
        this.biggestNumbersArray = biggestNumbersArray;
        scanner = new Scanner(System.in);
        badInputError = new BadInputError();

    }


    void generateFile() {
        System.out.print("Chcesz wyeksportować te dane do pliku? Wpisz 'tak' lub 'nie': ");
        if (Objects.equals((scanner.nextLine()).toLowerCase(), "tak")) {
            System.out.print("Podaj nazwę pliku: ");
            fileName = scanner.nextLine();

            try {
                File file = new File(String.format("%s.txt", fileName));

                if (!file.exists())
                    file.createNewFile();


                PrintWriter pw = new PrintWriter(file);
                pw.println("Wstępny zbiór liczb: " + initialArray);
                pw.println("Największe " + biggestNumbersArray.size() + " liczb(y) z tego zbioru: " + biggestNumbersArray);
                pw.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }


        }


    }


}
