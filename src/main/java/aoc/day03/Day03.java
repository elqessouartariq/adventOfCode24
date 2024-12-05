package aoc.day03;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);

        int sum = 0;
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String regex = "mul\\((\\d+),\\s*(\\d+)\\)";
                String line = null;
                while ((line = br.readLine()) != null ){
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return String.valueOf(sum);
        } else {
            return "File does not exist";
        }
    }

    @Override
    public String part2(String input) {
        File file = new File(input);

        long sum = 0;
        if (file.exists()) {
            try {
                StringBuilder content = new StringBuilder();
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }

                String fileContent = content.toString();
                

                String doanddonotRegex = "don't\\(\\)(.*?)do\\(\\)";
                String regex = "mul\\((\\d+),\\s*(\\d+)\\)";

                Pattern pattern1 = Pattern.compile(doanddonotRegex, Pattern.DOTALL);
                Matcher matcher1 = pattern1.matcher(fileContent);

                while (matcher1.find()) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(matcher1.group(1));
                    while (matcher.find()) {
                        sum -= Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
                    }
                }

                Pattern allPattern = Pattern.compile(regex);
                Matcher matchAllmul = allPattern.matcher(fileContent);

                while (matchAllmul.find()) {
                    sum += Long.parseLong(matchAllmul.group(1)) * Long.parseLong(matchAllmul.group(2));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return String.valueOf(sum);
        } else {
            return "File does not exist";
        }
    }
}
