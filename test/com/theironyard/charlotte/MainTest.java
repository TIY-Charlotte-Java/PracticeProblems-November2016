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
        assertEquals(.8 * .8 * .8, Main.flipper(1000000), .1);
    }

    @Test
    public void monteCarloPiWorks() throws Exception {
        assertEquals(3.1415926535, Main.monteCarloPi(1000), .51);
    }


    @Test
    public void blendBlendsColors() throws Exception {
        Color[] colors = new Color[2];

        colors[0] = new Color(255, 0, 0);
        colors[1] = new Color(0, 0, 255);

        assertEquals(new Color(127, 0, 127), Main.blend(colors));
    }

    @Test
    public void longXReturnsLengthOfLongestXRun() throws Exception {
        assertEquals(4, Main.longx("asdxxxxf")); // returns 4
        assertEquals(1, Main.longx("xa")); // return 1
        assertEquals(1, Main.longx("xpxpxpxpxp")); // return 1
        assertEquals(5, Main.longx("xxpxxxxxp")); // return 5
    }

    @Test
    public void reverse() throws Exception {
        assertEquals("stnaP", Main.reverse("Pants"));
        assertEquals("racecar", Main.reverse("racecar"));
        assertEquals("cba", Main.reverse("abc"));
    }

    @Test
    public void restaurantHouses() throws Exception {
        assertEquals(2, Main.desirable("RHHHH"));
        assertEquals(3, Main.desirable("RHHHR"));
    }

    @Test
    public void titleCaseTitleCasesWordsPrettyGood() throws Exception {
        assertEquals("San  Diego", Main.headerliner("sAn  DIEGO"));
        assertEquals("San-francisco", Main.headerliner("san-francisco"));
        assertEquals("Where The Red Fern Grows", Main.headerliner("where the red fern grows"));
        assertEquals("Chicken Pot Pie", Main.headerliner("chICkEn PoT PIE"));
    }

    @Test
    public void nemoSurviveSometimes() throws Exception {
        Main.simulateNemo();
    }

    @Test
    public void luckyNumberSlevin() throws Exception {
//        assertEquals(2, Main.sevenCount("717"));
        assertEquals(1, Main.sevenCount("BananaPant7s"));
//        assertEquals(0, Main.sevenCount("100"));

    }

    @Test
    public void narcissistic() throws Exception {
        assertTrue(Main.narcissistic(153));
        assertTrue(Main.narcissistic(1634));
    }

    @Test
    public void roseBudTest() throws Exception {
        assertEquals(0, Main.rosebud("rosebud!o!!1"));
        assertEquals(0, Main.rosebud("osebud!!!!1"));
        assertEquals(1, Main.rosebud("rosebud!1"));
        assertEquals(5, Main.rosebud("rosebud!!!!!1"));
    }

    @Test
    public void heatIndicator() throws Exception {
        assertEquals(new Color(255, 0, 0), Main.heat(100));
        assertEquals(new Color(0, 0, 255), Main.heat(0));
        assertEquals(new Color(255 / 2, 0, 255 / 2), Main.heat(50));
    }
}