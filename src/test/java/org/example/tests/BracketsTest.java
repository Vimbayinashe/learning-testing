package org.example.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracketsTest {

    Brackets brackets = new Brackets();

    @Test
    void  emptyStringShouldBeValid() {

        Brackets brackets = new Brackets();

        boolean result = brackets.isValid("");

        assertTrue(result);
    }

    @Test
    void oddNumberOfBracketsAreInvalid() {
        Brackets brackets = new Brackets();

        boolean result = brackets.isValid("(()");

        assertFalse(result);
    }

    @Test
    void startingWithClosingBracket() {
        Brackets brackets = new Brackets();

        boolean result = brackets.isValid(")(");

        assertFalse(result);
    }

    @Test
    void endWithOpeningBracket() {
        Brackets brackets = new Brackets();

        boolean result = brackets.isValid("())(");

        assertFalse(result);
    }

    @Test
    void twoBracketTypesShouldBeValid() {    //squareBracketsInRegularBrackets
        Brackets brackets = new Brackets();

        boolean result = brackets.isValid("([])");

        assertTrue(result);
    }

    @Test
    void incorrectOpenAndCloseBracketsShouldFail() {
        Brackets brackets = new Brackets();

        boolean result = brackets.isValid("([))");

        assertFalse(result);
    }
}

// begin with the simpler / unusual scenarios
// commit after each individual test

/*
 * brakets does not exist att first & causes an error -> create Brackets class (use Alt+Enter)
 * add isValid method, it does not exist ->
 * add empty string parameter to isValid ->
 * isValid returns boolean ->
 * add assertTrue -> failing test (a good place to take a break)
 * isValid changed to 'return true',
 *
 * add new test (#2)
 * fix isValid method to pass the test
 *
 * the test will pass, but now it is time to write real code that validates a string
 *
 *
 */

// only when there is several similar tests can we refactor tests -> parameterized test



/*
   Valid scenarios:
    blank space
    ()
    []
    ([])

   Invalid Scenarios:
    )( - wrong direction index 0
    ())( - wrong direction last index
    (() - odd number of brackets
    ([)] - brackets not in order

 */