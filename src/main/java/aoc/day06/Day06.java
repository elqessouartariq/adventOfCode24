package aoc.day06;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day06 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(input));
                String[][] matrix = Files.lines(Path.of(input))
                        .map(line -> line.trim().split(""))
                        .toArray(String[][]::new);

                int rows = matrix.length;
                int cols = matrix[0].length;

                boolean found = false;
                int startI = 0, startJ = 0;
                for (int i = 0; i < rows ; i++) {
                    for (int j = 0; j < cols ; j++) {
                       //Find the key ^ position
                        if(matrix[i][j].equalsIgnoreCase("^")){
                            found = true;
                            startI = i;
                            startJ = j;
                            break;
                        }
                    }
                    if (found) break;
                }
                int dir = 0;
                int directions[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

                Set<String> visited = new HashSet<>();

                visited.add(startI + "," + startJ);

                int i = startI;
                int j = startJ;

                while (true){
                    int nextI = i + directions[dir][0];
                    int nextJ = j + directions[dir][1];

                    if (nextI < 0 || nextI >= rows || nextJ < 0 || nextJ >= cols) {
                        break;
                    }

                    if (matrix[nextI][nextJ].equalsIgnoreCase("#")) {
                        dir = (dir + 1) % 4;
                    } else {
                        i = nextI;
                        j = nextJ;
                        visited.add(i +","+ j);
                    }
                }
                return String.valueOf(visited.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "File does not exist";
        }
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
