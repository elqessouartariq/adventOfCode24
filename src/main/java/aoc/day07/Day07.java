package aoc.day07;

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

public class Day07 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(input));
                String line = null;
                long count = 0;
                while((line =br.readLine()) != null){
                    long target = Long.parseLong(line.split(":")[0]);
                    int[] numbers = toArrayOfInt(line.split(":")[1].split("\\s+"));
                    int numberOfCombinations = (int) Math.pow(2, numbers.length - 1); // 2^n-1
                    //System.out.println("numb:" + numberOfCombinations);
                    for (int i = 0; i < numberOfCombinations; i++) {
                        StringBuilder equation = new StringBuilder(String.valueOf(numbers[0]));

                        for (int j = 0; j < numbers.length - 1; j++) {
                            char operation = ((i >> j) & 1) == 0 ? '+' : '*';
                            equation.append(operation).append(numbers[j + 1]);
                        }
                       // System.out.println(equation);
                        if (isEqual(target, equation.toString())) {
                            count += target;
                            break;
                        }
                    }
                }


                return String.valueOf(count);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "File does not exist";
        }
    }

    private int[] toArrayOfInt(String[] string) {
        return  Arrays.stream(string)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private  boolean  isEqual(long target, String equation){
        String[] tokens = equation.split("(?=[+*])|(?<=[+*])");
        long result = Long.parseLong(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            char operation = tokens[i].charAt(0);
            long number = Long.parseLong(tokens[i + 1]);
            if (operation == '+') {
                result += number;
            } else if (operation == '*') {
                result *= number;
            }
        }

        return target == result;
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
