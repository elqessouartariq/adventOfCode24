package aoc.day05;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day05 implements Day {
    final String updates = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day05\\updates.txt";
    @Override
    public String part1(String input) {
        File rulesFile = new File(input);
        File upladtesFile = new File(updates);
        Map<String, Set<String>> rulesMap =  new HashMap<>();

        int count = 0;

        if (rulesFile.exists() && upladtesFile.exists()) {
            try {
                BufferedReader rulesBr = new BufferedReader(new FileReader(rulesFile.getPath()));
                BufferedReader updateBr = new BufferedReader(new FileReader(upladtesFile.getPath()));

                String line = null;
                while((line = rulesBr.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    rulesMap.computeIfAbsent(parts[0], k -> new HashSet<String>()).add(parts[1]);
                }

                while((line = updateBr.readLine()) != null) {
                    String[] rules = line.split(",");
                    boolean valid = true;

                    for (int i = 0; i < rules.length; i++) {
                        for (int j = i + 1; j < rules.length; j++) {
                            if(!rulesMap.getOrDefault(rules[i], new HashSet<>()).contains(rules[j])){
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        int midPos = rules.length / 2;
                        count += Integer.parseInt(rules[midPos]);
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

    @Override
    public String part2(String input) {
        File file = new File(input);

        int count = 0;

        if (file.exists()) {
//            try {
//
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            return String.valueOf(count);
        } else {
            return "File does not exist";
        }
    }

}
