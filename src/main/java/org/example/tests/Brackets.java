package org.example.tests;

public class Brackets {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        return true;
    }
}
