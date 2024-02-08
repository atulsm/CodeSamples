package org.example.wordmath;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWordMath {

    @Test
    public void testWordMath() {
        WordMath wordMath = new WordMath();
        assert wordMath.calculate("one plus one")==2;
        assertEquals(wordMath.calculate("two minus one"), 1);
    }
}
