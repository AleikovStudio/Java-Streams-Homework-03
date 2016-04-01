package com.tutorials7.java.homework.streams03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pr_03_CountCharacterTypes {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/words.txt"));) {

            String line = reader.readLine();

            List<String> lineArray = new ArrayList<>();
            while (line != null) {
                lineArray.add(line);
                line = reader.readLine();
            }
            //CHECK IF THE ARRAY IS WORKING  System.out.println(lineArray);
            //            for (int i = 0; i < lineArray.size(); i++) {
            //                System.out.println(lineArray.get(i));
            //            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/count-chars.txt"))) {

                int countVowels = 0;
                int countConsonants = 0;
                int countPunctuation = 0;

                String[] array = new String[lineArray.size()];

                for (int i = 0; i < lineArray.size(); i++) {
                    array[i] = lineArray.get(i);
                    String inspectLine = array[i];

                    for (int j = 0; j < inspectLine.length(); j++) {
                        switch (inspectLine.charAt(j)) {
                            case 'a':
                                countVowels += 1;
                                break;
                            case 'e':
                                countVowels += 1;
                                break;
                            case 'i':
                                countVowels += 1;
                                break;
                            case 'o':
                                countVowels += 1;
                                break;
                            case 'u':
                                countVowels += 1;
                                break;
                            case ' ':
                                break;
                            case '!':
                                countPunctuation += 1;
                                break;
                            case ',':
                                countPunctuation += 1;
                                break;
                            case '.':
                                countPunctuation += 1;
                                break;
                            case '?':
                                countPunctuation += 1;
                                break;
                            default:
                                countConsonants += 1;
                                break;
                        }
                    }
                }
                writer.write("Vowels: " + countVowels);
                writer.newLine();
                writer.write("Consonants: " + countConsonants);
                writer.newLine();
                writer.write("Punctuation: " + countPunctuation);

                writer.close();
                System.out.println("Success!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File NOT FOUND! SEARCH FOR IT!");
        } catch (IOException e) {
            System.out.println("Another GENERAL mistake!");
        }
    }
}
