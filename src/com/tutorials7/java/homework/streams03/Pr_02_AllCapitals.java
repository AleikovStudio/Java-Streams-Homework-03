package com.tutorials7.java.homework.streams03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pr_02_AllCapitals {
    public static void main(String[] args) throws IOException {
        File lines = new File("resources/linesCapital.txt");

        BufferedReader reader = new BufferedReader(new FileReader(lines));

        String line = reader.readLine();

        List<String> lineArray = new ArrayList<>();

        while (line != null) {
            lineArray.add(line.toUpperCase());
            line = reader.readLine();
        }

        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/linesCapital.txt"));
        PrintWriter printWriter = new PrintWriter("resources/linesCapital.txt");

        for (int i = 0; i < lineArray.size(); i++) {
            printWriter.println(lineArray.get(i));
//            System.out.println(lineArray.get(i));
        }
        printWriter.close();
        writer.close();

        System.out.println("Good job!");
    }
}
