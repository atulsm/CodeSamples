package org.example.basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestWordCount {
    @Test
    public void testWordCountNotUnique() {
        WordCount wordCount = new WordCount("Hello Hello Atul Atul");
        assert wordCount.countWords(false)==4;
    }

    @Test
    public void testWordCountUnique() {
        WordCount wordCount = new WordCount("Hello Hello Atul Atul");
        assert wordCount.countWords(true)==2;
    }

    @Test
    public void testWordRank() {
        WordCount wordCount = new WordCount("Hello Hello Hello Atul Atul Soman Soman Anjana");
        assert Arrays.asList("Hello").containsAll(wordCount.wordRank(1));
        assert Arrays.asList("Atul", "Soman").containsAll(wordCount.wordRank(2));
        assert Arrays.asList("Anjana").containsAll(wordCount.wordRank(3));
    }
}
