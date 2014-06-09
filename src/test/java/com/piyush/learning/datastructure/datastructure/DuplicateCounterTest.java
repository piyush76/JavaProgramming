package com.piyush.learning.datastructure.datastructure;

/**
 * Created by piyush on 6/5/14.
 */

import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;


public class DuplicateCounterTest {

    private static final String INPUT_TEXT = "The third-rate mind is only happy when it is thinking with the majority." +
            "The second-rate mind is only happy when it is thinking with the minority." +
            "The first-rate mind is only happy when it is thinking.";

    private static final String word1 = "third";
    private static final String word2 = "rate";
    private static final String word3 = "thinking";
    private static final String word4 = "is";


    @Test
    public void testPositiveScenario() {
        DuplicateCounter dc = new DuplicateCounter();
        Map<String, Integer> sortedByCountWords = dc.processGivenText(INPUT_TEXT);

        Assert.assertTrue(sortedByCountWords.size() == 13);

        Assert.assertTrue(sortedByCountWords.get(word1) == 1);
        Assert.assertTrue(sortedByCountWords.get(word2) == 3);
        Assert.assertTrue(sortedByCountWords.get(word3) == 3);
    }

    @Test
    public void testNegativeScenario() {
        DuplicateCounter dc = new DuplicateCounter();
        Map<String, Integer> sortedByCountWords = dc.processGivenText(INPUT_TEXT);

        Assert.assertNull(sortedByCountWords.get(word4));
    }

}