package aoc.day01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day01Test {

    @Test
    public void testPart1(){
        String input = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day01\\test.txt";
        String result = new Day01().part1(input);
        assertEquals("2378066", result);
    }

    @Test
    public void testPart2(){
        String input = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day01\\tst.txt";
        String result = new Day01().part2(input);
        assertEquals("18934359", result);
    }

}
