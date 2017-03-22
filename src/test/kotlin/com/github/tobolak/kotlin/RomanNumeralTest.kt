package com.github.tobolak.kotlin

import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class RomanNumeralTest {

    @Test
    fun singleNumerals() {
        assertThat(romanNumeral(1), isRoman("I"))
        assertThat(romanNumeral(5), isRoman("V"))
        assertThat(romanNumeral(10), isRoman("X"))
        assertThat(romanNumeral(50), isRoman("L"))
        assertThat(romanNumeral(100), isRoman("C"))
        assertThat(romanNumeral(500), isRoman("D"))
        assertThat(romanNumeral(1000), isRoman("M"))
    }

    @Test
    fun shouldConvertAdditions() {
        assertThat(romanNumeral(2), isRoman("II"))
        assertThat(romanNumeral(3), isRoman("III"))
        assertThat(romanNumeral(6), isRoman("VI"))
        assertThat(romanNumeral(7), isRoman("VII"))
        assertThat(romanNumeral(8), isRoman("VIII"))
        assertThat(romanNumeral(11), isRoman("XI"))
        assertThat(romanNumeral(15), isRoman("XV"))
        assertThat(romanNumeral(17), isRoman("XVII"))
        assertThat(romanNumeral(20), isRoman("XX"))
        assertThat(romanNumeral(37), isRoman("XXXVII"))
        assertThat(romanNumeral(78), isRoman("LXXVIII"))
        assertThat(romanNumeral(278), isRoman("CCLXXVIII"))
        assertThat(romanNumeral(778), isRoman("DCCLXXVIII"))
        assertThat(romanNumeral(2778), isRoman("MMDCCLXXVIII"))
    }

    @Test
    fun subtraction() {
        assertThat(romanNumeral(4), isRoman("IV"))
        assertThat(romanNumeral(9), isRoman("IX"))
        assertThat(romanNumeral(29), isRoman("XXIX"))
        assertThat(romanNumeral(40), isRoman("XL"))
        assertThat(romanNumeral(41), isRoman("XLI"))
        assertThat(romanNumeral(94), isRoman("XCIV"))
        assertThat(romanNumeral(244), isRoman("CCXLIV"))
        assertThat(romanNumeral(434), isRoman("CDXXXIV"))
        assertThat(romanNumeral(1984), isRoman("MCMLXXXIV"))
        assertThat(romanNumeral(3999), isRoman("MMMCMXCIX"))
    }

    private fun isRoman(s: String) = `is`(RomanNumeralKt(s))

    @Test(expected = IllegalArgumentException::class)
    fun boundary() {
        romanNumeral(4000)
    }

    @Test(expected = IllegalArgumentException::class)
    fun lowerBoundary() {
        romanNumeral(0)
    }

    private fun romanNumeral(i: Int) = i.toRomanNumeral();
}
