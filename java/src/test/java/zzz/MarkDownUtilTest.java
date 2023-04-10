package zzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownUtilTest {

    @Test
    void table() {
        MarkDownUtil.table()
                .tbody("[6, 36, 81, 44, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]")
                .tbody("[6, 36, 81, 44, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]")
                .tbody("[6, 36, 44, 81, 12, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]")
                .tbody("[6, 36, 44, 12, 81, 7, 43, 49, 2, 92, 18, 15, 28, 96, 31]")
                .tbody("[2, 6, 7, 12, 15, 18, 28, 31, 36, 43, 44, 49, 81, 92, 96]")
                .print();
    }
}