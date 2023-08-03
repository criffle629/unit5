package com.unit5test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.unit5.MissingNumber;

public class MissingNumberTest {
    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private MissingNumber missingNumber = new MissingNumber();

    @Test
    public void testMissingNumber_MissingMax() {
        assertEquals(10, missingNumber.missingNum(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, missingNumber.missingNum(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(7, missingNumber.missingNum(missingSeven, 10));
    }
}
