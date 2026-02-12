package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SonarBugDemo {

    // Hardcoded password (Security Hotspot)
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        String input = null;

        // Possible NullPointerException
        if (input.equals("test")) {
            System.out.println("Test");
        }

        // Resource leak (FileReader not closed properly)
        try {
            FileReader fileReader = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println(br.readLine());
        } catch (Exception e) {
            // Empty catch block (bad practice)
        }

        // Unused variable
        int unusedNumber = 10;

        // Duplicated code block
        calculate(10);
        calculate(10);
    }

    public static int calculate(int number) {
        if (number == 10) {
            return number * 2;
        } else {
            return number * 2;  // Duplicate logic
        }
    }
}
