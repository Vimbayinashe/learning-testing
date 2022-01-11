package org.example.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    @Test
    void convertInvalidRomanNumeralReturnsZero() {
        int num = romanNumeral.convert("XZI");

        assertEquals(0, num, "Invalid roman numeral returns 0");
    }

}