package com.oneclick.productservice.oracle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOracle {

    @Test
    void testMoveZerosToEnd() {
        List<Integer> input = Arrays.asList(0, 1, 0, 3, 12);
        List<Integer> expectedOutput = Arrays.asList(1, 3, 12, 0, 0);
        assertEquals(expectedOutput, moveZerosToEnd(input));
    }

    @Test
    void init() {
        int d = 2;
        List<Integer> input = Arrays.asList(1, 3, 4, 5);
        List<Integer> rotatedList = new ArrayList<>(input.subList(d, input.size()));
        rotatedList.addAll(input.subList(0, d));

    }
     @Test
     void wordRepetition() {
         String word = "abba";
         int distance = 2;
         assertEquals(2, wordRepetition(word, distance));
     }

     private int wordRepetition(String word, int distance) {
            int count = 0;
            for (int i = 0; i < word.length() - distance; i++) {
                if (word.charAt(i) == word.charAt(i + distance)) {
                    count++;
                }
            }
         return count;
     }
    private List<Integer> moveZerosToEnd(List<Integer> input) {
        int insertPosition = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != 0) {
                input.set(insertPosition++, input.get(i));
            }
        }
        while (insertPosition < input.size()) {
            input.set(insertPosition++, 0);
        }
        return input;
    }
}
