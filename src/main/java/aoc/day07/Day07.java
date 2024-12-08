package aoc.day07;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


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

        System.out.println(Arrays.toString(tokens) + ":" + result);

        return target == result;
    }
    private  boolean  isEqual2(long target, String equation){
        String[] tokens = equation.split("(?=[+*|])|(?<=[+*|])");
        long result = Long.parseLong(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            char operation = tokens[i].charAt(0);
            long number = Long.parseLong(tokens[i + 1]);
            if (operation == '+') {
                result += number;
            } else if (operation == '*') {
                result *= number;
            } else if (operation == '|'){
                result = Long.parseLong(String.valueOf(result) + String.valueOf(number));
            }
        }
        return target == result;
    }

    private List<String> readAllLines(String input) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
    private Long processLine(String line) {
        long target = Long.parseLong(line.split(":")[0]);
        int[] numbers = toArrayOfInt(line.split(":")[1].split("\\s+"));
        int numberOfCombinations = (int) Math.pow(3, numbers.length - 1);

        for (int i = 0; i < numberOfCombinations; i++) {
            StringBuilder equation = new StringBuilder(String.valueOf(numbers[0]));
            int current = i;

            for (int j = 0; j < numbers.length - 1; j++) {
                int t = current % 3;
                current /= 3;

                switch (t) {
                    case 0:
                        equation.append("*").append(numbers[j + 1]);
                        break;
                    case 1:
                        equation.append("+").append(numbers[j + 1]);
                        break;
                    case 2:
                        equation.append("|").append(numbers[j + 1]);
                        break;
                }
            }

            if (isEqual2(target, equation.toString())) {
                return target;
            }
        }

        return 0L;
    }

    @Override
    public String part2(String input) {
        File file = new File(input);
        if (!file.exists()) {
            return "File does not exist";
        }

        try {
            List<String> lines = readAllLines(input);

            int processors = Runtime.getRuntime().availableProcessors(); //12 processors
            ExecutorService executor = Executors.newFixedThreadPool(processors);

            List<CompletableFuture<Long>> futures = lines.stream()
                    .map(line -> CompletableFuture.supplyAsync(() -> processLine(line), executor))
                    .toList();

            long count = futures.stream()
                    .map(CompletableFuture::join)
                    .mapToLong(Long::longValue)
                    .sum();

            executor.shutdown();

            return String.valueOf(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
