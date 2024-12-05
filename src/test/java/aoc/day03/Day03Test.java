package aoc.day03;

import aoc.day02.Day02;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day03Test {
    final String path = "D:\\my_land\\adventofcode\\src\\main\\java\\aoc\\day03\\test.txt";
    @Test
    public void testPart1(){
        String result = new Day03().part1(path);
        assertEquals("153469856", result);
    }

    @Test
    public void testPart2(){
        String result = new Day03().part2(path);
        assertEquals("77055967", result);
    }

}
