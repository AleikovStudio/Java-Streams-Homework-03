package com.tutorials7.java.homework.streams03;

import java.io.*;

public class Pr_01_SumLines {
    public static void main(String[] args) throws IOException {
        File lines = new File("resources/lines.txt");
        BufferedReader reader = new BufferedReader(new FileReader(lines));

        String line = reader.readLine();

        while (line != null) {
            int symbolsTotalCount = 0;
            for (int i = 0; i < line.length(); i++) {
                symbolsTotalCount += line.charAt(i);
            }
            System.out.println(symbolsTotalCount);
            line = reader.readLine();
        }
        reader.close();
    }
}
