package com.abacus.util;

public class NumberToWordsConverter {
    private static final String[] ONES = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    
    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    
    private static final String[] THOUSANDS = {
            "", "thousand", "million", "billion"
    };
    
    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }
        
        String words = "";
        int i = 0;
        
        while (number > 0) {
            if (number % 1000 != 0) {
                words = convertLessThanOneThousand(number % 1000) + " " + THOUSANDS[i] + " " + words;
            }
            number /= 1000;
            i++;
        }
        
        return words.trim();
    }
    
    private static String convertLessThanOneThousand(int number) {
        String current;
        
        if (number % 100 < 20) {
            current = ONES[number % 100];
            number /= 100;
        } else {
            current = ONES[number % 10];
            number /= 10;
            
            current = TENS[number % 10] + (current.isEmpty() ? "" : "-" + current);
            number /= 10;
        }
        
        if (number == 0) {
            return current;
        }
        
        return ONES[number] + " hundred" + (current.isEmpty() ? "" : " " + current);
    }
}