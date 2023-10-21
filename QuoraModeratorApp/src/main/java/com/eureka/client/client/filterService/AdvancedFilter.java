package com.eureka.client.client.filterService;

import java.util.List;

// The AdvancedFilter class implements an advanced filtering strategy that uses natural language processing to detect and censor bad words
public class AdvancedFilter implements FilterStrategy {
    // A natural language processing library to use for filtering
    private NLP nlp;

    // The constructor takes an NLP library as an argument
    public AdvancedFilter(NLP nlp) {
        this.nlp = nlp;
    }

    // The filter method uses the NLP library to analyze the input and censor any offensive words or phrases
    public String filter(String input) {
        String output = input;
        // Use the NLP library to get a list of offensive tokens from the input
        List<Token> offensiveTokens = nlp.getOffensiveTokens(input);
        // Replace each offensive token with asterisks in the output
        for (Token token : offensiveTokens) {
            output = output.replace(token.getText(), "*".repeat(token.getLength()));
        }
        return output;
    }
}