package ru.shara.restexample.model;

import java.util.List;
import java.util.Map;

public class Data {

    private String word;
    private List<Letters> stats;

    public Data(String word, List<Letters> stats) {
        this.word = word;
        this.stats = stats;
    }

    public String getWord() {
        return word;
    }

    public List<Letters> getStats() {
        return stats;
    }

}
