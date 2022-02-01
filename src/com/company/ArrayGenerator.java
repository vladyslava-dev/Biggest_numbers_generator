package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ArrayGenerator {
    Scanner scanner;
    ArrayList<Integer> numbersArray;
    BadInputError badInputError;


    ArrayGenerator() {
        scanner = new Scanner(System.in);
        numbersArray = new ArrayList<>();
        badInputError = new BadInputError();
    }

}
