package com.github.tobolak.kotlin

private enum class Segment(val value: Int) {
    M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1)
}

fun Int.toRomanNumeral(): RomanNumeralKt {
    require(this in 1..3999)
    return RomanNumeralKt(romanString(this))
}

private fun romanString(remainder: Int): String = greatestSegmentNotExceeding(remainder)
        ?.let { it.name + romanString(remainder - it.value) }
        ?: ""

private fun greatestSegmentNotExceeding(value: Int) = Segment.values().firstOrNull { it.value <= value }

data class RomanNumeralKt(private val numeralString: String)
