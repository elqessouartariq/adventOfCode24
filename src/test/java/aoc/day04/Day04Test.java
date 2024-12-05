package aoc.day04;

import aoc.day03.Day03;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day04Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day04\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day04().part1(path);
        assertEquals("2434", result);
    }

    @Test
    public void testPart2(){
        String result = new Day04().part2(path);
        assertEquals("1835", result);
    }

}
