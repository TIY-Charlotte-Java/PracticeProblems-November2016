package com.theironyard.charlotte;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ben on 12/13/16.
 */
public class MainTest {

    @Test
    public void isPalindrome() throws Exception {

    }

    @Test
    public void divisible() throws Exception {

    }

    @Test
    public void gimme() throws Exception {

    }

    @Test
    public void changeForMoney() throws Exception {

    }

    @Test
    public void balancedWorksGood() throws Exception {
        assertFalse(Main.balanced("creek", 'e')); // returns false
        assertTrue(Main.balanced("prrt", 'r'));  // returns true
        assertTrue(Main.balanced("wowx", 'w'));  // returns true
    }

    @Test
    public void boostWorksPurtyGood() throws Exception {
        assertEquals(53, Main.boost(42));
        assertEquals(3001, Main.boost(2990));
        assertEquals(0, Main.boost(999999999));
    }

    @Test
    public void simpleMathsTest() throws Exception {
        assertEquals(4, 2 + 2);
        assertTrue(true);

        assertEquals(1, (int)(1.05 % 2));
    }

    @Test
    public void silverTest() throws Exception {
        assertEquals(4, Main.silver(new int[] { 1, 2, 3, 4, 5}));
        assertEquals(-1, Main.silver(new int[] { -5, -4, -3, -2, -1, 0}));
    }

    @Test
    public void characterCountTest() throws Exception {
        assertEquals(2, Main.capitalized("Bass Hunter")); // 2
        assertEquals(5, Main.capitalized("ABCDEfghi")); // 5
        assertEquals(3, Main.capitalized("Mon Tues Wed")); // 3
    }

    @Test
    public void velmaFlipsPancakesKindaGoodSometimes() throws Exception {
        assertEquals(.8 * .8 * .8, Main.flipper(10000), .01);
    }
}