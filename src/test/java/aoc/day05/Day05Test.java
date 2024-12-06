package aoc.day05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day05Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day05\\rules.txt";
    @Test
    public void testPart1(){
        String result = new Day05().part1(path);
        assertEquals("5268", result);
    }

    @Test
    public void testPart2(){
        String result = new Day05().part2(path);
        assertEquals("5799", result);
    }
}
