package com.tutorials7.java.homework.streams03;

import java.io.*;

public class Pr_00_JavaStreamsExercises {

    public static void main(String[] args) throws IOException {
        File users = new File("resources/users.txt");
        File totalPlayed = new File("resources/total-played.txt");

        BufferedReader reader = new BufferedReader(new FileReader(users));
        BufferedWriter writer = new BufferedWriter(new FileWriter(totalPlayed));
        String line = reader.readLine();
        System.out.println(line);

        while (line != null) {
            String[] lineArray = line.split(" ");
            String username = lineArray[0];

            int totalMinutesPlayed = 0;

            for (int i = 1; i < lineArray.length; i++) {
                String[] time = lineArray[i].split(":");

                int hours = Integer.parseInt(time[0]) * 60;
                int minutes = Integer.parseInt(time[1]);
                totalMinutesPlayed += hours + minutes;
            }
            int totalMinutesPlayedToCount = totalMinutesPlayed;
            int minutesInDay = 1400;
            int daysPlayed = totalMinutesPlayedToCount / minutesInDay;
            totalMinutesPlayedToCount %= minutesInDay;
            int hoursPlayed = totalMinutesPlayedToCount / 60;
            totalMinutesPlayedToCount %= 60;
            int minutesPlayed = totalMinutesPlayedToCount;

            String outputToWrite = String.format("%s %d (%d days, %d hours, %d minutes) \r\n", username, totalMinutesPlayed, daysPlayed, hoursPlayed, minutesPlayed);
            writer.write(outputToWrite);

            line = reader.readLine();
        }

        writer.close();
        reader.close();
    }
}
