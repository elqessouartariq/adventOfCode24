package aoc.day02;

import aoc.day01.Day01;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day02Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day02\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day02().part1(path);
        assertEquals("402", result);
    }

    @Test
    public void testPart2(){
        String result = new Day02().part2(path);
        assertEquals("455", result);
    }

}
