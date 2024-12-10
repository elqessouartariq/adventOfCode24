package aoc.day09;

import aoc.day08.Day08;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day09Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day09\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day09().part1(path);
        assertEquals("6283404590840", result);
    }

    @Test
    public void testPart2(){
        String result = new Day09().part2(path);
        assertEquals("", result);
    }
}
