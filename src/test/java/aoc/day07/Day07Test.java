package aoc.day07;

import aoc.day07.Day07;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day07Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day07\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day07().part1(path);
        assertEquals("1289579105366", result);
    }

    @Test
    public void testPart2(){
        String result = new Day07().part2(path);
        assertEquals("", result);
    }
}
