package com.oneclick.productservice.oracle;

import org.junit.jupiter.api.Test;

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

    private List<Integer> moveZerosToEnd(List<Integer> input) {
        int insertPosition = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != 0) {
                input.set(insertPosition++, input.get(i));
            }
        }
        while(insertPosition <input.size()){
            input.set(insertPosition++,0);
        }
        return input;
    }
}
