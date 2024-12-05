package aoc.day02;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day02 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);
        int count = 0;
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line = null;
                while ((line = br.readLine()) != null ){
                    int[] arr = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

                    if (isSafe(arr)) {
                        count++;
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return String.valueOf(count);
        } else {
            return "File does not exist";
        }
    }

    private boolean isSafe(int[] arr) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (diff > 3 || diff < -3 || diff == 0) {
                return false;
            }

            if (diff > 0) decreasing = false;
            if (diff < 0) increasing = false;
        }

        return increasing || decreasing;
    }

    @Override
    public String part2(String input) {
        File file = new File(input);
        int count = 0;
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line = null;
                while ((line = br.readLine()) != null ){
                    int[] arr = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

                    if (canBeMadeSafe(arr)) {
                        count++;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return String.valueOf(count);
        } else {
            return "File does not exist";
        }
    }
    private boolean canBeMadeSafe(int[] arr) {
        if (isSafe(arr)) return true;

        for (int i = 0; i < arr.length; i++) {
            int[] modified = new int[arr.length - 1];
            for (int j = 0, k = 0; j < arr.length; j++) {
                if (j != i) {
                    modified[k++] = arr[j];
                }
            }
            if (isSafe(modified)) {
                return true;
            }
        }
        return false;
    }
}
