package com.eureka.client.client.filterService;

import java.util.List;

public class Moderator {
    // The current filtering strategy
    private List<FilterStrategy> filterStrategy;

    // The constructor takes a filtering strategy as an argument
    public Moderator(List<FilterStrategy> filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    // The setFilterStrategy method allows changing the filtering strategy at runtime
    public void setFilterStrategy(List<FilterStrategy> filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    // The moderate method takes a comment as an input and returns a moderated comment as an output
    public String moderate(String comment) {
        for (FilterStrategy strategy : filterStrategy) {
            comment = strategy.filter(comment);
        }
        return comment;
    }
}