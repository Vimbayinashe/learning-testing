package org.example.roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    @Test
    void convertXIShouldReturnEleven() {
        int num = romanNumeral.convert("XI");

        assertEquals(11, num, "XI should return 11");
    }

    @Test
    void convertIVShouldReturnFour() {
        int num = romanNumeral.convert("IV");

        assertEquals(4, num, "IV should return 4");
    }

    @Test
    void smallRomanNumeralThrowsException() {
        assertThrows(NullPointerException.class, () -> romanNumeral.convert("x"));
    }

}
