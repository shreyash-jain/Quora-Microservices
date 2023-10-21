package com.eureka.client.client.filterService;

import java.util.List;

// The SimpleFilter class implements a simple filtering strategy that replaces bad words with asterisks
public class SimpleFilter implements FilterStrategy {
    // A list of bad words to filter out
    private List<String> badWords;

    // The constructor takes a list of bad words as an argument
    public SimpleFilter(List<String> badWords) {
        this.badWords = badWords;
    }

    // The filter method iterates over the bad words list and replaces them with asterisks in the input
    public String filter(String input) {
        String output = input;
        for (String badWord : badWords) {
            output = output.replaceAll("(?i)" + badWord, "*".repeat(badWord.length()));
        }
        return output;
    }
}