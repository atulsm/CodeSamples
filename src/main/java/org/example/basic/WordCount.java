package org.example.basic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class counts the number of words in a given input and print by frequency
    */

public class WordCount {

    private final String input;
    private final Map<String,Integer> wordMap = new HashMap<>();

    public WordCount(String input) {
        this.input = input;
        for (String word : input.split(" ")) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
    }
    /**
     * This method counts the number of words in a given input
        * @return the number of words in the input
        */
    public int countWords(boolean unique) {
        if(unique) {
            return wordMap.size();
        }else{
            return wordMap.values().stream().mapToInt(Integer::intValue).sum();
        }
    }

    /**
     * This method returns the word at a given rank
        * @param rank the rank of the word to return
        * @return the word at the given rank
        */
    public List<String> wordRank(int rank) {
        int countVal = wordMap.values().stream().distinct().sorted(Comparator.reverseOrder()).limit(rank).toList().get(rank-1);
        List<String> result = new ArrayList<>();

        //Iterate over map where value = countVal
        for(Map.Entry<String,Integer> entry : wordMap.entrySet()){
            if(entry.getValue() == countVal){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

