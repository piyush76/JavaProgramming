package com.piyush.learning.datastructure.datastructure;

/**
 * Created by piyush on 6/3/14.
 *
 * How will you go about writing code for counting the number of repeated words in the order of decreasing count for a given text input?
 *
 *  input text = "The third-rate mind is only happy when it is thinking with the majority.
 *  The second-rate mind is only happy when it is thinking with the minority. The first-rate mind is only happy when it is thinking."
 *
 *
 *  Analyze the requirements properly by asking the right questions?
 *  How are the words tokenized? by whitespace character only,
 *  white space and punctuations, how about URLs? , etc,
 *  The regular expression can be used for splitting the text. [ignore URL to keep it simple]
 *  Are there any common words that need to be ignored? For example, 'the', 'a', 'or', 'and', etc. [yes]
 *  Is it case sensitive? Should word and WORD be treated as the same word? [yes]
 *
 */

import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

public final class DuplicateCounter {

    private static final String REGEX_TO_SPLIT_TEXT_BY_WHITESPACE_AND_PUNCTUATION = "([.,!?:;'\"-]|\\s)+";

    private static final String[] WORDS_TO_IGNORE = {"is", "the", "a", "or", "and"};

    // keep it short for demo

    public Map<String, Integer> processGivenText(String text) {
        //pre-condition check
        if (text == null) {
            throw new IllegalArgumentException("The input text cannot be null ");
        }

        //split the text into words
        String[] tokenizedWords = text.split(REGEX_TO_SPLIT_TEXT_BY_WHITESPACE_AND_PUNCTUATION);

        Map<String, Integer> readWords = new HashMap<String, Integer>(100);

        for (String word : tokenizedWords) {
            word = word.toLowerCase(); // make it case insensitive

            //if one of the words to be ignored, move on to the next word

            if (Arrays.asList(WORDS_TO_IGNORE).contains(word)) {
                continue;
            }

            if (readWords.containsKey(word)) {
                int count = readWords.get(word);
                readWords.put(word, count + 1); // store incremented count
            } else {
                readWords.put(word, 1);
            }
        }

        // return the sorted LinkedMap
        return sortByValue(readWords);

    }


    /**
     * Sort the given map by its value i.e. count as opposed to key
     *
     * @param unsortedMap
     * @return
     */
    private Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {

        List<Map.Entry<String, Integer>> sortedKeyList = new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());

        //anonymous inner class to sort using a Comparator

        Collections.sort(sortedKeyList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return -e1.getValue().compareTo(e2.getValue());
            }
        });

        //LinkedHashmap maintains the order in which the elements were added
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>(unsortedMap.size());
        for (Entry<String, Integer> entry : sortedKeyList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) {

        String str = "\"The third-rate mind is only happy when it is thinking with the majority. The second-rate mind is only happy when it is thinking with the minority. The first-rate mind is only happy when it is thinking.";

        Map<String, Integer> sortedByCountWords = new DuplicateCounter().processGivenText(str);

        // print word and its counts
        for (Map.Entry<String, Integer> entry : sortedByCountWords.entrySet()) {
            System.out.format("word '%s' counted  %s  time(s) \n", entry.getKey(), entry.getValue());
        }
    }


}






