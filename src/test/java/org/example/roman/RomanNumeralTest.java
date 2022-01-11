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

    @Test
    void convertXIShouldReturnEleven() {
        int num = romanNumeral.convert("XI");

        assertEquals(11, num, "XI should retun 11");
    }

    @Test
    void convertIVShouldReturnFour() {
        int num = romanNumeral.convert("IV");

        assertEquals(4, num, "IV should return 4");
    }

}