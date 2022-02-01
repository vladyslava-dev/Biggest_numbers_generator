package com.company;

import java.util.*;

public class ArrayWithBiggestNumbersGenerator extends ArrayGenerator {
    int length;

    public ArrayList<Integer> generateArray(ArrayList<Integer> firstArray) {
        System.out.print("Podaj ilość poszukiwanych największych liczb: ");
        try {
            length = scanner.nextInt();
            if (length > firstArray.size() || length < 1) {
                badInputError.exitProgram();
            }


        } catch (InputMismatchException e) {
            System.out.println("Ilość musi być liczbą całą większą od 1");
            badInputError.exitProgram();
        }


        Collections.sort(firstArray);
        Collections.reverse(firstArray);
        for (int i = 0; i < length; i++) {
            numbersArray.add(firstArray.get(i));


        }

        return numbersArray;
    }

}
