package org.example.tests;

import java.util.Deque;
import java.util.LinkedList;

public class Brackets {
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || isNotMatchingBrackets(c, stack.pop()))
                return false;
        }
        return stack.isEmpty();
    }

    private boolean isNotMatchingBrackets(char closingBracket, char openingBracket) {
        if (closingBracket == '}' && openingBracket == '{')
            return false;
        if (closingBracket == ')' && openingBracket == '(')
            return false;
        return closingBracket != ']' || openingBracket != '[';
    }

    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' ||  c == '{';
    }
}
