package org.example.tests;

public class Brackets {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        if (misMatchingBrackets(s))
            return false;

        return true;
    }

    private boolean misMatchingBrackets(String s) {
        int countRound = 0;
        int countSquare = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                countRound++;
            if (s.charAt(i) == ')')
                countRound--;
            if (s.charAt(i) == '[')
                countSquare++;
            if (s.charAt(i) == ']')
                countSquare--;

            if (countRound < 0 || countSquare < 0)
                return true;
        }
        return !(countRound == 0 && countSquare == 0);
    }
}
