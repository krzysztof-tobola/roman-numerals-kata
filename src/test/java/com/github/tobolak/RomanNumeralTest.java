package com.github.tobolak;

import org.junit.Test;

import static com.github.tobolak.RomanNumeral.romanNumeral;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.assertThat;

public class RomanNumeralTest {

    @Test
    public void singleNumerals() {
        assertThat(romanNumeral(1), hasToString("I"));
        assertThat(romanNumeral(5), hasToString("V"));
        assertThat(romanNumeral(10), hasToString("X"));
        assertThat(romanNumeral(50), hasToString("L"));
        assertThat(romanNumeral(100), hasToString("C"));
        assertThat(romanNumeral(500), hasToString("D"));
        assertThat(romanNumeral(1000), hasToString("M"));
    }

    @Test
    public void shouldConvertAdditions() {
        assertThat(romanNumeral(2), hasToString("II"));
        assertThat(romanNumeral(3), hasToString("III"));
        assertThat(romanNumeral(6), hasToString("VI"));
        assertThat(romanNumeral(7), hasToString("VII"));
        assertThat(romanNumeral(8), hasToString("VIII"));
        assertThat(romanNumeral(11), hasToString("XI"));
        assertThat(romanNumeral(15), hasToString("XV"));
        assertThat(romanNumeral(17), hasToString("XVII"));
        assertThat(romanNumeral(20), hasToString("XX"));
        assertThat(romanNumeral(37), hasToString("XXXVII"));
        assertThat(romanNumeral(78), hasToString("LXXVIII"));
        assertThat(romanNumeral(278), hasToString("CCLXXVIII"));
        assertThat(romanNumeral(778), hasToString("DCCLXXVIII"));
        assertThat(romanNumeral(2778), hasToString("MMDCCLXXVIII"));
    }

    @Test
    public void subtraction() {
        assertThat(romanNumeral(4), hasToString("IV"));
        assertThat(romanNumeral(9), hasToString("IX"));
        assertThat(romanNumeral(29), hasToString("XXIX"));
        assertThat(romanNumeral(40), hasToString("XL"));
        assertThat(romanNumeral(41), hasToString("XLI"));
        assertThat(romanNumeral(94), hasToString("XCIV"));
        assertThat(romanNumeral(244), hasToString("CCXLIV"));
        assertThat(romanNumeral(434), hasToString("CDXXXIV"));
        assertThat(romanNumeral(1984), hasToString("MCMLXXXIV"));
        assertThat(romanNumeral(3999), hasToString("MMMCMXCIX"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void boundary() {
        romanNumeral(4000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lowerBoundary() {
        romanNumeral(0);
    }
}
