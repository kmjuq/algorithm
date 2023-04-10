package zzz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ArraysToolTest {

    @Test
    void generatorArray() {
        int[] intArr = {6, 36, 81, 44, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31};
        String intsStr = "[6, 36, 81, 44, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]";
        int[] intsStr2Arr = ArraysTool.generatorArray(intsStr);
        Assertions.assertArrayEquals(intArr,intsStr2Arr);
    }
}