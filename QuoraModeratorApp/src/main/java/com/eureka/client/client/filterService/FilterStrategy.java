package com.eureka.client.client.filterService;

// The Strategy interface defines the common behavior for all filtering strategies
public interface FilterStrategy {
    // The filter method takes a String input and returns a filtered String output
    public String filter(String input);
}