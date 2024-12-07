package aoc.day06;

import aoc.day05.Day05;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day06Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day06\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day06().part1(path);
        assertEquals("4580", result);
    }

    @Test
    public void testPart2(){
        String result = new Day06().part2(path);
        assertEquals("5799", result);
    }
}
