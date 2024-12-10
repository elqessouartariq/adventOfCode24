package aoc.day09;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day09 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(input));
                String[] line = br.readLine().split("");

                char[] id = BuildIdString(line);
                moveBlocks(id);
                long result = sum(id);

                return String.valueOf(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "File does not exist";
        }
    }

    private static void moveBlocks(char[] id) {
    int i = 0;
    int j = id.length - 1;

    while (i < j) {
        while (i < j && id[i] != '.') {
            i++;
        }
        while (i < j && id[j] == '.') {
            j--;
        }
        if (i < j) {
            id[i] = id[j];
            id[j] = '.';
            i++;
            j--;
        }
    }
}
    private static long sum(char[] id) {
        long count = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] != '.') {
                count += (long) (id[i] - '0') * i;
            }
        }
        return count;
    }
    private static char[] BuildIdString(String[] line) {
        int totalLength = 0;
        // Calculate the total length of the id string by adding the file length and spaces
        for (int i = 0; i < line.length; i += 2) {
            totalLength += Integer.parseInt(line[i]);
            if (i + 1 < line.length) {
                totalLength += Integer.parseInt(line[i + 1]);
            }
        }

        char[] id = new char[totalLength];
        int index = 0;

        for (int i = 0; i < line.length; i += 2) {
            int fileLen = Integer.parseInt(line[i]);
            int spaces = (i + 1 < line.length) ? Integer.parseInt(line[i + 1]) : 0;

            for (int j = 0; j < fileLen; j++) {
                id[index++] = (char) ('0' + i / 2);
            }

            for (int j = 0; j < spaces; j++) {
                id[index++] = '.';
            }
        }

        return id;
    }

    @Override
    public String part2(String input) {
        File file = new File(input);

        int count = 0;

        if (file.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(input));
                System.out.println("ss");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            return String.valueOf(count);
        } else {
            return "File does not exist";
        }
    }


}
