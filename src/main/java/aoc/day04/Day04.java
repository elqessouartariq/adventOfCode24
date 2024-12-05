package aoc.day04;

import aoc.Day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 implements Day {
    @Override
    public String part1(String input) {
        File file = new File(input);

        int count = 0;
        if (file.exists()) {
            try {
                String[][] matrix = Files.lines(Path.of(input))
                        .map(line -> line.trim().split(""))  // Split each character
                        .toArray(String[][]::new);

                int row_length = matrix.length;
                int column_length = matrix[0].length;

                for (int i = 0; i < row_length; i++) {
                    for (int j = 0; j < column_length; j++) {
                       if(matrix[i][j].contentEquals("X")) {

                           if (i >= 3) {
                               count += checkTop(matrix, j, i - 3, i);
                           }

                           if (i < row_length - 3) {
                               count += checkBottom(matrix, j, i, i + 3);
                           }

                           if (j >= 3) {
                               count += checkLeft(matrix, i, j - 3, j);
                           }

                           if (j < column_length - 3) {
                               count += checkRight(matrix, i, j , j + 3);
                           }

                           if (i >= 3 && j >= 3) {
                               count += checkTopLeft(matrix, i - 3, j - 3);
                           }

                           if (i <= row_length - 4 && j >= 3) {
                                count += checkBottomLeft(matrix, i, j);
                           }

                           if (i >= 3 && j <= column_length - 4) {
                               count += checkTopRight(matrix, i, j );
                           }

                           if (i <= row_length - 4 && j <= column_length - 4) {
                                count += checkBottomRight(matrix, i, j);
                           }
                       }
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

    private int checkBottomLeft(String[][] matrix, int i, int j) {
        String concate = "";
        for (int k = 0; k <= 3 ; k++) {
            concate += matrix[i + k][j -k];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkTopRight(String[][] matrix, int i, int j) {
        String concate = "";
        for (int k = 0; k <= 3 ; k++) {
            concate += matrix[i - k][j + k];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkLeft(String[][] matrix, int i, int start, int end) {
        String concate = "";
        for (int j = start; j <= end ; j++) {
            concate += matrix[i][j];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkRight(String[][] matrix, int i, int start, int end) {
        String concate = "";
        for (int j = start; j <= end ; j++) {
            concate += matrix[i][j];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkBottom(String[][] matrix, int j, int start, int end) {
        String concate = "";
        for (int i = start; i <= end ; i++) {
            concate += matrix[i][j];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkTop(String[][] matrix, int j, int start, int end) {
        String concate = "";
        for (int i = start; i <= end ; i++) {
            concate += matrix[i][j];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkTopLeft(String[][] matrix, int i, int j) {
        String concate = "";
        for (int k = 0; k <= 3 ; k++) {
            concate += matrix[i + k][j + k];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }
    private int checkBottomRight(String[][] matrix, int i, int j) {
        String concate = "";
        for (int k = 0; k <= 3 ; k++) {
            concate += matrix[i + k][j + k];
        }
        if(concate.equalsIgnoreCase("XMAS") || concate.equalsIgnoreCase("SAMX")){
            return 1;
        }
        return 0;
    }

    @Override
    public String part2(String input) {
        File file = new File(input);

        int count = 0;

        if (file.exists()) {
            try {
                    String[][] matrix = Files.lines(Path.of(input))
                            .map(line -> line.trim().split(""))  // Split each character
                            .toArray(String[][]::new);

                    int row_length = matrix.length;
                    int column_length = matrix[0].length;

                    for (int i = 0; i < row_length; i++) {
                        for (int j = 0; j < column_length; j++) {
                            if(matrix[i][j].contentEquals("A")) {
                                if(i >= 1 && i <= row_length - 2 && j <=column_length - 2 && j >= 1)
                                    count += checkXmas(matrix,i,j);
                            }
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

    private int checkXmas(String[][] matrix, int i, int j) {
        String d1 = matrix[i-1][j-1] + "A" +  matrix[i+1][j+1];
        String d2 =  matrix[i-1][j+1] + "A" + matrix[i+1][j-1];

//        System.out.println("d1: " + d1);
//        System.out.println("d1: " + d2);

        if((d1.equalsIgnoreCase("MAS") || d1.equalsIgnoreCase("SAM")) &&
                (d2.equalsIgnoreCase("MAS") || d2.equalsIgnoreCase("SAM"))){
            return 1;
        }
        return 0;
    }

}
