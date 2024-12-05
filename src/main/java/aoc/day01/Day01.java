package aoc.day01;

import aoc.Day;

import java.io.*;
import java.util.*;

public class Day01 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int sum = 0;
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line = null;
                while ((line = br.readLine()) != null ){
                    left.add(Integer.parseInt(line.split("\\s+")[0]));
                    right.add(Integer.parseInt(line.split("\\s+")[1]));
                }
                Iterator<Integer> lit = left.stream().sorted().iterator();
                Iterator<Integer> rit = right.stream().sorted().iterator();

                while (lit.hasNext() && rit.hasNext()){
                    sum += Math.abs(lit.next() - rit.next());
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
        ArrayList<String> left = new ArrayList<>();
        Map<String, Integer> right = new HashMap<>();
        int sum = 0;
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                String line = null;

                while ((line = br.readLine()) != null ){
                    left.add(line.split("\\s+")[0]);
                    String key = line.split("\\s+")[1];
                    if (right.containsKey(key)){
                        int current = right.get(key);
                        right.put(key, current + 1);
                    }else{
                        right.put(key, 1);
                    }
                }

                for (String num : left) {
                    Integer count = right.getOrDefault(num,0);
                        sum += Integer.parseInt(num) * count;
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
