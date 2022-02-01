package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> initialArray = new InitialArrayGenerator().generateArray();
        ArrayList<Integer> biggestNumbersArray = new ArrayWithBiggestNumbersGenerator().generateArray(initialArray);

        System.out.println("Zbiór " + biggestNumbersArray.size() + " większych liczb: " + biggestNumbersArray);

        new FileGenerator(initialArray, biggestNumbersArray).generateFile();


    }
}
