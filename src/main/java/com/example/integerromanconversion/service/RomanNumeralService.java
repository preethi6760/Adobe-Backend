package com.example.integerromanconversion.service;
import org.springframework.stereotype.Service;
@Service
public class RomanNumeralService {

    private static final String[] ROMAN_NUMERALS = {
            "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
    };

    private static final int[] NUMERIC_VALUES = {
            1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
    };

    public String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Input must be between 1 and 3999.");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = NUMERIC_VALUES.length - 1; i >= 0; i--) {
            while (num >= NUMERIC_VALUES[i]) {
                roman.append(ROMAN_NUMERALS[i]);
                num -= NUMERIC_VALUES[i];
            }
        }

        return roman.toString();
    }
}

