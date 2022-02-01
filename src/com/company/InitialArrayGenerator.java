package com.company;

import java.util.*;

public class InitialArrayGenerator extends ArrayGenerator {


    public ArrayList<Integer> generateArray() {
        System.out.print("Chcesz podać ciąg liczb samodzielnie lub wygenerować automatycznie? Wpisz 'sam' lub 'auto': ");
        String userChoice = scanner.nextLine();

        if (Objects.equals(userChoice, "sam")) {
            numbersArray = getArrayFromTheUser();
        } else if (Objects.equals(userChoice, "auto")) {
            numbersArray = generateRandomArray();
        } else {
            badInputError.exitProgram();
        }

        return numbersArray;
    }

    ArrayList<Integer> getArrayFromTheUser() {
        System.out.print("Podaj ciąg lizb rzeczywistych dodatnich, oddzielonych przecinkiem (np. [1,2,3] lub 1,2,3): ");
        String userStringArray = scanner.nextLine();

        // delete spaces and redundant symbols from string
        userStringArray = userStringArray.replaceAll("\\s", "")
                .replaceAll("\\[", "")
                .replaceAll("]", "");

        // split string by comma
        ArrayList<String> stringArray = new ArrayList<>(Arrays.asList(userStringArray.split(",")));


        try {
            for (String str : stringArray) {
                numbersArray.add(Integer.parseInt(str));
            }
        } catch (NumberFormatException e) {
            badInputError.exitProgram();
        }

        return numbersArray;

    }

    ArrayList<Integer> generateRandomArray() {
        int length = 0;
        Random random = new Random();

        System.out.print("Podaj ilość liczb w ciągu większą od 1: ");
        try {
            length = scanner.nextInt();
            if (length < 2) {
                System.out.println("Ilość liczb musi być większą od 1");
                badInputError.exitProgram();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ilość liczb być liczbą całą większą od 1");
            badInputError.exitProgram();
        }

        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt((5000 - 1) + 1) + 1;
            numbersArray.add(randomNum);
        }
        System.out.println("Twój zbiór liczb: " + numbersArray);
        return numbersArray;
    }

}
